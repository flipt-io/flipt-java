package com.flipt.api.resources.evaluation.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = BooleanEvaluationResponse.Builder.class
)
public final class BooleanEvaluationResponse {
  private final String requestId;

  private final boolean enabled;

  private final String timestamp;

  private final double requestDurationMillis;

  private final EvaluationReason reason;

  private int _cachedHashCode;

  BooleanEvaluationResponse(String requestId, boolean enabled, String timestamp,
      double requestDurationMillis, EvaluationReason reason) {
    this.requestId = requestId;
    this.enabled = enabled;
    this.timestamp = timestamp;
    this.requestDurationMillis = requestDurationMillis;
    this.reason = reason;
  }

  @JsonProperty("requestId")
  public String getRequestId() {
    return requestId;
  }

  @JsonProperty("enabled")
  public boolean getEnabled() {
    return enabled;
  }

  @JsonProperty("timestamp")
  public String getTimestamp() {
    return timestamp;
  }

  @JsonProperty("requestDurationMillis")
  public double getRequestDurationMillis() {
    return requestDurationMillis;
  }

  @JsonProperty("reason")
  public EvaluationReason getReason() {
    return reason;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BooleanEvaluationResponse && equalTo((BooleanEvaluationResponse) other);
  }

  private boolean equalTo(BooleanEvaluationResponse other) {
    return requestId.equals(other.requestId) && enabled == other.enabled && timestamp.equals(other.timestamp) && requestDurationMillis == other.requestDurationMillis && reason.equals(other.reason);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.requestId, this.enabled, this.timestamp, this.requestDurationMillis, this.reason);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BooleanEvaluationResponse{" + "requestId: " + requestId + ", enabled: " + enabled + ", timestamp: " + timestamp + ", requestDurationMillis: " + requestDurationMillis + ", reason: " + reason + "}";
  }

  public static RequestIdStage builder() {
    return new Builder();
  }

  public interface RequestIdStage {
    EnabledStage requestId(String requestId);

    Builder from(BooleanEvaluationResponse other);
  }

  public interface EnabledStage {
    TimestampStage enabled(boolean enabled);
  }

  public interface TimestampStage {
    RequestDurationMillisStage timestamp(String timestamp);
  }

  public interface RequestDurationMillisStage {
    ReasonStage requestDurationMillis(double requestDurationMillis);
  }

  public interface ReasonStage {
    _FinalStage reason(EvaluationReason reason);
  }

  public interface _FinalStage {
    BooleanEvaluationResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements RequestIdStage, EnabledStage, TimestampStage, RequestDurationMillisStage, ReasonStage, _FinalStage {
    private String requestId;

    private boolean enabled;

    private String timestamp;

    private double requestDurationMillis;

    private EvaluationReason reason;

    private Builder() {
    }

    @Override
    public Builder from(BooleanEvaluationResponse other) {
      requestId(other.getRequestId());
      enabled(other.getEnabled());
      timestamp(other.getTimestamp());
      requestDurationMillis(other.getRequestDurationMillis());
      reason(other.getReason());
      return this;
    }

    @Override
    @JsonSetter("requestId")
    public EnabledStage requestId(String requestId) {
      this.requestId = requestId;
      return this;
    }

    @Override
    @JsonSetter("enabled")
    public TimestampStage enabled(boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    @Override
    @JsonSetter("timestamp")
    public RequestDurationMillisStage timestamp(String timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    @Override
    @JsonSetter("requestDurationMillis")
    public ReasonStage requestDurationMillis(double requestDurationMillis) {
      this.requestDurationMillis = requestDurationMillis;
      return this;
    }

    @Override
    @JsonSetter("reason")
    public _FinalStage reason(EvaluationReason reason) {
      this.reason = reason;
      return this;
    }

    @Override
    public BooleanEvaluationResponse build() {
      return new BooleanEvaluationResponse(requestId, enabled, timestamp, requestDurationMillis, reason);
    }
  }
}
