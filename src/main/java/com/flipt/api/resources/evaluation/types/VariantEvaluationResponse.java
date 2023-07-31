package com.flipt.api.resources.evaluation.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = VariantEvaluationResponse.Builder.class
)
public final class VariantEvaluationResponse {
  private final String requestId;

  private final boolean match;

  private final List<String> segmentKeys;

  private final String variantKey;

  private final String variantAttachment;

  private final String timestamp;

  private final double requestDurationMillis;

  private final EvaluationReason reason;

  private int _cachedHashCode;

  VariantEvaluationResponse(String requestId, boolean match, List<String> segmentKeys,
      String variantKey, String variantAttachment, String timestamp, double requestDurationMillis,
      EvaluationReason reason) {
    this.requestId = requestId;
    this.match = match;
    this.segmentKeys = segmentKeys;
    this.variantKey = variantKey;
    this.variantAttachment = variantAttachment;
    this.timestamp = timestamp;
    this.requestDurationMillis = requestDurationMillis;
    this.reason = reason;
  }

  @JsonProperty("requestId")
  public String getRequestId() {
    return requestId;
  }

  @JsonProperty("match")
  public boolean getMatch() {
    return match;
  }

  @JsonProperty("segmentKeys")
  public List<String> getSegmentKeys() {
    return segmentKeys;
  }

  @JsonProperty("variantKey")
  public String getVariantKey() {
    return variantKey;
  }

  @JsonProperty("variantAttachment")
  public String getVariantAttachment() {
    return variantAttachment;
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
    return other instanceof VariantEvaluationResponse && equalTo((VariantEvaluationResponse) other);
  }

  private boolean equalTo(VariantEvaluationResponse other) {
    return requestId.equals(other.requestId) && match == other.match && segmentKeys.equals(other.segmentKeys) && variantKey.equals(other.variantKey) && variantAttachment.equals(other.variantAttachment) && timestamp.equals(other.timestamp) && requestDurationMillis == other.requestDurationMillis && reason.equals(other.reason);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.requestId, this.match, this.segmentKeys, this.variantKey, this.variantAttachment, this.timestamp, this.requestDurationMillis, this.reason);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "VariantEvaluationResponse{" + "requestId: " + requestId + ", match: " + match + ", segmentKeys: " + segmentKeys + ", variantKey: " + variantKey + ", variantAttachment: " + variantAttachment + ", timestamp: " + timestamp + ", requestDurationMillis: " + requestDurationMillis + ", reason: " + reason + "}";
  }

  public static RequestIdStage builder() {
    return new Builder();
  }

  public interface RequestIdStage {
    MatchStage requestId(String requestId);

    Builder from(VariantEvaluationResponse other);
  }

  public interface MatchStage {
    VariantKeyStage match(boolean match);
  }

  public interface VariantKeyStage {
    VariantAttachmentStage variantKey(String variantKey);
  }

  public interface VariantAttachmentStage {
    TimestampStage variantAttachment(String variantAttachment);
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
    VariantEvaluationResponse build();

    _FinalStage segmentKeys(List<String> segmentKeys);

    _FinalStage addSegmentKeys(String segmentKeys);

    _FinalStage addAllSegmentKeys(List<String> segmentKeys);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements RequestIdStage, MatchStage, VariantKeyStage, VariantAttachmentStage, TimestampStage, RequestDurationMillisStage, ReasonStage, _FinalStage {
    private String requestId;

    private boolean match;

    private String variantKey;

    private String variantAttachment;

    private String timestamp;

    private double requestDurationMillis;

    private EvaluationReason reason;

    private List<String> segmentKeys = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(VariantEvaluationResponse other) {
      requestId(other.getRequestId());
      match(other.getMatch());
      segmentKeys(other.getSegmentKeys());
      variantKey(other.getVariantKey());
      variantAttachment(other.getVariantAttachment());
      timestamp(other.getTimestamp());
      requestDurationMillis(other.getRequestDurationMillis());
      reason(other.getReason());
      return this;
    }

    @Override
    @JsonSetter("requestId")
    public MatchStage requestId(String requestId) {
      this.requestId = requestId;
      return this;
    }

    @Override
    @JsonSetter("match")
    public VariantKeyStage match(boolean match) {
      this.match = match;
      return this;
    }

    @Override
    @JsonSetter("variantKey")
    public VariantAttachmentStage variantKey(String variantKey) {
      this.variantKey = variantKey;
      return this;
    }

    @Override
    @JsonSetter("variantAttachment")
    public TimestampStage variantAttachment(String variantAttachment) {
      this.variantAttachment = variantAttachment;
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
    public _FinalStage addAllSegmentKeys(List<String> segmentKeys) {
      this.segmentKeys.addAll(segmentKeys);
      return this;
    }

    @Override
    public _FinalStage addSegmentKeys(String segmentKeys) {
      this.segmentKeys.add(segmentKeys);
      return this;
    }

    @Override
    @JsonSetter(
        value = "segmentKeys",
        nulls = Nulls.SKIP
    )
    public _FinalStage segmentKeys(List<String> segmentKeys) {
      this.segmentKeys.clear();
      this.segmentKeys.addAll(segmentKeys);
      return this;
    }

    @Override
    public VariantEvaluationResponse build() {
      return new VariantEvaluationResponse(requestId, match, segmentKeys, variantKey, variantAttachment, timestamp, requestDurationMillis, reason);
    }
  }
}
