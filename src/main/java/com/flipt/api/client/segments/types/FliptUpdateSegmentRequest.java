package com.flipt.api.client.segments.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = FliptUpdateSegmentRequest.Builder.class
)
public final class FliptUpdateSegmentRequest {
  private final String name;

  private final String description;

  private final FliptMatchType matchType;

  private int _cachedHashCode;

  FliptUpdateSegmentRequest(String name, String description, FliptMatchType matchType) {
    this.name = name;
    this.description = description;
    this.matchType = matchType;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("matchType")
  public FliptMatchType getMatchType() {
    return matchType;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FliptUpdateSegmentRequest && equalTo((FliptUpdateSegmentRequest) other);
  }

  private boolean equalTo(FliptUpdateSegmentRequest other) {
    return name.equals(other.name) && description.equals(other.description) && matchType.equals(other.matchType);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.description, this.matchType);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FliptUpdateSegmentRequest{" + "name: " + name + ", description: " + description + ", matchType: " + matchType + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    DescriptionStage name(String name);

    Builder from(FliptUpdateSegmentRequest other);
  }

  public interface DescriptionStage {
    MatchTypeStage description(String description);
  }

  public interface MatchTypeStage {
    _FinalStage matchType(FliptMatchType matchType);
  }

  public interface _FinalStage {
    FliptUpdateSegmentRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements NameStage, DescriptionStage, MatchTypeStage, _FinalStage {
    private String name;

    private String description;

    private FliptMatchType matchType;

    private Builder() {
    }

    @Override
    public Builder from(FliptUpdateSegmentRequest other) {
      name(other.getName());
      description(other.getDescription());
      matchType(other.getMatchType());
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
    public MatchTypeStage description(String description) {
      this.description = description;
      return this;
    }

    @Override
    @JsonSetter("matchType")
    public _FinalStage matchType(FliptMatchType matchType) {
      this.matchType = matchType;
      return this;
    }

    @Override
    public FliptUpdateSegmentRequest build() {
      return new FliptUpdateSegmentRequest(name, description, matchType);
    }
  }
}
