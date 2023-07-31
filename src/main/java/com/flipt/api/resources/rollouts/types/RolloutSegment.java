package com.flipt.api.resources.rollouts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = RolloutSegment.Builder.class
)
public final class RolloutSegment {
  private final String segmentKey;

  private final boolean value;

  private int _cachedHashCode;

  RolloutSegment(String segmentKey, boolean value) {
    this.segmentKey = segmentKey;
    this.value = value;
  }

  @JsonProperty("segmentKey")
  public String getSegmentKey() {
    return segmentKey;
  }

  @JsonProperty("value")
  public boolean getValue() {
    return value;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof RolloutSegment && equalTo((RolloutSegment) other);
  }

  private boolean equalTo(RolloutSegment other) {
    return segmentKey.equals(other.segmentKey) && value == other.value;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.segmentKey, this.value);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "RolloutSegment{" + "segmentKey: " + segmentKey + ", value: " + value + "}";
  }

  public static SegmentKeyStage builder() {
    return new Builder();
  }

  public interface SegmentKeyStage {
    ValueStage segmentKey(String segmentKey);

    Builder from(RolloutSegment other);
  }

  public interface ValueStage {
    _FinalStage value(boolean value);
  }

  public interface _FinalStage {
    RolloutSegment build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements SegmentKeyStage, ValueStage, _FinalStage {
    private String segmentKey;

    private boolean value;

    private Builder() {
    }

    @Override
    public Builder from(RolloutSegment other) {
      segmentKey(other.getSegmentKey());
      value(other.getValue());
      return this;
    }

    @Override
    @JsonSetter("segmentKey")
    public ValueStage segmentKey(String segmentKey) {
      this.segmentKey = segmentKey;
      return this;
    }

    @Override
    @JsonSetter("value")
    public _FinalStage value(boolean value) {
      this.value = value;
      return this;
    }

    @Override
    public RolloutSegment build() {
      return new RolloutSegment(segmentKey, value);
    }
  }
}
