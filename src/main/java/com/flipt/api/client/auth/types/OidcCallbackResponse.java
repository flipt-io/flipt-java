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
    builder = OidcCallbackResponse.Builder.class
)
public final class OidcCallbackResponse {
  private final Authentication authentication;

  private int _cachedHashCode;

  OidcCallbackResponse(Authentication authentication) {
    this.authentication = authentication;
  }

  @JsonProperty("authentication")
  public Authentication getAuthentication() {
    return authentication;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof OidcCallbackResponse && equalTo((OidcCallbackResponse) other);
  }

  private boolean equalTo(OidcCallbackResponse other) {
    return authentication.equals(other.authentication);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.authentication);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "OidcCallbackResponse{" + "authentication: " + authentication + "}";
  }

  public static AuthenticationStage builder() {
    return new Builder();
  }

  public interface AuthenticationStage {
    _FinalStage authentication(Authentication authentication);

    Builder from(OidcCallbackResponse other);
  }

  public interface _FinalStage {
    OidcCallbackResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements AuthenticationStage, _FinalStage {
    private Authentication authentication;

    private Builder() {
    }

    @Override
    public Builder from(OidcCallbackResponse other) {
      authentication(other.getAuthentication());
      return this;
    }

    @Override
    @JsonSetter("authentication")
    public _FinalStage authentication(Authentication authentication) {
      this.authentication = authentication;
      return this;
    }

    @Override
    public OidcCallbackResponse build() {
      return new OidcCallbackResponse(authentication);
    }
  }
}
