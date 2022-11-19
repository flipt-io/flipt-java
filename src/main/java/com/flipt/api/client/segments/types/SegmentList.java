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
    builder = SegmentList.Builder.class
)
public final class SegmentList implements IPageable {
  private final String nextPageToken;

  private final int totalCount;

  private final List<Segment> segments;

  private int _cachedHashCode;

  SegmentList(String nextPageToken, int totalCount, List<Segment> segments) {
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
  public List<Segment> getSegments() {
    return segments;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SegmentList && equalTo((SegmentList) other);
  }

  private boolean equalTo(SegmentList other) {
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
    return "SegmentList{" + "nextPageToken: " + nextPageToken + ", totalCount: " + totalCount + ", segments: " + segments + "}";
  }

  public static NextPageTokenStage builder() {
    return new Builder();
  }

  public interface NextPageTokenStage {
    TotalCountStage nextPageToken(String nextPageToken);

    Builder from(SegmentList other);
  }

  public interface TotalCountStage {
    _FinalStage totalCount(int totalCount);
  }

  public interface _FinalStage {
    SegmentList build();

    _FinalStage segments(List<Segment> segments);

    _FinalStage segments(Segment segments);

    _FinalStage addAllSegments(List<Segment> segments);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements NextPageTokenStage, TotalCountStage, _FinalStage {
    private String nextPageToken;

    private int totalCount;

    private List<Segment> segments = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(SegmentList other) {
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
    public _FinalStage addAllSegments(List<Segment> segments) {
      this.segments.addAll(segments);
      return this;
    }

    @Override
    public _FinalStage segments(Segment segments) {
      this.segments.add(segments);
      return this;
    }

    @Override
    @JsonSetter(
        value = "segments",
        nulls = Nulls.SKIP
    )
    public _FinalStage segments(List<Segment> segments) {
      this.segments.clear();
      this.segments.addAll(segments);
      return this;
    }

    @Override
    public SegmentList build() {
      return new SegmentList(nextPageToken, totalCount, segments);
    }
  }
}
