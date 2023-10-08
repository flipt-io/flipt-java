/**
 */
package com.flipt.api.resources.rollouts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RolloutCreateRequest.Builder.class)
public final class RolloutCreateRequest {
    private final int rank;

    private final Optional<String> description;

    private final Optional<RolloutSegment> segment;

    private final Optional<RolloutThreshold> threshold;

    private RolloutCreateRequest(
            int rank,
            Optional<String> description,
            Optional<RolloutSegment> segment,
            Optional<RolloutThreshold> threshold) {
        this.rank = rank;
        this.description = description;
        this.segment = segment;
        this.threshold = threshold;
    }

    @JsonProperty("rank")
    public int getRank() {
        return rank;
    }

    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("segment")
    public Optional<RolloutSegment> getSegment() {
        return segment;
    }

    @JsonProperty("threshold")
    public Optional<RolloutThreshold> getThreshold() {
        return threshold;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RolloutCreateRequest && equalTo((RolloutCreateRequest) other);
    }

    private boolean equalTo(RolloutCreateRequest other) {
        return rank == other.rank
                && description.equals(other.description)
                && segment.equals(other.segment)
                && threshold.equals(other.threshold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rank, this.description, this.segment, this.threshold);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RankStage builder() {
        return new Builder();
    }

    public interface RankStage {
        _FinalStage rank(int rank);

        Builder from(RolloutCreateRequest other);
    }

    public interface _FinalStage {
        RolloutCreateRequest build();

        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);

        _FinalStage segment(Optional<RolloutSegment> segment);

        _FinalStage segment(RolloutSegment segment);

        _FinalStage threshold(Optional<RolloutThreshold> threshold);

        _FinalStage threshold(RolloutThreshold threshold);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RankStage, _FinalStage {
        private int rank;

        private Optional<RolloutThreshold> threshold = Optional.empty();

        private Optional<RolloutSegment> segment = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RolloutCreateRequest other) {
            rank(other.getRank());
            description(other.getDescription());
            segment(other.getSegment());
            threshold(other.getThreshold());
            return this;
        }

        @Override
        @JsonSetter("rank")
        public _FinalStage rank(int rank) {
            this.rank = rank;
            return this;
        }

        @Override
        public _FinalStage threshold(RolloutThreshold threshold) {
            this.threshold = Optional.of(threshold);
            return this;
        }

        @Override
        @JsonSetter(value = "threshold", nulls = Nulls.SKIP)
        public _FinalStage threshold(Optional<RolloutThreshold> threshold) {
            this.threshold = threshold;
            return this;
        }

        @Override
        public _FinalStage segment(RolloutSegment segment) {
            this.segment = Optional.of(segment);
            return this;
        }

        @Override
        @JsonSetter(value = "segment", nulls = Nulls.SKIP)
        public _FinalStage segment(Optional<RolloutSegment> segment) {
            this.segment = segment;
            return this;
        }

        @Override
        public _FinalStage description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        @Override
        public RolloutCreateRequest build() {
            return new RolloutCreateRequest(rank, description, segment, threshold);
        }
    }
}
