package rs.raf.pds.v5.z2;

import io.grpc.Server;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.AskRequest;
import rs.raf.pds.v5.z2.gRPC.BidRequest;
import rs.raf.pds.v5.z2.gRPC.BuyOffer;
import rs.raf.pds.v5.z2.gRPC.BuyRequest;
import rs.raf.pds.v5.z2.gRPC.BuyResponse;
import rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest;
import rs.raf.pds.v5.z2.gRPC.SellOffer;
import rs.raf.pds.v5.z2.gRPC.SellRequest;
import rs.raf.pds.v5.z2.gRPC.SellResponse;
import rs.raf.pds.v5.z2.gRPC.StockData;
import rs.raf.pds.v5.z2.gRPC.StockExchangeServiceGrpc.StockExchangeServiceImplBase;
import rs.raf.pds.v5.z2.gRPC.StockRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class StockExchangeServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8090)
                .addService(new StockExchangeServiceImpl())
                .build();

        server.start();
        System.out.println("StockExchangeServer started on port 8090");
        
        startSimulationThread();

       
        server.awaitTermination();
    }
    
   
    private static final CopyOnWriteArrayList<StreamObserver<StockData>> observers = new CopyOnWriteArrayList<>();
    
    private static void startSimulationThread() {
        new Thread(() -> {
            try {
                while (true) {
                	
                	//System.out.println(observers.size());
                    StockExchangeServiceImpl.updateStockPrices();
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

   

    
    
    

    static class StockExchangeServiceImpl extends StockExchangeServiceImplBase {

    	
        private static  StockData[] stockDataArray;
        private static final Map<StreamObserver<StockData>,List<StockData>> ObserverSymbolMap = new HashMap<>();
        private static final Map<StockData, List<BuyRequest>> BuyMap = new HashMap<>();
        private static final Map<StockData, List<SellRequest>> SellMap = new HashMap<>();
        private static final Map<String, StockData> SymbolMap = new HashMap<>(); 

        static {
        	
        	for (StockData data : InitialData.initStocks()) {
        		
        		SymbolMap.put(data.getSymbol(), data);
        		
        	}
            stockDataArray = InitialData.initStocks();
        }

        
             
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
            
            stockDataArray = SymbolMap.values().toArray(new StockData[0]);
            notifyClients(stockDataArray);
        }

                      
        
        private static void notifyClients(StockData[] stockDataArray) {
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

          
            List<String> symbolsToFollow = request.getSymbolsList();
            List<StockData> updatedFollowedStocks = Arrays.stream(stockDataArray)
                    .filter(stock -> symbolsToFollow.contains(stock.getSymbol()))
                    .collect(Collectors.toList());

            
        	ObserverSymbolMap.put(responseObserver, updatedFollowedStocks);
            
                  
        }                   
        
        @Override
        public void ask(AskRequest request, StreamObserver<SellOffer> responseObserver) {
          
                                       
            List<SellRequest> SellOffers = SellMap.entrySet().stream()
        	        .filter(entry -> entry.getKey().getSymbol().equals(request.getCompanySymbol()))
        	        .map(Map.Entry::getValue)
        	        .findFirst()
        	        .orElse(new ArrayList<>());
            
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
        	        .filter(entry -> entry.getKey().getSymbol().equals(request.getCompanySymbol()))
        	        .map(Map.Entry::getValue)
        	        .findFirst()
        	        .orElse(new ArrayList<>());
            
            BuyOffers.sort(Comparator.comparingDouble(BuyRequest::getPricePerShare));
            
            
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
           
        	
        	List<BuyRequest> BuyList = BuyMap.entrySet().stream()
        	        .filter(entry -> entry.getKey().getSymbol().equals(request.getCompanySymbol()))
        	        .map(Map.Entry::getValue)
        	        .findFirst()
        	        .orElse(new ArrayList<>());

            
            
            if (BuyList == null) {
            	BuyList = new ArrayList<>();
            }

            BuyList.add(BuyRequest.newBuilder()               
            		.setCompanySymbol(request.getCompanySymbol())
                    .setPricePerShare(request.getPricePerShare())
                    .setQuantity(request.getQuantity())
                    .build());

            BuyMap.put(SymbolMap.get(request.getCompanySymbol()), BuyList);
            
            BuyResponse buyResp = BuyResponse.newBuilder()
            		   .setSuccess(true)
            		   .setMessage("Your order has been fullfiled")
            		   .build();
            
            responseObserver.onNext(buyResp);
            responseObserver.onCompleted();
        }

        @Override
        public void sell(SellRequest request, StreamObserver<SellResponse> responseObserver) {
        	
        	
        	List<SellRequest> SellList = SellMap.entrySet().stream()
        	        .filter(entry -> entry.getKey().getSymbol().equals(request.getCompanySymbol()))
        	        .map(Map.Entry::getValue)
        	        .findFirst()
        	        .orElse(new ArrayList<>());
            
            
            if (SellList == null) {
            	SellList = new ArrayList<>();
            }

            SellList.add(SellRequest.newBuilder()               
            		.setCompanySymbol(request.getCompanySymbol())
                    .setPricePerShare(request.getPricePerShare())
                    .setQuantity(request.getQuantity())
                    .build());

            SellMap.put(SymbolMap.get(request.getCompanySymbol()), SellList);
            
            SellResponse sellResp = SellResponse.newBuilder()
            		   .setSuccess(true)
            		   .setMessage("Your order has been fullfiled")
            		   .build();
            
            responseObserver.onNext(sellResp);
            responseObserver.onCompleted();
        }
        
        
        
 }

        
       
      
}
