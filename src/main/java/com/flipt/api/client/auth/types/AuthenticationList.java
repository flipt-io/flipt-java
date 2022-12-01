package com.flipt.api.client.auth.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = AuthenticationList.Builder.class
)
public final class AuthenticationList {
  private final List<Authentication> authentications;

  private final String nextPageToken;

  private int _cachedHashCode;

  AuthenticationList(List<Authentication> authentications, String nextPageToken) {
    this.authentications = authentications;
    this.nextPageToken = nextPageToken;
  }

  @JsonProperty("authentications")
  public List<Authentication> getAuthentications() {
    return authentications;
  }

  @JsonProperty("nextPageToken")
  public String getNextPageToken() {
    return nextPageToken;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AuthenticationList && equalTo((AuthenticationList) other);
  }

  private boolean equalTo(AuthenticationList other) {
    return authentications.equals(other.authentications) && nextPageToken.equals(other.nextPageToken);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.authentications, this.nextPageToken);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AuthenticationList{" + "authentications: " + authentications + ", nextPageToken: " + nextPageToken + "}";
  }

  public static NextPageTokenStage builder() {
    return new Builder();
  }

  public interface NextPageTokenStage {
    _FinalStage nextPageToken(String nextPageToken);

    Builder from(AuthenticationList other);
  }

  public interface _FinalStage {
    AuthenticationList build();

    _FinalStage authentications(List<Authentication> authentications);

    _FinalStage authentications(Authentication authentications);

    _FinalStage addAllAuthentications(List<Authentication> authentications);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NextPageTokenStage, _FinalStage {
    private String nextPageToken;

    private List<Authentication> authentications = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(AuthenticationList other) {
      authentications(other.getAuthentications());
      nextPageToken(other.getNextPageToken());
      return this;
    }

    @Override
    @JsonSetter("nextPageToken")
    public _FinalStage nextPageToken(String nextPageToken) {
      this.nextPageToken = nextPageToken;
      return this;
    }

    @Override
    public _FinalStage addAllAuthentications(List<Authentication> authentications) {
      this.authentications.addAll(authentications);
      return this;
    }

    @Override
    public _FinalStage authentications(Authentication authentications) {
      this.authentications.add(authentications);
      return this;
    }

    @Override
    @JsonSetter(
        value = "authentications",
        nulls = Nulls.SKIP
    )
    public _FinalStage authentications(List<Authentication> authentications) {
      this.authentications.clear();
      this.authentications.addAll(authentications);
      return this;
    }

    @Override
    public AuthenticationList build() {
      return new AuthenticationList(authentications, nextPageToken);
    }
  }
}
