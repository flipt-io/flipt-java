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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RolloutList.Builder.class)
public final class RolloutList {
    private final List<Rollout> rollouts;

    private final String nextPageToken;

    private final int totalCount;

    private RolloutList(List<Rollout> rollouts, String nextPageToken, int totalCount) {
        this.rollouts = rollouts;
        this.nextPageToken = nextPageToken;
        this.totalCount = totalCount;
    }

    @JsonProperty("rollouts")
    public List<Rollout> getRollouts() {
        return rollouts;
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
        return other instanceof RolloutList && equalTo((RolloutList) other);
    }

    private boolean equalTo(RolloutList other) {
        return rollouts.equals(other.rollouts)
                && nextPageToken.equals(other.nextPageToken)
                && totalCount == other.totalCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rollouts, this.nextPageToken, this.totalCount);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NextPageTokenStage builder() {
        return new Builder();
    }

    public interface NextPageTokenStage {
        TotalCountStage nextPageToken(String nextPageToken);

        Builder from(RolloutList other);
    }

    public interface TotalCountStage {
        _FinalStage totalCount(int totalCount);
    }

    public interface _FinalStage {
        RolloutList build();

        _FinalStage rollouts(List<Rollout> rollouts);

        _FinalStage addRollouts(Rollout rollouts);

        _FinalStage addAllRollouts(List<Rollout> rollouts);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NextPageTokenStage, TotalCountStage, _FinalStage {
        private String nextPageToken;

        private int totalCount;

        private List<Rollout> rollouts = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(RolloutList other) {
            rollouts(other.getRollouts());
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
        public _FinalStage addAllRollouts(List<Rollout> rollouts) {
            this.rollouts.addAll(rollouts);
            return this;
        }

        @Override
        public _FinalStage addRollouts(Rollout rollouts) {
            this.rollouts.add(rollouts);
            return this;
        }

        @Override
        @JsonSetter(value = "rollouts", nulls = Nulls.SKIP)
        public _FinalStage rollouts(List<Rollout> rollouts) {
            this.rollouts.clear();
            this.rollouts.addAll(rollouts);
            return this;
        }

        @Override
        public RolloutList build() {
            return new RolloutList(rollouts, nextPageToken, totalCount);
        }
    }
}
