package com.flipt.api.client.evaluate.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = FliptEvaluationResponse.Builder.class
)
public final class FliptEvaluationResponse {
  private final String requestId;

  private final String entityId;

  private final String requestContext;

  private final boolean match;

  private final String flagKey;

  private final String segmentKey;

  private final String timestamp;

  private final String value;

  private final double requestDurationMillis;

  private final String attachment;

  private final FliptEvaluationReason reasons;

  private int _cachedHashCode;

  FliptEvaluationResponse(String requestId, String entityId, String requestContext, boolean match,
      String flagKey, String segmentKey, String timestamp, String value,
      double requestDurationMillis, String attachment, FliptEvaluationReason reasons) {
    this.requestId = requestId;
    this.entityId = entityId;
    this.requestContext = requestContext;
    this.match = match;
    this.flagKey = flagKey;
    this.segmentKey = segmentKey;
    this.timestamp = timestamp;
    this.value = value;
    this.requestDurationMillis = requestDurationMillis;
    this.attachment = attachment;
    this.reasons = reasons;
  }

  @JsonProperty("requestId")
  public String getRequestId() {
    return requestId;
  }

  @JsonProperty("entityId")
  public String getEntityId() {
    return entityId;
  }

  @JsonProperty("requestContext")
  public String getRequestContext() {
    return requestContext;
  }

  @JsonProperty("match")
  public boolean getMatch() {
    return match;
  }

  @JsonProperty("flagKey")
  public String getFlagKey() {
    return flagKey;
  }

  @JsonProperty("segmentKey")
  public String getSegmentKey() {
    return segmentKey;
  }

  @JsonProperty("timestamp")
  public String getTimestamp() {
    return timestamp;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("requestDurationMillis")
  public double getRequestDurationMillis() {
    return requestDurationMillis;
  }

  @JsonProperty("attachment")
  public String getAttachment() {
    return attachment;
  }

  @JsonProperty("reasons")
  public FliptEvaluationReason getReasons() {
    return reasons;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FliptEvaluationResponse && equalTo((FliptEvaluationResponse) other);
  }

  private boolean equalTo(FliptEvaluationResponse other) {
    return requestId.equals(other.requestId) && entityId.equals(other.entityId) && requestContext.equals(other.requestContext) && match == other.match && flagKey.equals(other.flagKey) && segmentKey.equals(other.segmentKey) && timestamp.equals(other.timestamp) && value.equals(other.value) && requestDurationMillis == other.requestDurationMillis && attachment.equals(other.attachment) && reasons.equals(other.reasons);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.requestId, this.entityId, this.requestContext, this.match, this.flagKey, this.segmentKey, this.timestamp, this.value, this.requestDurationMillis, this.attachment, this.reasons);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FliptEvaluationResponse{" + "requestId: " + requestId + ", entityId: " + entityId + ", requestContext: " + requestContext + ", match: " + match + ", flagKey: " + flagKey + ", segmentKey: " + segmentKey + ", timestamp: " + timestamp + ", value: " + value + ", requestDurationMillis: " + requestDurationMillis + ", attachment: " + attachment + ", reasons: " + reasons + "}";
  }

  public static RequestIdStage builder() {
    return new Builder();
  }

  public interface RequestIdStage {
    EntityIdStage requestId(String requestId);

    Builder from(FliptEvaluationResponse other);
  }

  public interface EntityIdStage {
    RequestContextStage entityId(String entityId);
  }

  public interface RequestContextStage {
    MatchStage requestContext(String requestContext);
  }

  public interface MatchStage {
    FlagKeyStage match(boolean match);
  }

  public interface FlagKeyStage {
    SegmentKeyStage flagKey(String flagKey);
  }

  public interface SegmentKeyStage {
    TimestampStage segmentKey(String segmentKey);
  }

  public interface TimestampStage {
    ValueStage timestamp(String timestamp);
  }

  public interface ValueStage {
    RequestDurationMillisStage value(String value);
  }

  public interface RequestDurationMillisStage {
    AttachmentStage requestDurationMillis(double requestDurationMillis);
  }

  public interface AttachmentStage {
    ReasonsStage attachment(String attachment);
  }

  public interface ReasonsStage {
    _FinalStage reasons(FliptEvaluationReason reasons);
  }

  public interface _FinalStage {
    FliptEvaluationResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements RequestIdStage, EntityIdStage, RequestContextStage, MatchStage, FlagKeyStage, SegmentKeyStage, TimestampStage, ValueStage, RequestDurationMillisStage, AttachmentStage, ReasonsStage, _FinalStage {
    private String requestId;

    private String entityId;

    private String requestContext;

    private boolean match;

    private String flagKey;

    private String segmentKey;

    private String timestamp;

    private String value;

    private double requestDurationMillis;

    private String attachment;

    private FliptEvaluationReason reasons;

    private Builder() {
    }

    @Override
    public Builder from(FliptEvaluationResponse other) {
      requestId(other.getRequestId());
      entityId(other.getEntityId());
      requestContext(other.getRequestContext());
      match(other.getMatch());
      flagKey(other.getFlagKey());
      segmentKey(other.getSegmentKey());
      timestamp(other.getTimestamp());
      value(other.getValue());
      requestDurationMillis(other.getRequestDurationMillis());
      attachment(other.getAttachment());
      reasons(other.getReasons());
      return this;
    }

    @Override
    @JsonSetter("requestId")
    public EntityIdStage requestId(String requestId) {
      this.requestId = requestId;
      return this;
    }

    @Override
    @JsonSetter("entityId")
    public RequestContextStage entityId(String entityId) {
      this.entityId = entityId;
      return this;
    }

    @Override
    @JsonSetter("requestContext")
    public MatchStage requestContext(String requestContext) {
      this.requestContext = requestContext;
      return this;
    }

    @Override
    @JsonSetter("match")
    public FlagKeyStage match(boolean match) {
      this.match = match;
      return this;
    }

    @Override
    @JsonSetter("flagKey")
    public SegmentKeyStage flagKey(String flagKey) {
      this.flagKey = flagKey;
      return this;
    }

    @Override
    @JsonSetter("segmentKey")
    public TimestampStage segmentKey(String segmentKey) {
      this.segmentKey = segmentKey;
      return this;
    }

    @Override
    @JsonSetter("timestamp")
    public ValueStage timestamp(String timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    @Override
    @JsonSetter("value")
    public RequestDurationMillisStage value(String value) {
      this.value = value;
      return this;
    }

    @Override
    @JsonSetter("requestDurationMillis")
    public AttachmentStage requestDurationMillis(double requestDurationMillis) {
      this.requestDurationMillis = requestDurationMillis;
      return this;
    }

    @Override
    @JsonSetter("attachment")
    public ReasonsStage attachment(String attachment) {
      this.attachment = attachment;
      return this;
    }

    @Override
    @JsonSetter("reasons")
    public _FinalStage reasons(FliptEvaluationReason reasons) {
      this.reasons = reasons;
      return this;
    }

    @Override
    public FliptEvaluationResponse build() {
      return new FliptEvaluationResponse(requestId, entityId, requestContext, match, flagKey, segmentKey, timestamp, value, requestDurationMillis, attachment, reasons);
    }
  }
}
