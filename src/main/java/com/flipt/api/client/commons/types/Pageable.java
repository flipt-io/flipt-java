package com.flipt.api.client.commons.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = Pageable.Builder.class
)
public final class Pageable implements IPageable {
  private final String nextPageToken;

  private final int totalCount;

  private int _cachedHashCode;

  Pageable(String nextPageToken, int totalCount) {
    this.nextPageToken = nextPageToken;
    this.totalCount = totalCount;
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

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Pageable && equalTo((Pageable) other);
  }

  private boolean equalTo(Pageable other) {
    return nextPageToken.equals(other.nextPageToken) && totalCount == other.totalCount;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.nextPageToken, this.totalCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Pageable{" + "nextPageToken: " + nextPageToken + ", totalCount: " + totalCount + "}";
  }

  public static NextPageTokenStage builder() {
    return new Builder();
  }

  public interface NextPageTokenStage {
    TotalCountStage nextPageToken(String nextPageToken);

    Builder from(Pageable other);
  }

  public interface TotalCountStage {
    _FinalStage totalCount(int totalCount);
  }

  public interface _FinalStage {
    Pageable build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements NextPageTokenStage, TotalCountStage, _FinalStage {
    private String nextPageToken;

    private int totalCount;

    private Builder() {
    }

    @Override
    public Builder from(Pageable other) {
      nextPageToken(other.getNextPageToken());
      totalCount(other.getTotalCount());
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
    public Pageable build() {
      return new Pageable(nextPageToken, totalCount);
    }
  }
}
