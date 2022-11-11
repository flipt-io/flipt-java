package com.flipt.api.client.segments.types;

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
    builder = FliptSegmentList.Builder.class
)
public final class FliptSegmentList implements IPageable {
  private final String nextPageToken;

  private final int totalCount;

  private final List<FliptSegment> segments;

  private int _cachedHashCode;

  FliptSegmentList(String nextPageToken, int totalCount, List<FliptSegment> segments) {
    this.nextPageToken = nextPageToken;
    this.totalCount = totalCount;
    this.segments = segments;
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

  @JsonProperty("segments")
  public List<FliptSegment> getSegments() {
    return segments;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FliptSegmentList && equalTo((FliptSegmentList) other);
  }

  private boolean equalTo(FliptSegmentList other) {
    return nextPageToken.equals(other.nextPageToken) && totalCount == other.totalCount && segments.equals(other.segments);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.nextPageToken, this.totalCount, this.segments);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FliptSegmentList{" + "nextPageToken: " + nextPageToken + ", totalCount: " + totalCount + ", segments: " + segments + "}";
  }

  public static NextPageTokenStage builder() {
    return new Builder();
  }

  public interface NextPageTokenStage {
    TotalCountStage nextPageToken(String nextPageToken);

    Builder from(FliptSegmentList other);
  }

  public interface TotalCountStage {
    _FinalStage totalCount(int totalCount);
  }

  public interface _FinalStage {
    FliptSegmentList build();

    _FinalStage segments(List<FliptSegment> segments);

    _FinalStage segments(FliptSegment segments);

    _FinalStage addAllSegments(List<FliptSegment> segments);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements NextPageTokenStage, TotalCountStage, _FinalStage {
    private String nextPageToken;

    private int totalCount;

    private List<FliptSegment> segments = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(FliptSegmentList other) {
      nextPageToken(other.getNextPageToken());
      totalCount(other.getTotalCount());
      segments(other.getSegments());
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
    public _FinalStage addAllSegments(List<FliptSegment> segments) {
      this.segments.addAll(segments);
      return this;
    }

    @Override
    public _FinalStage segments(FliptSegment segments) {
      this.segments.add(segments);
      return this;
    }

    @Override
    @JsonSetter(
        value = "segments",
        nulls = Nulls.SKIP
    )
    public _FinalStage segments(List<FliptSegment> segments) {
      this.segments.clear();
      this.segments.addAll(segments);
      return this;
    }

    @Override
    public FliptSegmentList build() {
      return new FliptSegmentList(nextPageToken, totalCount, segments);
    }
  }
}
