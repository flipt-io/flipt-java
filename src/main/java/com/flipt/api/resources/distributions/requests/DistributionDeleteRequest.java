package com.flipt.api.resources.distributions.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = DistributionDeleteRequest.Builder.class
)
public final class DistributionDeleteRequest {
  private final String variantId;

  private int _cachedHashCode;

  DistributionDeleteRequest(String variantId) {
    this.variantId = variantId;
  }

  @JsonProperty("variantId")
  public String getVariantId() {
    return variantId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof DistributionDeleteRequest && equalTo((DistributionDeleteRequest) other);
  }

  private boolean equalTo(DistributionDeleteRequest other) {
    return variantId.equals(other.variantId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.variantId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "DistributionDeleteRequest{" + "variantId: " + variantId + "}";
  }

  public static VariantIdStage builder() {
    return new Builder();
  }

  public interface VariantIdStage {
    _FinalStage variantId(String variantId);

    Builder from(DistributionDeleteRequest other);
  }

  public interface _FinalStage {
    DistributionDeleteRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements VariantIdStage, _FinalStage {
    private String variantId;

    private Builder() {
    }

    @Override
    public Builder from(DistributionDeleteRequest other) {
      variantId(other.getVariantId());
      return this;
    }

    @Override
    @JsonSetter("variantId")
    public _FinalStage variantId(String variantId) {
      this.variantId = variantId;
      return this;
    }

    @Override
    public DistributionDeleteRequest build() {
      return new DistributionDeleteRequest(variantId);
    }
  }
}
