package com.flipt.api.client.flags.types;

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
    builder = FlagList.Builder.class
)
public final class FlagList implements IPageable {
  private final String nextPageToken;

  private final int totalCount;

  private final List<Flag> flags;

  private int _cachedHashCode;

  FlagList(String nextPageToken, int totalCount, List<Flag> flags) {
    this.nextPageToken = nextPageToken;
    this.totalCount = totalCount;
    this.flags = flags;
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

  @JsonProperty("flags")
  public List<Flag> getFlags() {
    return flags;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FlagList && equalTo((FlagList) other);
  }

  private boolean equalTo(FlagList other) {
    return nextPageToken.equals(other.nextPageToken) && totalCount == other.totalCount && flags.equals(other.flags);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.nextPageToken, this.totalCount, this.flags);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FlagList{" + "nextPageToken: " + nextPageToken + ", totalCount: " + totalCount + ", flags: " + flags + "}";
  }

  public static NextPageTokenStage builder() {
    return new Builder();
  }

  public interface NextPageTokenStage {
    TotalCountStage nextPageToken(String nextPageToken);

    Builder from(FlagList other);
  }

  public interface TotalCountStage {
    _FinalStage totalCount(int totalCount);
  }

  public interface _FinalStage {
    FlagList build();

    _FinalStage flags(List<Flag> flags);

    _FinalStage flags(Flag flags);

    _FinalStage addAllFlags(List<Flag> flags);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements NextPageTokenStage, TotalCountStage, _FinalStage {
    private String nextPageToken;

    private int totalCount;

    private List<Flag> flags = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(FlagList other) {
      nextPageToken(other.getNextPageToken());
      totalCount(other.getTotalCount());
      flags(other.getFlags());
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
    public _FinalStage addAllFlags(List<Flag> flags) {
      this.flags.addAll(flags);
      return this;
    }

    @Override
    public _FinalStage flags(Flag flags) {
      this.flags.add(flags);
      return this;
    }

    @Override
    @JsonSetter(
        value = "flags",
        nulls = Nulls.SKIP
    )
    public _FinalStage flags(List<Flag> flags) {
      this.flags.clear();
      this.flags.addAll(flags);
      return this;
    }

    @Override
    public FlagList build() {
      return new FlagList(nextPageToken, totalCount, flags);
    }
  }
}
