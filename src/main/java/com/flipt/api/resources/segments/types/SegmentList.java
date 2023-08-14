package com.flipt.api.resources.segments.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SegmentList.Builder.class)
public final class SegmentList {
    private final List<Segment> segments;

    private final String nextPageToken;

    private final int totalCount;

    private SegmentList(List<Segment> segments, String nextPageToken, int totalCount) {
        this.segments = segments;
        this.nextPageToken = nextPageToken;
        this.totalCount = totalCount;
    }

    @JsonProperty("segments")
    public List<Segment> getSegments() {
        return segments;
    }

    @JsonProperty("nextPageToken")
    public String getNextPageToken() {
        return nextPageToken;
    }

    @JsonProperty("totalCount")
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SegmentList && equalTo((SegmentList) other);
    }

    private boolean equalTo(SegmentList other) {
        return segments.equals(other.segments)
                && nextPageToken.equals(other.nextPageToken)
                && totalCount == other.totalCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.segments, this.nextPageToken, this.totalCount);
    }

    @Override
    public String toString() {
        return "SegmentList{" + "segments: " + segments + ", nextPageToken: " + nextPageToken + ", totalCount: "
                + totalCount + "}";
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

        _FinalStage addSegments(Segment segments);

        _FinalStage addAllSegments(List<Segment> segments);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NextPageTokenStage, TotalCountStage, _FinalStage {
        private String nextPageToken;

        private int totalCount;

        private List<Segment> segments = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(SegmentList other) {
            segments(other.getSegments());
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
        public _FinalStage addAllSegments(List<Segment> segments) {
            this.segments.addAll(segments);
            return this;
        }

        @Override
        public _FinalStage addSegments(Segment segments) {
            this.segments.add(segments);
            return this;
        }

        @Override
        @JsonSetter(value = "segments", nulls = Nulls.SKIP)
        public _FinalStage segments(List<Segment> segments) {
            this.segments.clear();
            this.segments.addAll(segments);
            return this;
        }

        @Override
        public SegmentList build() {
            return new SegmentList(segments, nextPageToken, totalCount);
        }
    }
}
