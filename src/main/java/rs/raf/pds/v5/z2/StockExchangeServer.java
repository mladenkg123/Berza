package rs.raf.pds.v5.z2;

import io.grpc.Server;



import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import rs.raf.pds.v5.z2.gRPC.AskRequest;
import rs.raf.pds.v5.z2.gRPC.BidRequest;
import rs.raf.pds.v5.z2.gRPC.BuyOffer;
import rs.raf.pds.v5.z2.gRPC.BuyRequest;
import rs.raf.pds.v5.z2.gRPC.BuyResponse;
import rs.raf.pds.v5.z2.gRPC.CompanySharesRequest;
import rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest;
import rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest;
import rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse;
import rs.raf.pds.v5.z2.gRPC.OrderRequest;
import rs.raf.pds.v5.z2.gRPC.OrderResponse;
import rs.raf.pds.v5.z2.gRPC.SellOffer;
import rs.raf.pds.v5.z2.gRPC.SellRequest;
import rs.raf.pds.v5.z2.gRPC.SellResponse;
import rs.raf.pds.v5.z2.gRPC.StockData;
import rs.raf.pds.v5.z2.gRPC.StockExchangeServiceGrpc.StockExchangeServiceImplBase;
import rs.raf.pds.v5.z2.gRPC.StockRequest;
import rs.raf.pds.v5.z2.gRPC.TradingTransaction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StockExchangeServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8090)
                .addService(new StockExchangeServiceImpl())
                .build();

        server.start();
        System.out.println("StockExchangeServer started on port 8090");
        
        startSimulationThread();     
        startTransactionLogThread();
       
        server.awaitTermination();
    }
    
    
    
    private static final CopyOnWriteArrayList<StreamObserver<StockData>> observers = new CopyOnWriteArrayList<>();
    private static final String TRANSACTION_LOG_FILE = "transaction_log.txt";
        
    private static void startSimulationThread() {
        new Thread(() -> {
            try {
                while (true) {
                	//System.out.println(observers.size());
                    StockExchangeServiceImpl.updateStockPrices();
                    Thread.sleep(20000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void startTransactionLogThread() {
        new Thread(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTION_LOG_FILE, true))) {
                while (true) {
                    if (!transactionQueue.isEmpty()) {
                        //.take()
                        Transaction transaction = transactionQueue.poll();
                        while (transaction != null) {
                            writer.write(transaction.toString());
                            writer.newLine();
                            transaction = transactionQueue.poll();
                        }
                        writer.flush();
                    }
                    Thread.sleep(50000); 
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

   

    
    
    

    static class StockExchangeServiceImpl extends StockExchangeServiceImplBase {

    	
        private static  CopyOnWriteArrayList<StockData> stockDataArray = new CopyOnWriteArrayList<StockData>();
        private static final ConcurrentMap<StreamObserver<StockData>,CopyOnWriteArrayList<StockData>> ObserverSymbolMap = new ConcurrentHashMap<>();
        private static final ConcurrentMap<String, CopyOnWriteArrayList<BuyRequest>> BuyMap = new ConcurrentHashMap<>();
        private static final ConcurrentMap<String, CopyOnWriteArrayList<SellRequest>> SellMap = new ConcurrentHashMap<>();
        private static final ConcurrentMap<String, StockData> SymbolMap = new ConcurrentHashMap<>(); 
        private static final ConcurrentMap<String, StreamObserver<GenerateClientIdResponse>> clients = new ConcurrentHashMap<>();
        private static final ConcurrentMap<String, ConcurrentMap<String, Integer>> clientBalance = new ConcurrentHashMap<>();
        private final AtomicInteger clientIdCounter = new AtomicInteger(1);


        static {
        	
        	for (StockData data : InitialData.initStocks()) {
        		
        		SymbolMap.put(data.getSymbol(), data);
        		stockDataArray.add(data);
        		
        	}
        	
        }

        ///////////////////////////////TCP//////////////////////////////////////////////
        
        protected StockExchangeServiceImpl() {
        	startTcpServer();
        }
        
        private  void startTcpServer() {
            new Thread(() -> {
                try (ServerSocket serverSocket = new ServerSocket(8080)) {
                    System.out.println("TCP Server started on port 8080");
                    while (true) {
                        Socket clientSocket = serverSocket.accept();
                        new Thread(() -> handleTcpConnection(clientSocket)).start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        
        private  void handleTcpConnection(Socket clientSocket) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                   
                    String[] message = clientMessage.split(" ");
                    System.out.println("Received from client: " + clientMessage);
               
                    if (message.length > 0 && message != null) {
                    	String action = message[0];
                    	String symbol = message[1];
                    	double price = Double.parseDouble(message[2]);
                    	int quantity = Integer.parseInt(message[3]);
                    	     
                    	if (action == "buy") {
                    		BuyRequest request1 = BuyRequest.newBuilder()
                        			.setCompanySymbol(symbol)
                        			.setPricePerShare(price)
                        			.setQuantity(quantity)
                        			.build();
                    		doBuyAction(request1);
                    	} else if (action == "sell") {
                    		SellRequest request2 = SellRequest.newBuilder()
                    				.setCompanySymbol(symbol)
                        			.setPricePerShare(price)
                        			.setQuantity(quantity)
                        			.build();
                    		doSellAction(request2);
                    	}
                    	                  
                    }       
                    String response = ("Response");
               
                    out.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ///////////////////////////////TCP//////////////////////////////////////////////
 
        @Override
        public void getStockData(StockRequest request, StreamObserver<StockData> responseObserver) {
            observers.add(responseObserver);

            for (StockData stockData : SymbolMap.values()) {
                responseObserver.onNext(stockData);
            }

           

            responseObserver.onCompleted();
            observers.remove(responseObserver);
        }
           
        private static void updateStockPrices() {
            Random random = new Random();
            System.out.println("_-_-_-_-_-_-_-");
            System.out.println(SellMap);
            System.out.println("*****************");
    		System.out.println(BuyMap);
    	    System.out.println("_-_-_-_-_-_-_-");
            for (String Symbol : SymbolMap.keySet()) {
                StockData value = SymbolMap.get(Symbol);
                
                double percentageChange = (random.nextDouble() - 0.5) * 2.0;

                StockData newStock = StockData.newBuilder()
                        .setSymbol(value.getSymbol())
                        .setCompanyName(value.getCompanyName())
                        .setPrice(value.getPrice() * (1 + percentageChange / 100.0))
                        .setChange(percentageChange)
                        .setDate(value.getDate())
                        .build();
                
                
                SymbolMap.put(Symbol, newStock);
                
            }                      
            stockDataArray = new CopyOnWriteArrayList<StockData>(SymbolMap.values());
      
            notifyClients(stockDataArray);
        }

                      
        
        private static void notifyClients(CopyOnWriteArrayList<StockData> stockDataArray) {
            synchronized (observers) {
                for (StreamObserver<StockData> observer : observers) {
                    List<StockData> followedStocks = ObserverSymbolMap.get(observer);

                    for (StockData stockData : stockDataArray) {
                        if (containsStockData(followedStocks, stockData)) {
                            System.out.println("nesto2");
                            observer.onNext(stockData);
                        }
                    }
                }
            }
        }
        
        
        private static boolean containsStockData(List<StockData> stockList, StockData targetStock) {
            for (StockData stock : stockList) {
                // Compare fields for equality
                if (stock.getSymbol().equals(targetStock.getSymbol())) {
                    return true;
                }
            }
            return false;
        }
                      
            
        
        
        @Override
        public void updateFollowedSymbols(FollowedSymbolsRequest request,StreamObserver<StockData> responseObserver) {
            observers.add(responseObserver);
            
            CopyOnWriteArrayList<String> symbolsToFollow = new CopyOnWriteArrayList<String>();
         

            
             for (String symbol : request.getSymbolsList()) {
            	 symbolsToFollow.add(symbol);
             }
        
             CopyOnWriteArrayList<StockData> updatedFollowedStocks = stockDataArray.stream()
            	        .filter(stock -> symbolsToFollow.contains(stock.getSymbol()))
            	        .collect(Collectors.toCollection(CopyOnWriteArrayList::new));

            	ObserverSymbolMap.put(responseObserver, updatedFollowedStocks);

            
                  
        }                   
        
        @Override
        public void ask(AskRequest request, StreamObserver<SellOffer> responseObserver) {
          
                                       
            List<SellRequest> SellOffers = SellMap.entrySet().stream()
        	        .filter(entry -> entry.getKey().equals(request.getCompanySymbol()))
        	        .map(Map.Entry::getValue)
        	        .findFirst()
        	        .orElse(new CopyOnWriteArrayList<>());
            
            SellOffers.sort(Comparator.comparingDouble(SellRequest::getPricePerShare));
            
            
            List<SellRequest> first10Offers = SellOffers.stream().limit(request.getNumberOfOffers()).collect(Collectors.toList());

            for (SellRequest sellOffer : first10Offers) {
            	
            	SellOffer saleOffer = SellOffer.newBuilder()
            			.setPrice(sellOffer.getPricePerShare())
            			.setQuantity(sellOffer.getQuantity())
            			.build();
            	
                responseObserver.onNext(saleOffer);
            }

            responseObserver.onCompleted();
        }
        
        @Override
        public void bid(BidRequest request, StreamObserver<BuyOffer> responseObserver) {
                   
            List<BuyRequest> BuyOffers = BuyMap.entrySet().stream()
        	        .filter(entry -> entry.getKey().equals(request.getCompanySymbol()))
        	        .map(Map.Entry::getValue)
        	        .findFirst()
        	        .orElse(new CopyOnWriteArrayList<>());
            
            BuyOffers.sort(Comparator.comparingDouble(BuyRequest::getPricePerShare).reversed());
            
            
            List<BuyRequest> first10Offers = BuyOffers.stream().limit(request.getNumberOfOffers()).collect(Collectors.toList());

            for (BuyRequest buyOffer : first10Offers) {
            	
            	BuyOffer buyOffer1 = BuyOffer.newBuilder()
            			.setPrice(buyOffer.getPricePerShare())
            			.setQuantity(buyOffer.getQuantity())
            			.build();
            	
                responseObserver.onNext(buyOffer1);
            }

            responseObserver.onCompleted();
        }
            
        
         
     
        
       
             
        
        @Override
        public void buy(BuyRequest request, StreamObserver<BuyResponse> responseObserver) {
              
        	doBuyAction(request); 
                   	          
            BuyResponse buyResp = BuyResponse.newBuilder()
            		   .setSuccess(true)
            		   .setMessage("Your order has been fullfiled")
            		   .build();
            
            responseObserver.onNext(buyResp);
            responseObserver.onCompleted();
        }
        
        public void doBuyAction(BuyRequest request) {
        	CopyOnWriteArrayList<BuyRequest> BuyList = BuyMap.entrySet().stream()
        	        .filter(entry -> entry.getKey().equals(request.getCompanySymbol()))
        	        .map(Map.Entry::getValue)
        	        .findFirst()
        	        .orElse(new CopyOnWriteArrayList<>());


            BuyList.add(BuyRequest.newBuilder()               
            		.setCompanySymbol(request.getCompanySymbol())
                    .setPricePerShare(request.getPricePerShare())
                    .setQuantity(request.getQuantity())
                    .setClientId(request.getClientId())
                    .build());

            BuyMap.put(request.getCompanySymbol(), BuyList);    	
        }

        @Override
        public void sell(SellRequest request, StreamObserver<SellResponse> responseObserver) {
        	
        	if (clientBalance.get(request.getClientId()).get(request.getCompanySymbol()) >= request.getQuantity()) {
        	
                doSellAction(request);
                
                SellResponse sellResp = SellResponse.newBuilder()
                		   .setSuccess(true)
                		   .setMessage("Your order has been fullfiled")
                		   .build();
                      
                responseObserver.onNext(sellResp);
                responseObserver.onCompleted();
        	} else {
        		 SellResponse sellResp = SellResponse.newBuilder()
              		   .setSuccess(false)
              		   .setMessage("You don't have enough stocks in your client.")
              		   .build();
                    
              responseObserver.onNext(sellResp);
              responseObserver.onCompleted();
        	}
        	
        	        	
        }
        
        public void doSellAction(SellRequest request) {
        	CopyOnWriteArrayList<SellRequest> SellList = SellMap.entrySet().stream()
        	        .filter(entry -> entry.getKey().equals(request.getCompanySymbol()))
        	        .map(Map.Entry::getValue)
        	        .findFirst()
        	        .orElse(new CopyOnWriteArrayList<>());
               

            SellList.add(SellRequest.newBuilder()               
            		.setCompanySymbol(request.getCompanySymbol())
                    .setPricePerShare(request.getPricePerShare())
                    .setQuantity(request.getQuantity())
                    .setClientId(request.getClientId())
                    .build());

            SellMap.put(request.getCompanySymbol(), SellList);
        }
        
        @Override
        public void submitOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
            System.out.println(request.getBuyOrSell());
        	//submit buy AAPL 99.9 10
            
            CopyOnWriteArrayList<SellRequest> sellRequests = SellMap.get(request.getCompanySymbol());
            CopyOnWriteArrayList<BuyRequest> buyRequests = BuyMap.get(request.getCompanySymbol());
        	ConcurrentMap<String, Integer> newClientBalance = clientBalance.get(request.getClientId());
        	int balance = clientBalance.get(request.getClientId()).get(request.getCompanySymbol());
        	LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            String formattedDate = currentDate.format(formatter);
            
            System.out.println(formattedDate);

    		if(sellRequests == null) {
    			sellRequests = new CopyOnWriteArrayList<SellRequest>();
    		}
    		if(buyRequests == null) {
    			buyRequests = new CopyOnWriteArrayList<BuyRequest>();
    		}
            
        	if (request.getBuyOrSell().equals("buy")) {
        		
        	      		
        		System.out.println(buyRequests);
        		System.out.println(sellRequests);
    								
 		        for (SellRequest sr : sellRequests ) {
 		        	
 		        	if(!request.getClientId().equals(sr.getClientId()) && request.getPricePerShare() == (sr.getPricePerShare())) {
 		        		
 		        		if(request.getQuantity() < sr.getQuantity()) {
 		        			
 		        			int newQuantity = sr.getQuantity() - request.getQuantity();
 		        			SellRequest newOrder = SellRequest.newBuilder()
 		        					.setClientId(sr.getClientId())
 		        					.setCompanySymbol(sr.getCompanySymbol())
 		        					.setPricePerShare(sr.getPricePerShare())
 		        					.setQuantity(newQuantity)
 		        					.build();
 		        			
 		        			sellRequests.set(sellRequests.indexOf(sr), newOrder);
 		        			
 		        			///////////NOTIFY
 		        			GenerateClientIdResponse b = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + request.getCompanySymbol() + request.getPricePerShare() + request.getQuantity())
 		        					.build();
 		        			
 		        			StreamObserver<GenerateClientIdResponse> buyObserver = clients.get(request.getClientId());
 		        			
 		        			buyObserver.onNext(b);
 		        			
 		        			GenerateClientIdResponse s = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + sr.getCompanySymbol() + sr.getPricePerShare() + newQuantity)
 		        					.build();
 		        			
 		        			StreamObserver<GenerateClientIdResponse> sellObserver = clients.get(sr.getClientId());
 		        			
 		        			sellObserver.onNext(s);
 		        			
 		        			
 		        			////BALANCE
 		        			balance = balance + request.getQuantity();
 		        			//Transaction u txt
 		        			logTransaction(new Transaction(request.getClientId(), sr.getClientId(), request.getCompanySymbol(), request.getPricePerShare(), request.getQuantity(),formattedDate));
 		        			
 		        		} else if (request.getQuantity() > sr.getQuantity()){
 		        			int newQuantity = request.getQuantity() - sr.getQuantity();
; 		        			BuyRequest newOrder = BuyRequest.newBuilder()
 		        					.setClientId(request.getClientId())
 		        					.setCompanySymbol(request.getCompanySymbol())
 		        					.setPricePerShare(request.getPricePerShare())
 		        					.setQuantity(newQuantity)
 		        					.build();
 		        			buyRequests.add(newOrder);
 		        			sellRequests.remove(sr);
 		        			//notifty
 		        			
 		        			GenerateClientIdResponse b = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + request.getCompanySymbol() + request.getPricePerShare() + newQuantity)
 		        					.build();
 		        			
 		        			StreamObserver<GenerateClientIdResponse> buyObserver = clients.get(request.getClientId());
 		        			
 		        			buyObserver.onNext(b);
 		        			
 		        			GenerateClientIdResponse s = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + sr.getCompanySymbol() + sr.getPricePerShare() + sr.getQuantity())
 		        					.build();
 		        			
 		        			StreamObserver<GenerateClientIdResponse> sellObserver = clients.get(sr.getClientId());
 		        			
 		        			sellObserver.onNext(s);
 		        			
 		        			balance = balance + sr.getQuantity();
 		        			
 		                    logTransaction(new Transaction(request.getClientId(), sr.getClientId(), request.getCompanySymbol(), request.getPricePerShare(), request.getQuantity(),formattedDate));

 		        		} else {
 		        			sellRequests.remove(sr);
 		        			//notify
 		        			
 		        			GenerateClientIdResponse b = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + request.getCompanySymbol() + request.getPricePerShare() + request.getQuantity())
 		        					.build();	
 		        			
 		        			StreamObserver<GenerateClientIdResponse> buyObserver = clients.get(request.getClientId());
 		        			
 		        			buyObserver.onNext(b);
 		        			
 		        			GenerateClientIdResponse s = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + sr.getCompanySymbol() + sr.getPricePerShare() + sr.getQuantity())
 		        					.build();
 		        			
 		        			StreamObserver<GenerateClientIdResponse> sellObserver = clients.get(sr.getClientId());
 		        			
 		        			sellObserver.onNext(s);
 		        			
 		        			balance = balance + request.getQuantity();
 		                    logTransaction(new Transaction(request.getClientId(), sr.getClientId(), request.getCompanySymbol(), request.getPricePerShare(), request.getQuantity(),formattedDate));

 		        		}
 		        		
 		        	}
 		        	
 		        }  
				
        	}       
        	//submit sell AAPL 50 100
        	
        	if (request.getBuyOrSell().equals("sell") && newClientBalance.get(request.getCompanySymbol()) >= request.getQuantity()) {
        		        		
        		System.out.println(buyRequests);
        		System.out.println(sellRequests);
        		
        	 if (balance > request.getQuantity()) {
        		for (BuyRequest br : buyRequests ) {
 		        	
 		        	if(!request.getClientId().equals(br.getClientId()) && request.getPricePerShare() == (br.getPricePerShare())) {
 		        		
 		        		if(request.getQuantity() < br.getQuantity()) {
 		        			
 		        			int newQuantity = br.getQuantity() - request.getQuantity();
 		        			BuyRequest newOrder = BuyRequest.newBuilder()
 		        					.setClientId(br.getClientId())
 		        					.setCompanySymbol(br.getCompanySymbol())
 		        					.setPricePerShare(br.getPricePerShare())
 		        					.setQuantity(newQuantity)
 		        					.build();
 		        			
 		        			buyRequests.set(buyRequests.indexOf(br), newOrder);
 		        			
 		        			//notifyTrade()
 		        			
 		        			GenerateClientIdResponse a = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + br.getCompanySymbol() + br.getPricePerShare() + newQuantity)
 		        					.build();
 		        			
 		        			StreamObserver<GenerateClientIdResponse> buyObserver = clients.get(br.getClientId());
 		        			
 		        			buyObserver.onNext(a);
 		        			
 		        			GenerateClientIdResponse b = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + request.getCompanySymbol() + request.getPricePerShare() + request.getQuantity())
 		        					.build();		    
 		        			
 		        			StreamObserver<GenerateClientIdResponse> sellObserver = clients.get(request.getClientId());
 		        			
 		        			sellObserver.onNext(b);
 		        			
 		        			balance = balance  - request.getQuantity();
 	                        logTransaction(new Transaction(br.getClientId(), request.getClientId(), request.getCompanySymbol(), request.getPricePerShare(), request.getQuantity(),formattedDate));

 		        			
 		        		} else if (request.getQuantity() > br.getQuantity()){
 		        			int newQuantity = request.getQuantity() - br.getQuantity();
		        			SellRequest newOrder = SellRequest.newBuilder()
 		        					.setClientId(request.getClientId())
 		        					.setCompanySymbol(request.getCompanySymbol())
 		        					.setPricePerShare(request.getPricePerShare())
 		        					.setQuantity(newQuantity)
 		        					.build();
							sellRequests.add(newOrder);
 		        			buyRequests.remove(br);
 		        			//notifty
 		        			GenerateClientIdResponse b = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + br.getCompanySymbol() + br.getPricePerShare() + br.getQuantity())
 		        					.build();	
 		        			
 		        			StreamObserver<GenerateClientIdResponse> buyObserver = clients.get(br.getClientId());
 		        			
 		        			buyObserver.onNext(b);
 		        			
 		        			GenerateClientIdResponse a = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + request.getCompanySymbol() + request.getPricePerShare() + newQuantity)
 		        					.build();
 		        			
 		        			StreamObserver<GenerateClientIdResponse> sellObserver = clients.get(request.getClientId());
 		        			
 		        			sellObserver.onNext(a);
 		        			
 		        			balance = balance - br.getQuantity();
 	                        logTransaction(new Transaction(br.getClientId(), request.getClientId(), request.getCompanySymbol(), request.getPricePerShare(), request.getQuantity(),formattedDate));

 		        			
 		        		} else {
 		        			buyRequests.remove(br);
 		        			//notify
 		        			GenerateClientIdResponse b = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + br.getCompanySymbol() + br.getPricePerShare() + br.getQuantity())
 		        					.build();
 		        			
 		        			StreamObserver<GenerateClientIdResponse> buyObserver = clients.get(br.getClientId());
 		        			
 		        			buyObserver.onNext(b);
 		        			
 		        			GenerateClientIdResponse s = GenerateClientIdResponse.newBuilder()
 		        					.setMessage("Your transaction is completed." + request.getCompanySymbol() + request.getPricePerShare() + request.getQuantity())
 		        					.build();	
 		        			
 		        			StreamObserver<GenerateClientIdResponse> sellObserver = clients.get(request.getClientId());
 		        			
 		        			sellObserver.onNext(s);
 		        			balance = balance - br.getQuantity();
 	                        logTransaction(new Transaction(br.getClientId(), request.getClientId(), request.getCompanySymbol(), request.getPricePerShare(), request.getQuantity(),formattedDate));
 		        		}
 		        		
 		        	}
 		        	
 		        }        		        	       
        	}}else {
        		GenerateClientIdResponse poruka = GenerateClientIdResponse.newBuilder()
     					.setMessage("You don't have enough balance for this transaction")
     					.build();
     			
     			StreamObserver<GenerateClientIdResponse> pk = clients.get(request.getClientId());
     			
     			pk.onNext(poruka);
        	}
        	System.out.println(balance);
        	SellMap.put(request.getCompanySymbol(), sellRequests);
        	BuyMap.put(request.getCompanySymbol(), buyRequests);
			/////////////////////////////////////////UPDATING BALANCE OF THE CLIENT//////////////////////
			newClientBalance.put(request.getCompanySymbol(), balance);
			
			clientBalance.put(request.getClientId(), newClientBalance);
			/////////////////////////////////////////UPDATING BALANCE OF THE CLIENT//////////////////////
            //responseObserver.onCompleted();
        }
        
        
        
        @Override
        public void generateClientId(GenerateClientIdRequest request, StreamObserver<GenerateClientIdResponse> responseObserver) {
          
            String clientId = "Client" + clientIdCounter.getAndIncrement();
            int initCb = 1000;
            
        
            GenerateClientIdResponse response = GenerateClientIdResponse.newBuilder()
                    .setClientId(clientId)
                    .setBalance(initCb)
                    .build();
            
            ConcurrentMap<String, Integer> copyMap = new ConcurrentHashMap<>();

          
            for (String symbol : SymbolMap.keySet()) {
                       
            	copyMap.put(symbol,initCb);                 
            }
                         
            clientBalance.put(clientId, copyMap);
            clients.put(clientId, responseObserver);
            
            responseObserver.onNext(response);
            //responseObserver.onCompleted();
        }
        
        
       
        public void getCompanyShares(CompanySharesRequest request, StreamObserver<TradingTransaction> responseObserver) {
            String companySymbol = request.getCompanySymbol();
            String date = request.getDate();
       
            System.out.println(date + "AAAAA");
            for (Transaction transaction : transactionList) {
                if (transaction.getCompanySymbol().equals(companySymbol) && transaction.getDate().equals(date)) {
                    TradingTransaction tradingTransaction = TradingTransaction.newBuilder()
                            .setBuyerClientId(transaction.getClientId1())
                            .setSellerClientId(transaction.getClientId2())
                            .setCompanySymbol(transaction.getCompanySymbol())
                            .setPricePerShare(transaction.getPricePerShare())
                            .setQuantity(transaction.getQuantity())
                            .setDate(transaction.getDate())
                            .build();

                    responseObserver.onNext(tradingTransaction);
                }
            }

            responseObserver.onCompleted();
        }

                       
 }
    private static final BlockingQueue<Transaction> transactionQueue = new LinkedBlockingQueue<>();
    private static final CopyOnWriteArrayList<Transaction> transactionList = new CopyOnWriteArrayList<>();

    public static void logTransaction(Transaction transaction) {
        try {
            transactionQueue.put(transaction);
            transactionList.add(transaction);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static class Transaction {
        private final String clientId1;
        private final String clientId2;
        private final String companySymbol;
        private final double pricePerShare;
        private final int quantity;
        private final String date;

        public Transaction(String clientId1, String clientId2, String companySymbol, double pricePerShare, int quantity, String date) {
            this.clientId1 = clientId1;
            this.clientId2 = clientId2;
            this.companySymbol = companySymbol;
            this.pricePerShare = pricePerShare;
            this.quantity = quantity;
            this.date = date;
        }
        
        public String getClientId1() {
            return clientId1;
        }
        public String getClientId2() {
            return clientId2;
        }


        public String getCompanySymbol() {
            return companySymbol;
        }
   
        public double getPricePerShare() {
            return pricePerShare;
        }

        public int getQuantity() {
            return quantity;
        }

        public String getDate() {
            return date;
        }
        @Override
        public String toString() {
            return String.format("Transaction: %s %s %s %.2f %d %s", companySymbol, clientId1, clientId2, pricePerShare, quantity, date);
        }
    }
 
      
}
