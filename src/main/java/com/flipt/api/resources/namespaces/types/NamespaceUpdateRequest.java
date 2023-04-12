package com.flipt.api.resources.namespaces.types;

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
    builder = NamespaceUpdateRequest.Builder.class
)
public final class NamespaceUpdateRequest {
  private final String name;

  private final Optional<String> description;

  private int _cachedHashCode;

  NamespaceUpdateRequest(String name, Optional<String> description) {
    this.name = name;
    this.description = description;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("description")
  public Optional<String> getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof NamespaceUpdateRequest && equalTo((NamespaceUpdateRequest) other);
  }

  private boolean equalTo(NamespaceUpdateRequest other) {
    return name.equals(other.name) && description.equals(other.description);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.description);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "NamespaceUpdateRequest{" + "name: " + name + ", description: " + description + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    _FinalStage name(String name);

    Builder from(NamespaceUpdateRequest other);
  }

  public interface _FinalStage {
    NamespaceUpdateRequest build();

    _FinalStage description(Optional<String> description);

    _FinalStage description(String description);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, _FinalStage {
    private String name;

    private Optional<String> description = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(NamespaceUpdateRequest other) {
      name(other.getName());
      description(other.getDescription());
      return this;
    }

    @Override
    @JsonSetter("name")
    public _FinalStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    public _FinalStage description(String description) {
      this.description = Optional.of(description);
      return this;
    }

    @Override
    @JsonSetter(
        value = "description",
        nulls = Nulls.SKIP
    )
    public _FinalStage description(Optional<String> description) {
      this.description = description;
      return this;
    }

    @Override
    public NamespaceUpdateRequest build() {
      return new NamespaceUpdateRequest(name, description);
    }
  }
}
