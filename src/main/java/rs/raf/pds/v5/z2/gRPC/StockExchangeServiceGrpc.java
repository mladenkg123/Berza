package rs.raf.pds.v5.z2.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: stockexchange.proto")
public final class StockExchangeServiceGrpc {

  private StockExchangeServiceGrpc() {}

  public static final String SERVICE_NAME = "StockExchangeService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetStockDataMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.StockRequest,
      rs.raf.pds.v5.z2.gRPC.StockData> METHOD_GET_STOCK_DATA = getGetStockDataMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.StockRequest,
      rs.raf.pds.v5.z2.gRPC.StockData> getGetStockDataMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.StockRequest,
      rs.raf.pds.v5.z2.gRPC.StockData> getGetStockDataMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.StockRequest, rs.raf.pds.v5.z2.gRPC.StockData> getGetStockDataMethod;
    if ((getGetStockDataMethod = StockExchangeServiceGrpc.getGetStockDataMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getGetStockDataMethod = StockExchangeServiceGrpc.getGetStockDataMethod) == null) {
          StockExchangeServiceGrpc.getGetStockDataMethod = getGetStockDataMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.StockRequest, rs.raf.pds.v5.z2.gRPC.StockData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StockExchangeService", "getStockData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.StockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.StockData.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("getStockData"))
                  .build();
          }
        }
     }
     return getGetStockDataMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateFollowedSymbolsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest,
      rs.raf.pds.v5.z2.gRPC.StockData> METHOD_UPDATE_FOLLOWED_SYMBOLS = getUpdateFollowedSymbolsMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest,
      rs.raf.pds.v5.z2.gRPC.StockData> getUpdateFollowedSymbolsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest,
      rs.raf.pds.v5.z2.gRPC.StockData> getUpdateFollowedSymbolsMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest, rs.raf.pds.v5.z2.gRPC.StockData> getUpdateFollowedSymbolsMethod;
    if ((getUpdateFollowedSymbolsMethod = StockExchangeServiceGrpc.getUpdateFollowedSymbolsMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getUpdateFollowedSymbolsMethod = StockExchangeServiceGrpc.getUpdateFollowedSymbolsMethod) == null) {
          StockExchangeServiceGrpc.getUpdateFollowedSymbolsMethod = getUpdateFollowedSymbolsMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest, rs.raf.pds.v5.z2.gRPC.StockData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StockExchangeService", "updateFollowedSymbols"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.StockData.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("updateFollowedSymbols"))
                  .build();
          }
        }
     }
     return getUpdateFollowedSymbolsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAskMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest,
      rs.raf.pds.v5.z2.gRPC.SellOffer> METHOD_ASK = getAskMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest,
      rs.raf.pds.v5.z2.gRPC.SellOffer> getAskMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest,
      rs.raf.pds.v5.z2.gRPC.SellOffer> getAskMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest, rs.raf.pds.v5.z2.gRPC.SellOffer> getAskMethod;
    if ((getAskMethod = StockExchangeServiceGrpc.getAskMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getAskMethod = StockExchangeServiceGrpc.getAskMethod) == null) {
          StockExchangeServiceGrpc.getAskMethod = getAskMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.AskRequest, rs.raf.pds.v5.z2.gRPC.SellOffer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StockExchangeService", "Ask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.AskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.SellOffer.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("Ask"))
                  .build();
          }
        }
     }
     return getAskMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBidMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest,
      rs.raf.pds.v5.z2.gRPC.BuyOffer> METHOD_BID = getBidMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest,
      rs.raf.pds.v5.z2.gRPC.BuyOffer> getBidMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest,
      rs.raf.pds.v5.z2.gRPC.BuyOffer> getBidMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest, rs.raf.pds.v5.z2.gRPC.BuyOffer> getBidMethod;
    if ((getBidMethod = StockExchangeServiceGrpc.getBidMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getBidMethod = StockExchangeServiceGrpc.getBidMethod) == null) {
          StockExchangeServiceGrpc.getBidMethod = getBidMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.BidRequest, rs.raf.pds.v5.z2.gRPC.BuyOffer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StockExchangeService", "Bid"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BidRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BuyOffer.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("Bid"))
                  .build();
          }
        }
     }
     return getBidMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBuyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyRequest,
      rs.raf.pds.v5.z2.gRPC.BuyResponse> METHOD_BUY = getBuyMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyRequest,
      rs.raf.pds.v5.z2.gRPC.BuyResponse> getBuyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyRequest,
      rs.raf.pds.v5.z2.gRPC.BuyResponse> getBuyMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyRequest, rs.raf.pds.v5.z2.gRPC.BuyResponse> getBuyMethod;
    if ((getBuyMethod = StockExchangeServiceGrpc.getBuyMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getBuyMethod = StockExchangeServiceGrpc.getBuyMethod) == null) {
          StockExchangeServiceGrpc.getBuyMethod = getBuyMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.BuyRequest, rs.raf.pds.v5.z2.gRPC.BuyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockExchangeService", "buy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BuyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BuyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("buy"))
                  .build();
          }
        }
     }
     return getBuyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSellMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellRequest,
      rs.raf.pds.v5.z2.gRPC.SellResponse> METHOD_SELL = getSellMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellRequest,
      rs.raf.pds.v5.z2.gRPC.SellResponse> getSellMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellRequest,
      rs.raf.pds.v5.z2.gRPC.SellResponse> getSellMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellRequest, rs.raf.pds.v5.z2.gRPC.SellResponse> getSellMethod;
    if ((getSellMethod = StockExchangeServiceGrpc.getSellMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getSellMethod = StockExchangeServiceGrpc.getSellMethod) == null) {
          StockExchangeServiceGrpc.getSellMethod = getSellMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.SellRequest, rs.raf.pds.v5.z2.gRPC.SellResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockExchangeService", "sell"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.SellRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.SellResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("sell"))
                  .build();
          }
        }
     }
     return getSellMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSubmitOrderMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.OrderRequest,
      rs.raf.pds.v5.z2.gRPC.OrderResponse> METHOD_SUBMIT_ORDER = getSubmitOrderMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.OrderRequest,
      rs.raf.pds.v5.z2.gRPC.OrderResponse> getSubmitOrderMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.OrderRequest,
      rs.raf.pds.v5.z2.gRPC.OrderResponse> getSubmitOrderMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.OrderRequest, rs.raf.pds.v5.z2.gRPC.OrderResponse> getSubmitOrderMethod;
    if ((getSubmitOrderMethod = StockExchangeServiceGrpc.getSubmitOrderMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getSubmitOrderMethod = StockExchangeServiceGrpc.getSubmitOrderMethod) == null) {
          StockExchangeServiceGrpc.getSubmitOrderMethod = getSubmitOrderMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.OrderRequest, rs.raf.pds.v5.z2.gRPC.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockExchangeService", "submitOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.OrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("submitOrder"))
                  .build();
          }
        }
     }
     return getSubmitOrderMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getNotifyTradeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.TradeNotification,
      rs.raf.pds.v5.z2.gRPC.TradeDetails> METHOD_NOTIFY_TRADE = getNotifyTradeMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.TradeNotification,
      rs.raf.pds.v5.z2.gRPC.TradeDetails> getNotifyTradeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.TradeNotification,
      rs.raf.pds.v5.z2.gRPC.TradeDetails> getNotifyTradeMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.TradeNotification, rs.raf.pds.v5.z2.gRPC.TradeDetails> getNotifyTradeMethod;
    if ((getNotifyTradeMethod = StockExchangeServiceGrpc.getNotifyTradeMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getNotifyTradeMethod = StockExchangeServiceGrpc.getNotifyTradeMethod) == null) {
          StockExchangeServiceGrpc.getNotifyTradeMethod = getNotifyTradeMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.TradeNotification, rs.raf.pds.v5.z2.gRPC.TradeDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StockExchangeService", "notifyTrade"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.TradeNotification.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.TradeDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("notifyTrade"))
                  .build();
          }
        }
     }
     return getNotifyTradeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGenerateClientIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest,
      rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse> METHOD_GENERATE_CLIENT_ID = getGenerateClientIdMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest,
      rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse> getGenerateClientIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest,
      rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse> getGenerateClientIdMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest, rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse> getGenerateClientIdMethod;
    if ((getGenerateClientIdMethod = StockExchangeServiceGrpc.getGenerateClientIdMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getGenerateClientIdMethod = StockExchangeServiceGrpc.getGenerateClientIdMethod) == null) {
          StockExchangeServiceGrpc.getGenerateClientIdMethod = getGenerateClientIdMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest, rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StockExchangeService", "generateClientId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("generateClientId"))
                  .build();
          }
        }
     }
     return getGenerateClientIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StockExchangeServiceStub newStub(io.grpc.Channel channel) {
    return new StockExchangeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StockExchangeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StockExchangeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StockExchangeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StockExchangeServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StockExchangeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getStockData(rs.raf.pds.v5.z2.gRPC.StockRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.StockData> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStockDataMethod(), responseObserver);
    }

    /**
     */
    public void updateFollowedSymbols(rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.StockData> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFollowedSymbolsMethod(), responseObserver);
    }

    /**
     */
    public void ask(rs.raf.pds.v5.z2.gRPC.AskRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellOffer> responseObserver) {
      asyncUnimplementedUnaryCall(getAskMethod(), responseObserver);
    }

    /**
     */
    public void bid(rs.raf.pds.v5.z2.gRPC.BidRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyOffer> responseObserver) {
      asyncUnimplementedUnaryCall(getBidMethod(), responseObserver);
    }

    /**
     */
    public void buy(rs.raf.pds.v5.z2.gRPC.BuyRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBuyMethod(), responseObserver);
    }

    /**
     */
    public void sell(rs.raf.pds.v5.z2.gRPC.SellRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSellMethod(), responseObserver);
    }

    /**
     */
    public void submitOrder(rs.raf.pds.v5.z2.gRPC.OrderRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.OrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSubmitOrderMethod(), responseObserver);
    }

    /**
     */
    public void notifyTrade(rs.raf.pds.v5.z2.gRPC.TradeNotification request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.TradeDetails> responseObserver) {
      asyncUnimplementedUnaryCall(getNotifyTradeMethod(), responseObserver);
    }

    /**
     */
    public void generateClientId(rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateClientIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetStockDataMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.StockRequest,
                rs.raf.pds.v5.z2.gRPC.StockData>(
                  this, METHODID_GET_STOCK_DATA)))
          .addMethod(
            getUpdateFollowedSymbolsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest,
                rs.raf.pds.v5.z2.gRPC.StockData>(
                  this, METHODID_UPDATE_FOLLOWED_SYMBOLS)))
          .addMethod(
            getAskMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.AskRequest,
                rs.raf.pds.v5.z2.gRPC.SellOffer>(
                  this, METHODID_ASK)))
          .addMethod(
            getBidMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.BidRequest,
                rs.raf.pds.v5.z2.gRPC.BuyOffer>(
                  this, METHODID_BID)))
          .addMethod(
            getBuyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.BuyRequest,
                rs.raf.pds.v5.z2.gRPC.BuyResponse>(
                  this, METHODID_BUY)))
          .addMethod(
            getSellMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.SellRequest,
                rs.raf.pds.v5.z2.gRPC.SellResponse>(
                  this, METHODID_SELL)))
          .addMethod(
            getSubmitOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.OrderRequest,
                rs.raf.pds.v5.z2.gRPC.OrderResponse>(
                  this, METHODID_SUBMIT_ORDER)))
          .addMethod(
            getNotifyTradeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.TradeNotification,
                rs.raf.pds.v5.z2.gRPC.TradeDetails>(
                  this, METHODID_NOTIFY_TRADE)))
          .addMethod(
            getGenerateClientIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest,
                rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse>(
                  this, METHODID_GENERATE_CLIENT_ID)))
          .build();
    }
  }

  /**
   */
  public static final class StockExchangeServiceStub extends io.grpc.stub.AbstractStub<StockExchangeServiceStub> {
    private StockExchangeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockExchangeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockExchangeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockExchangeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getStockData(rs.raf.pds.v5.z2.gRPC.StockRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.StockData> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStockDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateFollowedSymbols(rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.StockData> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getUpdateFollowedSymbolsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void ask(rs.raf.pds.v5.z2.gRPC.AskRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellOffer> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bid(rs.raf.pds.v5.z2.gRPC.BidRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyOffer> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getBidMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void buy(rs.raf.pds.v5.z2.gRPC.BuyRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBuyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sell(rs.raf.pds.v5.z2.gRPC.SellRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSellMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void submitOrder(rs.raf.pds.v5.z2.gRPC.OrderRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.OrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubmitOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void notifyTrade(rs.raf.pds.v5.z2.gRPC.TradeNotification request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.TradeDetails> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getNotifyTradeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void generateClientId(rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGenerateClientIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StockExchangeServiceBlockingStub extends io.grpc.stub.AbstractStub<StockExchangeServiceBlockingStub> {
    private StockExchangeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockExchangeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockExchangeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockExchangeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.StockData> getStockData(
        rs.raf.pds.v5.z2.gRPC.StockRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStockDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.StockData> updateFollowedSymbols(
        rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getUpdateFollowedSymbolsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.SellOffer> ask(
        rs.raf.pds.v5.z2.gRPC.AskRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getAskMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.BuyOffer> bid(
        rs.raf.pds.v5.z2.gRPC.BidRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getBidMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.BuyResponse buy(rs.raf.pds.v5.z2.gRPC.BuyRequest request) {
      return blockingUnaryCall(
          getChannel(), getBuyMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.SellResponse sell(rs.raf.pds.v5.z2.gRPC.SellRequest request) {
      return blockingUnaryCall(
          getChannel(), getSellMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.OrderResponse submitOrder(rs.raf.pds.v5.z2.gRPC.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getSubmitOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.TradeDetails> notifyTrade(
        rs.raf.pds.v5.z2.gRPC.TradeNotification request) {
      return blockingServerStreamingCall(
          getChannel(), getNotifyTradeMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse generateClientId(rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGenerateClientIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StockExchangeServiceFutureStub extends io.grpc.stub.AbstractStub<StockExchangeServiceFutureStub> {
    private StockExchangeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockExchangeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockExchangeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockExchangeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.BuyResponse> buy(
        rs.raf.pds.v5.z2.gRPC.BuyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBuyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.SellResponse> sell(
        rs.raf.pds.v5.z2.gRPC.SellRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSellMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.OrderResponse> submitOrder(
        rs.raf.pds.v5.z2.gRPC.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSubmitOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse> generateClientId(
        rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGenerateClientIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STOCK_DATA = 0;
  private static final int METHODID_UPDATE_FOLLOWED_SYMBOLS = 1;
  private static final int METHODID_ASK = 2;
  private static final int METHODID_BID = 3;
  private static final int METHODID_BUY = 4;
  private static final int METHODID_SELL = 5;
  private static final int METHODID_SUBMIT_ORDER = 6;
  private static final int METHODID_NOTIFY_TRADE = 7;
  private static final int METHODID_GENERATE_CLIENT_ID = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StockExchangeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StockExchangeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STOCK_DATA:
          serviceImpl.getStockData((rs.raf.pds.v5.z2.gRPC.StockRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.StockData>) responseObserver);
          break;
        case METHODID_UPDATE_FOLLOWED_SYMBOLS:
          serviceImpl.updateFollowedSymbols((rs.raf.pds.v5.z2.gRPC.FollowedSymbolsRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.StockData>) responseObserver);
          break;
        case METHODID_ASK:
          serviceImpl.ask((rs.raf.pds.v5.z2.gRPC.AskRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellOffer>) responseObserver);
          break;
        case METHODID_BID:
          serviceImpl.bid((rs.raf.pds.v5.z2.gRPC.BidRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyOffer>) responseObserver);
          break;
        case METHODID_BUY:
          serviceImpl.buy((rs.raf.pds.v5.z2.gRPC.BuyRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyResponse>) responseObserver);
          break;
        case METHODID_SELL:
          serviceImpl.sell((rs.raf.pds.v5.z2.gRPC.SellRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellResponse>) responseObserver);
          break;
        case METHODID_SUBMIT_ORDER:
          serviceImpl.submitOrder((rs.raf.pds.v5.z2.gRPC.OrderRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.OrderResponse>) responseObserver);
          break;
        case METHODID_NOTIFY_TRADE:
          serviceImpl.notifyTrade((rs.raf.pds.v5.z2.gRPC.TradeNotification) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.TradeDetails>) responseObserver);
          break;
        case METHODID_GENERATE_CLIENT_ID:
          serviceImpl.generateClientId((rs.raf.pds.v5.z2.gRPC.GenerateClientIdRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.GenerateClientIdResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StockExchangeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StockExchangeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return rs.raf.pds.v5.z2.gRPC.Stockexchange.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StockExchangeService");
    }
  }

  private static final class StockExchangeServiceFileDescriptorSupplier
      extends StockExchangeServiceBaseDescriptorSupplier {
    StockExchangeServiceFileDescriptorSupplier() {}
  }

  private static final class StockExchangeServiceMethodDescriptorSupplier
      extends StockExchangeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StockExchangeServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StockExchangeServiceFileDescriptorSupplier())
              .addMethod(getGetStockDataMethod())
              .addMethod(getUpdateFollowedSymbolsMethod())
              .addMethod(getAskMethod())
              .addMethod(getBidMethod())
              .addMethod(getBuyMethod())
              .addMethod(getSellMethod())
              .addMethod(getSubmitOrderMethod())
              .addMethod(getNotifyTradeMethod())
              .addMethod(getGenerateClientIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
