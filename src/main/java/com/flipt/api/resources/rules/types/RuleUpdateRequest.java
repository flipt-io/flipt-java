package com.flipt.api.resources.rules.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = RuleUpdateRequest.Builder.class
)
public final class RuleUpdateRequest {
  private final String segmentKey;

  private int _cachedHashCode;

  RuleUpdateRequest(String segmentKey) {
    this.segmentKey = segmentKey;
  }

  @JsonProperty("segmentKey")
  public String getSegmentKey() {
    return segmentKey;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof RuleUpdateRequest && equalTo((RuleUpdateRequest) other);
  }

  private boolean equalTo(RuleUpdateRequest other) {
    return segmentKey.equals(other.segmentKey);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.segmentKey);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "RuleUpdateRequest{" + "segmentKey: " + segmentKey + "}";
  }

  public static SegmentKeyStage builder() {
    return new Builder();
  }

  public interface SegmentKeyStage {
    _FinalStage segmentKey(String segmentKey);

    Builder from(RuleUpdateRequest other);
  }

  public interface _FinalStage {
    RuleUpdateRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements SegmentKeyStage, _FinalStage {
    private String segmentKey;

    private Builder() {
    }

    @Override
    public Builder from(RuleUpdateRequest other) {
      segmentKey(other.getSegmentKey());
      return this;
    }

    @Override
    @JsonSetter("segmentKey")
    public _FinalStage segmentKey(String segmentKey) {
      this.segmentKey = segmentKey;
      return this;
    }

    @Override
    public RuleUpdateRequest build() {
      return new RuleUpdateRequest(segmentKey);
    }
  }
}
