package rs.raf.pds.v5.z2;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest;
import rs.raf.pds.v5.z2.gRPC.StockData;
import rs.raf.pds.v5.z2.gRPC.StockExchangeServiceGrpc.StockExchangeServiceImplBase;
import rs.raf.pds.v5.z2.gRPC.StockRequest;

import java.io.IOException;
import java.util.Arrays;
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
                	
                	System.out.println(observers.size());
                    StockExchangeServiceImpl.updateStockPrices();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

   

    
    
    

    static class StockExchangeServiceImpl extends StockExchangeServiceImplBase {

    	
        private static  StockData[] stockDataArray;
        private static final Map<StreamObserver<StockData>,List<StockData>> ObserverSymbolMap = new HashMap<>();
        

        static {
            stockDataArray = InitialData.initStocks();
        }

        
             
        @Override
        public void getStockData(StockRequest request, StreamObserver<StockData> responseObserver) {
            observers.add(responseObserver);

            for (StockData stockData : stockDataArray) {
                responseObserver.onNext(stockData);
            }

           

            responseObserver.onCompleted();
            observers.remove(responseObserver);
        }
           
        private static void updateStockPrices() {
            Random random = new Random();
           
            StockData[] updatedStockDataArray = new StockData[stockDataArray.length];

            for (int i = 0; i < stockDataArray.length; i++) {
                double percentageChange = (random.nextDouble() - 0.5) * 2.0;

                StockData newStock = StockData.newBuilder()
                        .setSymbol(stockDataArray[i].getSymbol())
                        .setCompanyName(stockDataArray[i].getCompanyName())
                        .setPrice(stockDataArray[i].getPrice() * (1 + percentageChange / 100.0))
                        .setChange(percentageChange)
                        .setDate(stockDataArray[i].getDate())
                        .build();

                updatedStockDataArray[i] = newStock;
                
            }
            
            stockDataArray = updatedStockDataArray;
            notifyClients(updatedStockDataArray);
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
        
 }

        
        
        
        /* @Override
        public void getStockData(StockRequest request, StreamObserver<StockData> responseObserver) {
            synchronized (stockDataArray) {
                for (StockData stockData : stockDataArray) {
                    responseObserver.onNext(stockData);                  
                }
            }

            observers.add(responseObserver);
        }
       } */
        
        
        
        
        
        
        
        /* public void updateStockPrices() {
            for (int i = 0; i < stockDataArray.length; i++) {
                // Update prices (you can modify this part based on your logic)
                stockDataArray[i] = stockDataArray[i].toBuilder()
                        .setPrice(stockDataArray[i].getPrice() + 1.0) // Example: Increase the price by 1.0
                        .build();
            }

            // Notify all clients about the updated prices
            for (StreamObserver<StockData> observer : observers) {
                for (StockData stockData : stockDataArray) {
                    observer.onNext(stockData);
                }
                observer.onCompleted();
            }
        }*/
        
        
        
        
        
        
    
}
