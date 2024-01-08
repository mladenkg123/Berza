// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stockexchange.proto

package rs.raf.pds.v5.z2.gRPC;

/**
 * Protobuf type {@code BuyRequest}
 */
public final class BuyRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:BuyRequest)
    BuyRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BuyRequest.newBuilder() to construct.
  private BuyRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BuyRequest() {
    companySymbol_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BuyRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return rs.raf.pds.v5.z2.gRPC.Stockexchange.internal_static_BuyRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return rs.raf.pds.v5.z2.gRPC.Stockexchange.internal_static_BuyRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            rs.raf.pds.v5.z2.gRPC.BuyRequest.class, rs.raf.pds.v5.z2.gRPC.BuyRequest.Builder.class);
  }

  public static final int COMPANYSYMBOL_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object companySymbol_ = "";
  /**
   * <code>string companySymbol = 1;</code>
   * @return The companySymbol.
   */
  @java.lang.Override
  public java.lang.String getCompanySymbol() {
    java.lang.Object ref = companySymbol_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      companySymbol_ = s;
      return s;
    }
  }
  /**
   * <code>string companySymbol = 1;</code>
   * @return The bytes for companySymbol.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCompanySymbolBytes() {
    java.lang.Object ref = companySymbol_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      companySymbol_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PRICEPERSHARE_FIELD_NUMBER = 2;
  private double pricePerShare_ = 0D;
  /**
   * <code>double pricePerShare = 2;</code>
   * @return The pricePerShare.
   */
  @java.lang.Override
  public double getPricePerShare() {
    return pricePerShare_;
  }

  public static final int QUANTITY_FIELD_NUMBER = 3;
  private int quantity_ = 0;
  /**
   * <code>int32 quantity = 3;</code>
   * @return The quantity.
   */
  @java.lang.Override
  public int getQuantity() {
    return quantity_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(companySymbol_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, companySymbol_);
    }
    if (java.lang.Double.doubleToRawLongBits(pricePerShare_) != 0) {
      output.writeDouble(2, pricePerShare_);
    }
    if (quantity_ != 0) {
      output.writeInt32(3, quantity_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(companySymbol_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, companySymbol_);
    }
    if (java.lang.Double.doubleToRawLongBits(pricePerShare_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, pricePerShare_);
    }
    if (quantity_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, quantity_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof rs.raf.pds.v5.z2.gRPC.BuyRequest)) {
      return super.equals(obj);
    }
    rs.raf.pds.v5.z2.gRPC.BuyRequest other = (rs.raf.pds.v5.z2.gRPC.BuyRequest) obj;

    if (!getCompanySymbol()
        .equals(other.getCompanySymbol())) return false;
    if (java.lang.Double.doubleToLongBits(getPricePerShare())
        != java.lang.Double.doubleToLongBits(
            other.getPricePerShare())) return false;
    if (getQuantity()
        != other.getQuantity()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + COMPANYSYMBOL_FIELD_NUMBER;
    hash = (53 * hash) + getCompanySymbol().hashCode();
    hash = (37 * hash) + PRICEPERSHARE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getPricePerShare()));
    hash = (37 * hash) + QUANTITY_FIELD_NUMBER;
    hash = (53 * hash) + getQuantity();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(rs.raf.pds.v5.z2.gRPC.BuyRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code BuyRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:BuyRequest)
      rs.raf.pds.v5.z2.gRPC.BuyRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rs.raf.pds.v5.z2.gRPC.Stockexchange.internal_static_BuyRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rs.raf.pds.v5.z2.gRPC.Stockexchange.internal_static_BuyRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              rs.raf.pds.v5.z2.gRPC.BuyRequest.class, rs.raf.pds.v5.z2.gRPC.BuyRequest.Builder.class);
    }

    // Construct using rs.raf.pds.v5.z2.gRPC.BuyRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      companySymbol_ = "";
      pricePerShare_ = 0D;
      quantity_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return rs.raf.pds.v5.z2.gRPC.Stockexchange.internal_static_BuyRequest_descriptor;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.BuyRequest getDefaultInstanceForType() {
      return rs.raf.pds.v5.z2.gRPC.BuyRequest.getDefaultInstance();
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.BuyRequest build() {
      rs.raf.pds.v5.z2.gRPC.BuyRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.BuyRequest buildPartial() {
      rs.raf.pds.v5.z2.gRPC.BuyRequest result = new rs.raf.pds.v5.z2.gRPC.BuyRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(rs.raf.pds.v5.z2.gRPC.BuyRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.companySymbol_ = companySymbol_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.pricePerShare_ = pricePerShare_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.quantity_ = quantity_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof rs.raf.pds.v5.z2.gRPC.BuyRequest) {
        return mergeFrom((rs.raf.pds.v5.z2.gRPC.BuyRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(rs.raf.pds.v5.z2.gRPC.BuyRequest other) {
      if (other == rs.raf.pds.v5.z2.gRPC.BuyRequest.getDefaultInstance()) return this;
      if (!other.getCompanySymbol().isEmpty()) {
        companySymbol_ = other.companySymbol_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getPricePerShare() != 0D) {
        setPricePerShare(other.getPricePerShare());
      }
      if (other.getQuantity() != 0) {
        setQuantity(other.getQuantity());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              companySymbol_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 17: {
              pricePerShare_ = input.readDouble();
              bitField0_ |= 0x00000002;
              break;
            } // case 17
            case 24: {
              quantity_ = input.readInt32();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object companySymbol_ = "";
    /**
     * <code>string companySymbol = 1;</code>
     * @return The companySymbol.
     */
    public java.lang.String getCompanySymbol() {
      java.lang.Object ref = companySymbol_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        companySymbol_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string companySymbol = 1;</code>
     * @return The bytes for companySymbol.
     */
    public com.google.protobuf.ByteString
        getCompanySymbolBytes() {
      java.lang.Object ref = companySymbol_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        companySymbol_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string companySymbol = 1;</code>
     * @param value The companySymbol to set.
     * @return This builder for chaining.
     */
    public Builder setCompanySymbol(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      companySymbol_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string companySymbol = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCompanySymbol() {
      companySymbol_ = getDefaultInstance().getCompanySymbol();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string companySymbol = 1;</code>
     * @param value The bytes for companySymbol to set.
     * @return This builder for chaining.
     */
    public Builder setCompanySymbolBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      companySymbol_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private double pricePerShare_ ;
    /**
     * <code>double pricePerShare = 2;</code>
     * @return The pricePerShare.
     */
    @java.lang.Override
    public double getPricePerShare() {
      return pricePerShare_;
    }
    /**
     * <code>double pricePerShare = 2;</code>
     * @param value The pricePerShare to set.
     * @return This builder for chaining.
     */
    public Builder setPricePerShare(double value) {

      pricePerShare_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>double pricePerShare = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPricePerShare() {
      bitField0_ = (bitField0_ & ~0x00000002);
      pricePerShare_ = 0D;
      onChanged();
      return this;
    }

    private int quantity_ ;
    /**
     * <code>int32 quantity = 3;</code>
     * @return The quantity.
     */
    @java.lang.Override
    public int getQuantity() {
      return quantity_;
    }
    /**
     * <code>int32 quantity = 3;</code>
     * @param value The quantity to set.
     * @return This builder for chaining.
     */
    public Builder setQuantity(int value) {

      quantity_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>int32 quantity = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearQuantity() {
      bitField0_ = (bitField0_ & ~0x00000004);
      quantity_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:BuyRequest)
  }

  // @@protoc_insertion_point(class_scope:BuyRequest)
  private static final rs.raf.pds.v5.z2.gRPC.BuyRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new rs.raf.pds.v5.z2.gRPC.BuyRequest();
  }

  public static rs.raf.pds.v5.z2.gRPC.BuyRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BuyRequest>
      PARSER = new com.google.protobuf.AbstractParser<BuyRequest>() {
    @java.lang.Override
    public BuyRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<BuyRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BuyRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public rs.raf.pds.v5.z2.gRPC.BuyRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

