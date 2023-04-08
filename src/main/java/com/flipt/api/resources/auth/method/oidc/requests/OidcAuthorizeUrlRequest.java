package com.flipt.api.resources.auth.method.oidc.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = OidcAuthorizeUrlRequest.Builder.class
)
public final class OidcAuthorizeUrlRequest {
  private final String state;

  private int _cachedHashCode;

  OidcAuthorizeUrlRequest(String state) {
    this.state = state;
  }

  @JsonProperty("state")
  public String getState() {
    return state;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof OidcAuthorizeUrlRequest && equalTo((OidcAuthorizeUrlRequest) other);
  }

  private boolean equalTo(OidcAuthorizeUrlRequest other) {
    return state.equals(other.state);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.state);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "OidcAuthorizeUrlRequest{" + "state: " + state + "}";
  }

  public static StateStage builder() {
    return new Builder();
  }

  public interface StateStage {
    _FinalStage state(String state);

    Builder from(OidcAuthorizeUrlRequest other);
  }

  public interface _FinalStage {
    OidcAuthorizeUrlRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements StateStage, _FinalStage {
    private String state;

    private Builder() {
    }

    @Override
    public Builder from(OidcAuthorizeUrlRequest other) {
      state(other.getState());
      return this;
    }

    @Override
    @JsonSetter("state")
    public _FinalStage state(String state) {
      this.state = state;
      return this;
    }

    @Override
    public OidcAuthorizeUrlRequest build() {
      return new OidcAuthorizeUrlRequest(state);
    }
  }
}