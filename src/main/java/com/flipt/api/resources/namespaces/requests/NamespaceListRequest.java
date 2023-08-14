package com.flipt.api.resources.namespaces.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = NamespaceListRequest.Builder.class)
public final class NamespaceListRequest {
    private final Optional<Integer> limit;

    private final Optional<Integer> offset;

    private final Optional<String> pageToken;

    private NamespaceListRequest(Optional<Integer> limit, Optional<Integer> offset, Optional<String> pageToken) {
        this.limit = limit;
        this.offset = offset;
        this.pageToken = pageToken;
    }

    @JsonProperty("limit")
    public Optional<Integer> getLimit() {
        return limit;
    }

    @JsonProperty("offset")
    public Optional<Integer> getOffset() {
        return offset;
    }

    @JsonProperty("pageToken")
    public Optional<String> getPageToken() {
        return pageToken;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NamespaceListRequest && equalTo((NamespaceListRequest) other);
    }

    private boolean equalTo(NamespaceListRequest other) {
        return limit.equals(other.limit) && offset.equals(other.offset) && pageToken.equals(other.pageToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.limit, this.offset, this.pageToken);
    }

    @Override
    public String toString() {
        return "NamespaceListRequest{" + "limit: " + limit + ", offset: " + offset + ", pageToken: " + pageToken + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Integer> limit = Optional.empty();

        private Optional<Integer> offset = Optional.empty();

        private Optional<String> pageToken = Optional.empty();

        private Builder() {}

        public Builder from(NamespaceListRequest other) {
            limit(other.getLimit());
            offset(other.getOffset());
            pageToken(other.getPageToken());
            return this;
        }

        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public Builder limit(Optional<Integer> limit) {
            this.limit = limit;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = Optional.of(limit);
            return this;
        }

        @JsonSetter(value = "offset", nulls = Nulls.SKIP)
        public Builder offset(Optional<Integer> offset) {
            this.offset = offset;
            return this;
        }

        public Builder offset(Integer offset) {
            this.offset = Optional.of(offset);
            return this;
        }

        @JsonSetter(value = "pageToken", nulls = Nulls.SKIP)
        public Builder pageToken(Optional<String> pageToken) {
            this.pageToken = pageToken;
            return this;
        }

        public Builder pageToken(String pageToken) {
            this.pageToken = Optional.of(pageToken);
            return this;
        }

        public NamespaceListRequest build() {
            return new NamespaceListRequest(limit, offset, pageToken);
        }
    }
}
