package com.flipt.api.resources.flags.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = FlagUpdateRequest.Builder.class
)
public final class FlagUpdateRequest {
  private final String name;

  private final Optional<String> description;

  private final Optional<Boolean> enabled;

  private int _cachedHashCode;

  FlagUpdateRequest(String name, Optional<String> description, Optional<Boolean> enabled) {
    this.name = name;
    this.description = description;
    this.enabled = enabled;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("description")
  public Optional<String> getDescription() {
    return description;
  }

  @JsonProperty("enabled")
  public Optional<Boolean> getEnabled() {
    return enabled;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FlagUpdateRequest && equalTo((FlagUpdateRequest) other);
  }

  private boolean equalTo(FlagUpdateRequest other) {
    return name.equals(other.name) && description.equals(other.description) && enabled.equals(other.enabled);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.description, this.enabled);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FlagUpdateRequest{" + "name: " + name + ", description: " + description + ", enabled: " + enabled + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    _FinalStage name(String name);

    Builder from(FlagUpdateRequest other);
  }

  public interface _FinalStage {
    FlagUpdateRequest build();

    _FinalStage description(Optional<String> description);

    _FinalStage description(String description);

    _FinalStage enabled(Optional<Boolean> enabled);

    _FinalStage enabled(Boolean enabled);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, _FinalStage {
    private String name;

    private Optional<Boolean> enabled = Optional.empty();

    private Optional<String> description = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(FlagUpdateRequest other) {
      name(other.getName());
      description(other.getDescription());
      enabled(other.getEnabled());
      return this;
    }

    @Override
    @JsonSetter("name")
    public _FinalStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    public _FinalStage enabled(Boolean enabled) {
      this.enabled = Optional.of(enabled);
      return this;
    }

    @Override
    @JsonSetter(
        value = "enabled",
        nulls = Nulls.SKIP
    )
    public _FinalStage enabled(Optional<Boolean> enabled) {
      this.enabled = enabled;
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
    public FlagUpdateRequest build() {
      return new FlagUpdateRequest(name, description, enabled);
    }
  }
}
