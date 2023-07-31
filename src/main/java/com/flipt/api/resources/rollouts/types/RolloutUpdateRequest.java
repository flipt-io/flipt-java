package com.flipt.api.resources.rollouts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = RolloutUpdateRequest.Builder.class
)
public final class RolloutUpdateRequest {
  private final Optional<String> description;

  private final Optional<RolloutSegment> segment;

  private final Optional<RolloutThreshold> threshold;

  private int _cachedHashCode;

  RolloutUpdateRequest(Optional<String> description, Optional<RolloutSegment> segment,
      Optional<RolloutThreshold> threshold) {
    this.description = description;
    this.segment = segment;
    this.threshold = threshold;
  }

  @JsonProperty("description")
  public Optional<String> getDescription() {
    return description;
  }

  @JsonProperty("segment")
  public Optional<RolloutSegment> getSegment() {
    return segment;
  }

  @JsonProperty("threshold")
  public Optional<RolloutThreshold> getThreshold() {
    return threshold;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof RolloutUpdateRequest && equalTo((RolloutUpdateRequest) other);
  }

  private boolean equalTo(RolloutUpdateRequest other) {
    return description.equals(other.description) && segment.equals(other.segment) && threshold.equals(other.threshold);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.description, this.segment, this.threshold);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "RolloutUpdateRequest{" + "description: " + description + ", segment: " + segment + ", threshold: " + threshold + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> description = Optional.empty();

    private Optional<RolloutSegment> segment = Optional.empty();

    private Optional<RolloutThreshold> threshold = Optional.empty();

    private Builder() {
    }

    public Builder from(RolloutUpdateRequest other) {
      description(other.getDescription());
      segment(other.getSegment());
      threshold(other.getThreshold());
      return this;
    }

    @JsonSetter(
        value = "description",
        nulls = Nulls.SKIP
    )
    public Builder description(Optional<String> description) {
      this.description = description;
      return this;
    }

    public Builder description(String description) {
      this.description = Optional.of(description);
      return this;
    }

    @JsonSetter(
        value = "segment",
        nulls = Nulls.SKIP
    )
    public Builder segment(Optional<RolloutSegment> segment) {
      this.segment = segment;
      return this;
    }

    public Builder segment(RolloutSegment segment) {
      this.segment = Optional.of(segment);
      return this;
    }

    @JsonSetter(
        value = "threshold",
        nulls = Nulls.SKIP
    )
    public Builder threshold(Optional<RolloutThreshold> threshold) {
      this.threshold = threshold;
      return this;
    }

    public Builder threshold(RolloutThreshold threshold) {
      this.threshold = Optional.of(threshold);
      return this;
    }

    public RolloutUpdateRequest build() {
      return new RolloutUpdateRequest(description, segment, threshold);
    }
  }
}
