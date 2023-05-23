package com.flipt.api.resources.constraints.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = Constraint.Builder.class
)
public final class Constraint {
  private final String id;

  private final String segmentKey;

  private final ConstraintComparisonType type;

  private final String property;

  private final String operator;

  private final String value;

  private final String description;

  private final String createdAt;

  private final String updatedAt;

  private int _cachedHashCode;

  Constraint(String id, String segmentKey, ConstraintComparisonType type, String property,
      String operator, String value, String description, String createdAt, String updatedAt) {
    this.id = id;
    this.segmentKey = segmentKey;
    this.type = type;
    this.property = property;
    this.operator = operator;
    this.value = value;
    this.description = description;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("segmentKey")
  public String getSegmentKey() {
    return segmentKey;
  }

  @JsonProperty("type")
  public ConstraintComparisonType getType() {
    return type;
  }

  @JsonProperty("property")
  public String getProperty() {
    return property;
  }

  @JsonProperty("operator")
  public String getOperator() {
    return operator;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
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
    return other instanceof Constraint && equalTo((Constraint) other);
  }

  private boolean equalTo(Constraint other) {
    return id.equals(other.id) && segmentKey.equals(other.segmentKey) && type.equals(other.type) && property.equals(other.property) && operator.equals(other.operator) && value.equals(other.value) && description.equals(other.description) && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.segmentKey, this.type, this.property, this.operator, this.value, this.description, this.createdAt, this.updatedAt);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Constraint{" + "id: " + id + ", segmentKey: " + segmentKey + ", type: " + type + ", property: " + property + ", operator: " + operator + ", value: " + value + ", description: " + description + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    SegmentKeyStage id(String id);

    Builder from(Constraint other);
  }

  public interface SegmentKeyStage {
    TypeStage segmentKey(String segmentKey);
  }

  public interface TypeStage {
    PropertyStage type(ConstraintComparisonType type);
  }

  public interface PropertyStage {
    OperatorStage property(String property);
  }

  public interface OperatorStage {
    ValueStage operator(String operator);
  }

  public interface ValueStage {
    DescriptionStage value(String value);
  }

  public interface DescriptionStage {
    CreatedAtStage description(String description);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    _FinalStage updatedAt(String updatedAt);
  }

  public interface _FinalStage {
    Constraint build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdStage, SegmentKeyStage, TypeStage, PropertyStage, OperatorStage, ValueStage, DescriptionStage, CreatedAtStage, UpdatedAtStage, _FinalStage {
    private String id;

    private String segmentKey;

    private ConstraintComparisonType type;

    private String property;

    private String operator;

    private String value;

    private String description;

    private String createdAt;

    private String updatedAt;

    private Builder() {
    }

    @Override
    public Builder from(Constraint other) {
      id(other.getId());
      segmentKey(other.getSegmentKey());
      type(other.getType());
      property(other.getProperty());
      operator(other.getOperator());
      value(other.getValue());
      description(other.getDescription());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      return this;
    }

    @Override
    @JsonSetter("id")
    public SegmentKeyStage id(String id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("segmentKey")
    public TypeStage segmentKey(String segmentKey) {
      this.segmentKey = segmentKey;
      return this;
    }

    @Override
    @JsonSetter("type")
    public PropertyStage type(ConstraintComparisonType type) {
      this.type = type;
      return this;
    }

    @Override
    @JsonSetter("property")
    public OperatorStage property(String property) {
      this.property = property;
      return this;
    }

    @Override
    @JsonSetter("operator")
    public ValueStage operator(String operator) {
      this.operator = operator;
      return this;
    }

    @Override
    @JsonSetter("value")
    public DescriptionStage value(String value) {
      this.value = value;
      return this;
    }

    @Override
    @JsonSetter("description")
    public CreatedAtStage description(String description) {
      this.description = description;
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
    public Constraint build() {
      return new Constraint(id, segmentKey, type, property, operator, value, description, createdAt, updatedAt);
    }
  }
}
