package com.flipt.api.resources.auth.types;

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

  private final Authentication authentication;

  private int _cachedHashCode;

  AuthenticationToken(String clientToken, Authentication authentication) {
    this.clientToken = clientToken;
    this.authentication = authentication;
  }

  @JsonProperty("clientToken")
  public String getClientToken() {
    return clientToken;
  }

  @JsonProperty("authentication")
  public Authentication getAuthentication() {
    return authentication;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AuthenticationToken && equalTo((AuthenticationToken) other);
  }

  private boolean equalTo(AuthenticationToken other) {
    return clientToken.equals(other.clientToken) && authentication.equals(other.authentication);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.clientToken, this.authentication);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AuthenticationToken{" + "clientToken: " + clientToken + ", authentication: " + authentication + "}";
  }

  public static ClientTokenStage builder() {
    return new Builder();
  }

  public interface ClientTokenStage {
    AuthenticationStage clientToken(String clientToken);

    Builder from(AuthenticationToken other);
  }

  public interface AuthenticationStage {
    _FinalStage authentication(Authentication authentication);
  }

  public interface _FinalStage {
    AuthenticationToken build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ClientTokenStage, AuthenticationStage, _FinalStage {
    private String clientToken;

    private Authentication authentication;

    private Builder() {
    }

    @Override
    public Builder from(AuthenticationToken other) {
      clientToken(other.getClientToken());
      authentication(other.getAuthentication());
      return this;
    }

    @Override
    @JsonSetter("clientToken")
    public AuthenticationStage clientToken(String clientToken) {
      this.clientToken = clientToken;
      return this;
    }

    @Override
    @JsonSetter("authentication")
    public _FinalStage authentication(Authentication authentication) {
      this.authentication = authentication;
      return this;
    }

    @Override
    public AuthenticationToken build() {
      return new AuthenticationToken(clientToken, authentication);
    }
  }
}
