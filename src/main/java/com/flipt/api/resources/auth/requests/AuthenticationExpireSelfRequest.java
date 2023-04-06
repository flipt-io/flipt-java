package com.flipt.api.resources.auth.requests;

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
    builder = AuthenticationExpireSelfRequest.Builder.class
)
public final class AuthenticationExpireSelfRequest {
  private final Optional<String> expiresAt;

  private int _cachedHashCode;

  AuthenticationExpireSelfRequest(Optional<String> expiresAt) {
    this.expiresAt = expiresAt;
  }

  @JsonProperty("expiresAt")
  public Optional<String> getExpiresAt() {
    return expiresAt;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AuthenticationExpireSelfRequest && equalTo((AuthenticationExpireSelfRequest) other);
  }

  private boolean equalTo(AuthenticationExpireSelfRequest other) {
    return expiresAt.equals(other.expiresAt);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.expiresAt);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AuthenticationExpireSelfRequest{" + "expiresAt: " + expiresAt + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> expiresAt = Optional.empty();

    private Builder() {
    }

    public Builder from(AuthenticationExpireSelfRequest other) {
      expiresAt(other.getExpiresAt());
      return this;
    }

    @JsonSetter(
        value = "expiresAt",
        nulls = Nulls.SKIP
    )
    public Builder expiresAt(Optional<String> expiresAt) {
      this.expiresAt = expiresAt;
      return this;
    }

    public Builder expiresAt(String expiresAt) {
      this.expiresAt = Optional.of(expiresAt);
      return this;
    }

    public AuthenticationExpireSelfRequest build() {
      return new AuthenticationExpireSelfRequest(expiresAt);
    }
  }
}
