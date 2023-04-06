package com.flipt.api.resources.auth.method.oidc.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = OidcAuthorizeUrlResponse.Builder.class
)
public final class OidcAuthorizeUrlResponse {
  private final String authorizeUrl;

  private int _cachedHashCode;

  OidcAuthorizeUrlResponse(String authorizeUrl) {
    this.authorizeUrl = authorizeUrl;
  }

  @JsonProperty("authorizeUrl")
  public String getAuthorizeUrl() {
    return authorizeUrl;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof OidcAuthorizeUrlResponse && equalTo((OidcAuthorizeUrlResponse) other);
  }

  private boolean equalTo(OidcAuthorizeUrlResponse other) {
    return authorizeUrl.equals(other.authorizeUrl);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.authorizeUrl);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "OidcAuthorizeUrlResponse{" + "authorizeUrl: " + authorizeUrl + "}";
  }

  public static AuthorizeUrlStage builder() {
    return new Builder();
  }

  public interface AuthorizeUrlStage {
    _FinalStage authorizeUrl(String authorizeUrl);

    Builder from(OidcAuthorizeUrlResponse other);
  }

  public interface _FinalStage {
    OidcAuthorizeUrlResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements AuthorizeUrlStage, _FinalStage {
    private String authorizeUrl;

    private Builder() {
    }

    @Override
    public Builder from(OidcAuthorizeUrlResponse other) {
      authorizeUrl(other.getAuthorizeUrl());
      return this;
    }

    @Override
    @JsonSetter("authorizeUrl")
    public _FinalStage authorizeUrl(String authorizeUrl) {
      this.authorizeUrl = authorizeUrl;
      return this;
    }

    @Override
    public OidcAuthorizeUrlResponse build() {
      return new OidcAuthorizeUrlResponse(authorizeUrl);
    }
  }
}
