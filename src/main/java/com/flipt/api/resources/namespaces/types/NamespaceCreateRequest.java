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
    builder = NamespaceCreateRequest.Builder.class
)
public final class NamespaceCreateRequest {
  private final String key;

  private final String name;

  private final Optional<String> description;

  private int _cachedHashCode;

  NamespaceCreateRequest(String key, String name, Optional<String> description) {
    this.key = key;
    this.name = name;
    this.description = description;
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
  public Optional<String> getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof NamespaceCreateRequest && equalTo((NamespaceCreateRequest) other);
  }

  private boolean equalTo(NamespaceCreateRequest other) {
    return key.equals(other.key) && name.equals(other.name) && description.equals(other.description);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.key, this.name, this.description);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "NamespaceCreateRequest{" + "key: " + key + ", name: " + name + ", description: " + description + "}";
  }

  public static KeyStage builder() {
    return new Builder();
  }

  public interface KeyStage {
    NameStage key(String key);

    Builder from(NamespaceCreateRequest other);
  }

  public interface NameStage {
    _FinalStage name(String name);
  }

  public interface _FinalStage {
    NamespaceCreateRequest build();

    _FinalStage description(Optional<String> description);

    _FinalStage description(String description);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements KeyStage, NameStage, _FinalStage {
    private String key;

    private String name;

    private Optional<String> description = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(NamespaceCreateRequest other) {
      key(other.getKey());
      name(other.getName());
      description(other.getDescription());
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
    public NamespaceCreateRequest build() {
      return new NamespaceCreateRequest(key, name, description);
    }
  }
}
