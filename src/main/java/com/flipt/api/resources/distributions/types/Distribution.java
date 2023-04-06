package com.flipt.api.resources.distributions.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = Distribution.Builder.class
)
public final class Distribution {
  private final String id;

  private final String ruleId;

  private final String variantId;

  private final double rollout;

  private final String createdAt;

  private final String updatedAt;

  private int _cachedHashCode;

  Distribution(String id, String ruleId, String variantId, double rollout, String createdAt,
      String updatedAt) {
    this.id = id;
    this.ruleId = ruleId;
    this.variantId = variantId;
    this.rollout = rollout;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("ruleId")
  public String getRuleId() {
    return ruleId;
  }

  @JsonProperty("variantId")
  public String getVariantId() {
    return variantId;
  }

  @JsonProperty("rollout")
  public double getRollout() {
    return rollout;
  }

  @JsonProperty("createdAt")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("updatedAt")
  public String getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Distribution && equalTo((Distribution) other);
  }

  private boolean equalTo(Distribution other) {
    return id.equals(other.id) && ruleId.equals(other.ruleId) && variantId.equals(other.variantId) && rollout == other.rollout && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.ruleId, this.variantId, this.rollout, this.createdAt, this.updatedAt);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Distribution{" + "id: " + id + ", ruleId: " + ruleId + ", variantId: " + variantId + ", rollout: " + rollout + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    RuleIdStage id(String id);

    Builder from(Distribution other);
  }

  public interface RuleIdStage {
    VariantIdStage ruleId(String ruleId);
  }

  public interface VariantIdStage {
    RolloutStage variantId(String variantId);
  }

  public interface RolloutStage {
    CreatedAtStage rollout(double rollout);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    _FinalStage updatedAt(String updatedAt);
  }

  public interface _FinalStage {
    Distribution build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdStage, RuleIdStage, VariantIdStage, RolloutStage, CreatedAtStage, UpdatedAtStage, _FinalStage {
    private String id;

    private String ruleId;

    private String variantId;

    private double rollout;

    private String createdAt;

    private String updatedAt;

    private Builder() {
    }

    @Override
    public Builder from(Distribution other) {
      id(other.getId());
      ruleId(other.getRuleId());
      variantId(other.getVariantId());
      rollout(other.getRollout());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      return this;
    }

    @Override
    @JsonSetter("id")
    public RuleIdStage id(String id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("ruleId")
    public VariantIdStage ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    @Override
    @JsonSetter("variantId")
    public RolloutStage variantId(String variantId) {
      this.variantId = variantId;
      return this;
    }

    @Override
    @JsonSetter("rollout")
    public CreatedAtStage rollout(double rollout) {
      this.rollout = rollout;
      return this;
    }

    @Override
    @JsonSetter("createdAt")
    public UpdatedAtStage createdAt(String createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    @Override
    @JsonSetter("updatedAt")
    public _FinalStage updatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    public Distribution build() {
      return new Distribution(id, ruleId, variantId, rollout, createdAt, updatedAt);
    }
  }
}
