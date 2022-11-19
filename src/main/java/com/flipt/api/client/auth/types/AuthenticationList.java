package com.flipt.api.client.auth.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.client.commons.types.IPageable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = AuthenticationList.Builder.class
)
public final class AuthenticationList implements IPageable {
  private final String nextPageToken;

  private final int totalCount;

  private final List<Authentication> authentications;

  private int _cachedHashCode;

  AuthenticationList(String nextPageToken, int totalCount, List<Authentication> authentications) {
    this.nextPageToken = nextPageToken;
    this.totalCount = totalCount;
    this.authentications = authentications;
  }

  @JsonProperty("nextPageToken")
  @Override
  public String getNextPageToken() {
    return nextPageToken;
  }

  @JsonProperty("totalCount")
  @Override
  public int getTotalCount() {
    return totalCount;
  }

  @JsonProperty("authentications")
  public List<Authentication> getAuthentications() {
    return authentications;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AuthenticationList && equalTo((AuthenticationList) other);
  }

  private boolean equalTo(AuthenticationList other) {
    return nextPageToken.equals(other.nextPageToken) && totalCount == other.totalCount && authentications.equals(other.authentications);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.nextPageToken, this.totalCount, this.authentications);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AuthenticationList{" + "nextPageToken: " + nextPageToken + ", totalCount: " + totalCount + ", authentications: " + authentications + "}";
  }

  public static NextPageTokenStage builder() {
    return new Builder();
  }

  public interface NextPageTokenStage {
    TotalCountStage nextPageToken(String nextPageToken);

    Builder from(AuthenticationList other);
  }

  public interface TotalCountStage {
    _FinalStage totalCount(int totalCount);
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
  static final class Builder implements NextPageTokenStage, TotalCountStage, _FinalStage {
    private String nextPageToken;

    private int totalCount;

    private List<Authentication> authentications = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(AuthenticationList other) {
      nextPageToken(other.getNextPageToken());
      totalCount(other.getTotalCount());
      authentications(other.getAuthentications());
      return this;
    }

    @Override
    @JsonSetter("nextPageToken")
    public TotalCountStage nextPageToken(String nextPageToken) {
      this.nextPageToken = nextPageToken;
      return this;
    }

    @Override
    @JsonSetter("totalCount")
    public _FinalStage totalCount(int totalCount) {
      this.totalCount = totalCount;
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
      return new AuthenticationList(nextPageToken, totalCount, authentications);
    }
  }
}
