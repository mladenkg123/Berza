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
  }

  private static final int METHODID_GET_STOCK_DATA = 0;
  private static final int METHODID_UPDATE_FOLLOWED_SYMBOLS = 1;

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
              .build();
        }
      }
    }
    return result;
  }
}
