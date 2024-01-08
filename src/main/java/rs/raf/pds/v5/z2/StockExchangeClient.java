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
import rs.raf.pds.v5.z2.gRPC.StockExchangeServiceGrpc;
import rs.raf.pds.v5.z2.gRPC.StockExchangeServiceGrpc.StockExchangeServiceBlockingStub;
import rs.raf.pds.v5.z2.gRPC.StockExchangeServiceGrpc.StockExchangeServiceStub;
import rs.raf.pds.v5.z2.gRPC.StockRequest;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class StockExchangeClient {
	
	private static final String EXIT_COMMAND = "/exit";
    private static final String FOLLOW_COMMAND = "/follow";
    private static final String ASK_COMMAND = "/ask";
    private static final String BID_COMMAND = "/bid";
    private static final String BUY_COMMAND = "/buy";
    private static final String SELL_COMMAND = "/sell";
    
    static {
        AnsiConsole.systemInstall();
    }

	
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
            } else if (userInput.startsWith(ASK_COMMAND)) {
            	String[] commandParts = userInput.split(" ", 3);
            	if (commandParts.length == 3) {
            		 String symbol = commandParts[1];
                     int numberOfOffers = Integer.parseInt(commandParts[2]);
                     askForSaleOffers(asyncStub, symbol, numberOfOffers);

            	}
               
            } else if (userInput.startsWith(BID_COMMAND)) {
            	String[] commandParts = userInput.split(" ", 3);
            	
            	System.out.println(commandParts);
            	if (commandParts.length == 3) {
            		 String symbol = commandParts[1];
                     int numberOfOffers = Integer.parseInt(commandParts[2]);
                     System.out.println(symbol);
                     System.out.println(numberOfOffers);
                     askForBidOffers(asyncStub, symbol, numberOfOffers);
            }
            } else if (userInput.startsWith(BUY_COMMAND)) {
                String[] tokens = userInput.substring(BUY_COMMAND.length()).trim().split(" ");
                if (tokens.length == 3) {
                    buyShares(asyncStub, tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]));
                } else {
                    System.out.println("Invalid input for buy command. Usage: /buy @symbol pricePerShare quantity");
                }
            } else if (userInput.startsWith(SELL_COMMAND)) {
                String[] tokens = userInput.substring(SELL_COMMAND.length()).trim().split(" ");
                if (tokens.length == 3) {
                    sellShares(asyncStub, tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]));   
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
    
    
    
    static  StreamObserver<SellOffer> askObserver = new StreamObserver<SellOffer>() {
        @Override
        public void onNext(SellOffer offer) {
        	System.out.println(String.format("%s - Number of offers: %d at price: %.2f",  offer.getQuantity(), offer.getPrice()));
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println("Error occurred: " + throwable.getMessage());
        }

        @Override
        public void onCompleted() {
        	System.out.println("Ask request completed for symbol ");
        }
    };
    
    
    static  StreamObserver<BuyOffer> bidObserver = new StreamObserver<BuyOffer>() {
        @Override
        public void onNext(BuyOffer offer) {
        	System.out.println(String.format("%s - Number of offers: %d at price: %.2f",  offer.getQuantity(), offer.getPrice()));
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println("Error occurred: " + throwable.getMessage());
        }

        @Override
        public void onCompleted() {
        	System.out.println("Ask request completed for symbol ");
        }
    };
    
    
    static StreamObserver<BuyResponse> buyObserver = new StreamObserver<BuyResponse>() {
        @Override
        public void onNext(BuyResponse response) {
            
            System.out.println("Buy request received.");
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println("Error occurred: " + throwable.getMessage());
        }

        @Override
        public void onCompleted() {
        }
    };

    static StreamObserver<SellResponse> sellObserver = new StreamObserver<SellResponse>() {
        @Override
        public void onNext(SellResponse response) {
            
            System.out.println("Sell request received. ");
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
    
      
    private static void askForSaleOffers(StockExchangeServiceStub asyncStub,  String symbol, int numberOfOffers) {

        AskRequest askRequest = AskRequest.newBuilder()
                .setCompanySymbol(symbol)
                .setNumberOfOffers(numberOfOffers)
                .build();

        System.out.println("Calling Ask method...");

        asyncStub.ask(askRequest, new StreamObserver<SellOffer>() {
        	
        	 @Override
             public void onNext(SellOffer offer) {
                 System.out.println(String.format("%s - Number of offers: %d at price: %.2f", symbol, offer.getQuantity(), offer.getPrice()));
             }

        	 @Override
             public void onError(Throwable throwable) {
                 System.err.println("Error occurred: " + throwable.getMessage());
             }

             @Override
             public void onCompleted() {
                 System.out.println("Ask request completed for symbol " + symbol);
             }

        });

    }
    
    private static void askForBidOffers(StockExchangeServiceStub asyncStub,  String symbol, int numberOfOffers) {

        BidRequest bidRequest = BidRequest.newBuilder()
                .setCompanySymbol(symbol)
                .setNumberOfOffers(numberOfOffers)
                .build();

        System.out.println("Calling Ask method...");

        asyncStub.bid(bidRequest, new StreamObserver<BuyOffer>() {
        	
        	 @Override
             public void onNext(BuyOffer offer) {
                 System.out.println(String.format("%s - Number of offers: %d at price: %.2f", symbol, offer.getQuantity(), offer.getPrice()));
             }

        	 @Override
             public void onError(Throwable throwable) {
                 System.err.println("Error occurred: " + throwable.getMessage());
             }

             @Override
             public void onCompleted() {
                 System.out.println("Ask request completed for symbol " + symbol);
             }

        });

    }
    
    
    private static void buyShares(StockExchangeServiceStub asyncStub, String symbol, double pricePerShare, int quantity) {
        BuyRequest buyRequest = BuyRequest.newBuilder()
                .setCompanySymbol(symbol)
                .setPricePerShare(pricePerShare)
                .setQuantity(quantity)
                .build();

        System.out.println("Calling Buy method...");

        asyncStub.buy(buyRequest, buyObserver);

      
    }

    private static void sellShares(StockExchangeServiceStub asyncStub, String symbol, double pricePerShare, int quantity) {
        SellRequest sellRequest = SellRequest.newBuilder()
                .setCompanySymbol(symbol)
                .setPricePerShare(pricePerShare)
                .setQuantity(quantity)
                .build();

        System.out.println("Calling Sell method...");

        asyncStub.sell(sellRequest, sellObserver);

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
        Ansi.Color color = change >= 0 ? Ansi.Color.GREEN : Ansi.Color.RED;
        String changePrefix = change >= 0 ? "+" : "-";

        String formattedStockData = String.format("%s %.2f %s%.2f%%",
                stock.getSymbol(), stock.getPrice(), changePrefix, Math.abs(change));

        System.out.println(Ansi.ansi().fg(color).a(formattedStockData).reset());
    }
}
    
    
    
