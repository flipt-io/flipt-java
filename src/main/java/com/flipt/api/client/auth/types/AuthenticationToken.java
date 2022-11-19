package com.flipt.api.client.auth.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = AuthenticationToken.Builder.class
)
public final class AuthenticationToken {
  private final String clientToken;

  private int _cachedHashCode;

  AuthenticationToken(String clientToken) {
    this.clientToken = clientToken;
  }

  @JsonProperty("clientToken")
  public String getClientToken() {
    return clientToken;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AuthenticationToken && equalTo((AuthenticationToken) other);
  }

  private boolean equalTo(AuthenticationToken other) {
    return clientToken.equals(other.clientToken);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.clientToken);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AuthenticationToken{" + "clientToken: " + clientToken + "}";
  }

  public static ClientTokenStage builder() {
    return new Builder();
  }

  public interface ClientTokenStage {
    _FinalStage clientToken(String clientToken);

    Builder from(AuthenticationToken other);
  }

  public interface _FinalStage {
    AuthenticationToken build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements ClientTokenStage, _FinalStage {
    private String clientToken;

    private Builder() {
    }

    @Override
    public Builder from(AuthenticationToken other) {
      clientToken(other.getClientToken());
      return this;
    }

    @Override
    @JsonSetter("clientToken")
    public _FinalStage clientToken(String clientToken) {
      this.clientToken = clientToken;
      return this;
    }

    @Override
    public AuthenticationToken build() {
      return new AuthenticationToken(clientToken);
    }
  }
}
