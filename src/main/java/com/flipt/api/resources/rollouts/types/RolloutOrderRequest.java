package com.flipt.api.resources.rollouts.types;

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
    builder = RolloutOrderRequest.Builder.class
)
public final class RolloutOrderRequest {
  private final List<String> rolloutIds;

  private int _cachedHashCode;

  RolloutOrderRequest(List<String> rolloutIds) {
    this.rolloutIds = rolloutIds;
  }

  @JsonProperty("rolloutIds")
  public List<String> getRolloutIds() {
    return rolloutIds;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof RolloutOrderRequest && equalTo((RolloutOrderRequest) other);
  }

  private boolean equalTo(RolloutOrderRequest other) {
    return rolloutIds.equals(other.rolloutIds);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.rolloutIds);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "RolloutOrderRequest{" + "rolloutIds: " + rolloutIds + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<String> rolloutIds = new ArrayList<>();

    private Builder() {
    }

    public Builder from(RolloutOrderRequest other) {
      rolloutIds(other.getRolloutIds());
      return this;
    }

    @JsonSetter(
        value = "rolloutIds",
        nulls = Nulls.SKIP
    )
    public Builder rolloutIds(List<String> rolloutIds) {
      this.rolloutIds.clear();
      this.rolloutIds.addAll(rolloutIds);
      return this;
    }

    public Builder addRolloutIds(String rolloutIds) {
      this.rolloutIds.add(rolloutIds);
      return this;
    }

    public Builder addAllRolloutIds(List<String> rolloutIds) {
      this.rolloutIds.addAll(rolloutIds);
      return this;
    }

    public RolloutOrderRequest build() {
      return new RolloutOrderRequest(rolloutIds);
    }
  }
}
