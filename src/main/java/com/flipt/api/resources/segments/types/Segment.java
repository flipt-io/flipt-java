package com.flipt.api.resources.segments.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.resources.constraints.types.Constraint;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = Segment.Builder.class
)
public final class Segment {
  private final String namespaceKey;

  private final String key;

  private final String name;

  private final String description;

  private final String createdAt;

  private final String updatedAt;

  private final List<Constraint> constraints;

  private final SegmentMatchType matchType;

  private int _cachedHashCode;

  Segment(String namespaceKey, String key, String name, String description, String createdAt,
      String updatedAt, List<Constraint> constraints, SegmentMatchType matchType) {
    this.namespaceKey = namespaceKey;
    this.key = key;
    this.name = name;
    this.description = description;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.constraints = constraints;
    this.matchType = matchType;
  }

  @JsonProperty("namespaceKey")
  public String getNamespaceKey() {
    return namespaceKey;
  }

  @JsonProperty("key")
  public String getKey() {
    return key;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
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

  @JsonProperty("constraints")
  public List<Constraint> getConstraints() {
    return constraints;
  }

  @JsonProperty("matchType")
  public SegmentMatchType getMatchType() {
    return matchType;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Segment && equalTo((Segment) other);
  }

  private boolean equalTo(Segment other) {
    return namespaceKey.equals(other.namespaceKey) && key.equals(other.key) && name.equals(other.name) && description.equals(other.description) && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt) && constraints.equals(other.constraints) && matchType.equals(other.matchType);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.namespaceKey, this.key, this.name, this.description, this.createdAt, this.updatedAt, this.constraints, this.matchType);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Segment{" + "namespaceKey: " + namespaceKey + ", key: " + key + ", name: " + name + ", description: " + description + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + ", constraints: " + constraints + ", matchType: " + matchType + "}";
  }

  public static NamespaceKeyStage builder() {
    return new Builder();
  }

  public interface NamespaceKeyStage {
    KeyStage namespaceKey(String namespaceKey);

    Builder from(Segment other);
  }

  public interface KeyStage {
    NameStage key(String key);
  }

  public interface NameStage {
    DescriptionStage name(String name);
  }

  public interface DescriptionStage {
    CreatedAtStage description(String description);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    MatchTypeStage updatedAt(String updatedAt);
  }

  public interface MatchTypeStage {
    _FinalStage matchType(SegmentMatchType matchType);
  }

  public interface _FinalStage {
    Segment build();

    _FinalStage constraints(List<Constraint> constraints);

    _FinalStage addConstraints(Constraint constraints);

    _FinalStage addAllConstraints(List<Constraint> constraints);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NamespaceKeyStage, KeyStage, NameStage, DescriptionStage, CreatedAtStage, UpdatedAtStage, MatchTypeStage, _FinalStage {
    private String namespaceKey;

    private String key;

    private String name;

    private String description;

    private String createdAt;

    private String updatedAt;

    private SegmentMatchType matchType;

    private List<Constraint> constraints = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(Segment other) {
      namespaceKey(other.getNamespaceKey());
      key(other.getKey());
      name(other.getName());
      description(other.getDescription());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      constraints(other.getConstraints());
      matchType(other.getMatchType());
      return this;
    }

    @Override
    @JsonSetter("namespaceKey")
    public KeyStage namespaceKey(String namespaceKey) {
      this.namespaceKey = namespaceKey;
      return this;
    }

    @Override
    @JsonSetter("key")
    public NameStage key(String key) {
      this.key = key;
      return this;
    }

    @Override
    @JsonSetter("name")
    public DescriptionStage name(String name) {
      this.name = name;
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
    public MatchTypeStage updatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    @JsonSetter("matchType")
    public _FinalStage matchType(SegmentMatchType matchType) {
      this.matchType = matchType;
      return this;
    }

    @Override
    public _FinalStage addAllConstraints(List<Constraint> constraints) {
      this.constraints.addAll(constraints);
      return this;
    }

    @Override
    public _FinalStage addConstraints(Constraint constraints) {
      this.constraints.add(constraints);
      return this;
    }

    @Override
    @JsonSetter(
        value = "constraints",
        nulls = Nulls.SKIP
    )
    public _FinalStage constraints(List<Constraint> constraints) {
      this.constraints.clear();
      this.constraints.addAll(constraints);
      return this;
    }

    @Override
    public Segment build() {
      return new Segment(namespaceKey, key, name, description, createdAt, updatedAt, constraints, matchType);
    }
  }
}
