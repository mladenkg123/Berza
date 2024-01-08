package rs.raf.pds.v5.z2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest;
import rs.raf.pds.v5.z2.gRPC.StockData;
import rs.raf.pds.v5.z2.gRPC.StockExchangeServiceGrpc;
import rs.raf.pds.v5.z2.gRPC.StockExchangeServiceGrpc.StockExchangeServiceBlockingStub;
import rs.raf.pds.v5.z2.gRPC.StockExchangeServiceGrpc.StockExchangeServiceStub;
import rs.raf.pds.v5.z2.gRPC.StockRequest;

public class StockExchangeClient {
	
	private static final String EXIT_COMMAND = "/exit";
    private static final String FOLLOW_COMMAND = "/follow";
	
	
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090)
                .usePlaintext()
                .build();

        StockExchangeServiceGrpc.StockExchangeServiceBlockingStub blockingStub = StockExchangeServiceGrpc.newBlockingStub(channel);
        StockExchangeServiceGrpc.StockExchangeServiceStub asyncStub = StockExchangeServiceGrpc.newStub(channel);

        StockRequest stockRequest = StockRequest.newBuilder()
                .setNumberOfCompanies(Integer.MAX_VALUE) //sve kompanije
                .build();
        
        /////////////////////////////////////////////PRINT STOCKS//////////////////////////////////////////

        
        System.out.println("Calling getStockData method...");

        Iterator<StockData> stocks = blockingStub.getStockData(stockRequest);
        List<StockData> allStockData = new ArrayList<>();
        Set<String> symbolsToFollow = new HashSet<>();
        System.out.println("Getting stocks...");
        for (Iterator<StockData> iterator = stocks; iterator.hasNext(); ) {
             StockData stock = iterator.next();
             allStockData.add(stock);
         }
        
        for (StockData stock : allStockData) {
            printStockData(stock);
        }
        /////////////////////////////////////////////PRINT STOCKS//////////////////////////////////////////
        
        
        

        System.out.println("Type '/exit' to close the application.");
        System.out.println("Type '/follow @symbol' or '/follow @symbol1,@symbol2,...' to follow specific symbols.");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();

            if (EXIT_COMMAND.equals(userInput.trim())) {
                // Exit
                channel.shutdown();
                System.out.println("Channel has been closed. Exiting the application.");
                break;
            } else if (userInput.startsWith(FOLLOW_COMMAND)) {        
                String[] symbols = userInput.substring(FOLLOW_COMMAND.length()).trim().split(",");
                symbolsToFollow.clear();
                for (String symbol : symbols) {
                    symbolsToFollow.add(symbol.trim().toUpperCase());
                }

                System.out.println(symbolsToFollow);

                if (symbolsToFollow != null) {
                	
                	updateFollowedSymbols(asyncStub, symbolsToFollow);
                }
            } else {
                System.out.println("AAAA");
            }
        }
    }
    
    
  static  StreamObserver<StockData> responseObserver = new StreamObserver<StockData>() {
        @Override
        public void onNext(StockData stock) {
        	showFollowedSymbols(stock);
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println("Error occurred: " + throwable.getMessage());
        }

        @Override
        public void onCompleted() {

        }
    };
     
    
    
    private static void updateFollowedSymbols(StockExchangeServiceStub asyncStub, Set<String> symbolsToFollow) {
        FollowedSymbolsRequest followedSymbolsRequest = FollowedSymbolsRequest.newBuilder()
                .addAllSymbols(symbolsToFollow)
                .build();

        asyncStub.updateFollowedSymbols(followedSymbolsRequest,responseObserver);

       /* List<StockData> updatedFollowedStocks = new ArrayList<>();
        for (Iterator<StockData> iterator = followedStocks; iterator.hasNext(); ) {
            StockData stock = iterator.next();
            updatedFollowedStocks.add(stock);
        } 

        showFollowedSymbols(updatedFollowedStocks);*/
    }
    
      
   
    
    private static void printStockData(StockData stock) {
        String formattedDate = stock.getDate().substring(0, 10).replace("-", "."); 
        String formattedTime = stock.getDate().substring(11, 16); 
        String symbol = stock.getSymbol();
        double price = stock.getPrice();
        double change = stock.getChange();
        

        // Format the stock data
        String formattedStockData = String.format("%s %s.%s %s %.2f %.2f",
                symbol, formattedDate, formattedTime, price >= 0 ? "+" : "", price, change);

        System.out.println(formattedStockData);
    }
    
    private static void showFollowedSymbols(StockData stock) {
       
            double change = stock.getChange();
            String color = change >= 0 ? "\u001B[32m" : "\u001B[31m"; 

            String formattedStockData = String.format("%s %.2f %.2f%% %s",
                    stock.getSymbol(), stock.getPrice(), Math.abs(change), change >= 0 ? "↑" : "↓");

            System.out.println(color + formattedStockData + "\u001B[0m");
        
    }
    
    
    
}