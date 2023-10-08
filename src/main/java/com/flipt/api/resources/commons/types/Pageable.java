/**
 */
package com.flipt.api.resources.commons.types;

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
@JsonDeserialize(builder = Pageable.Builder.class)
public final class Pageable {
    private final Optional<String> nextPageToken;

    private final Optional<Integer> totalCount;

    private Pageable(Optional<String> nextPageToken, Optional<Integer> totalCount) {
        this.nextPageToken = nextPageToken;
        this.totalCount = totalCount;
    }

    @JsonProperty("nextPageToken")
    public Optional<String> getNextPageToken() {
        return nextPageToken;
    }

    @JsonProperty("totalCount")
    public Optional<Integer> getTotalCount() {
        return totalCount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Pageable && equalTo((Pageable) other);
    }

    private boolean equalTo(Pageable other) {
        return nextPageToken.equals(other.nextPageToken) && totalCount.equals(other.totalCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nextPageToken, this.totalCount);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> nextPageToken = Optional.empty();

        private Optional<Integer> totalCount = Optional.empty();

        private Builder() {}

        public Builder from(Pageable other) {
            nextPageToken(other.getNextPageToken());
            totalCount(other.getTotalCount());
            return this;
        }

        @JsonSetter(value = "nextPageToken", nulls = Nulls.SKIP)
        public Builder nextPageToken(Optional<String> nextPageToken) {
            this.nextPageToken = nextPageToken;
            return this;
        }

        public Builder nextPageToken(String nextPageToken) {
            this.nextPageToken = Optional.of(nextPageToken);
            return this;
        }

        @JsonSetter(value = "totalCount", nulls = Nulls.SKIP)
        public Builder totalCount(Optional<Integer> totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Builder totalCount(Integer totalCount) {
            this.totalCount = Optional.of(totalCount);
            return this;
        }

        public Pageable build() {
            return new Pageable(nextPageToken, totalCount);
        }
    }
}
