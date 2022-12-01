package com.flipt.api.client.segments.endpoints;

import com.flipt.api.core.BearerAuth;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class List {
  private List() {
  }

  public static final class Request {
    private final Optional<Integer> limit;

    private final Optional<Integer> offset;

    private final Optional<String> pageToken;

    private final Optional<BearerAuth> authOverride;

    private int _cachedHashCode;

    Request(Optional<Integer> limit, Optional<Integer> offset, Optional<String> pageToken,
        Optional<BearerAuth> authOverride) {
      this.limit = limit;
      this.offset = offset;
      this.pageToken = pageToken;
      this.authOverride = authOverride;
    }

    public Optional<Integer> getLimit() {
      return limit;
    }

    public Optional<Integer> getOffset() {
      return offset;
    }

    public Optional<String> getPageToken() {
      return pageToken;
    }

    public Optional<BearerAuth> getAuthOverride() {
      return authOverride;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return limit.equals(other.limit) && offset.equals(other.offset) && pageToken.equals(other.pageToken) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.limit, this.offset, this.pageToken, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "List.Request{" + "limit: " + limit + ", offset: " + offset + ", pageToken: " + pageToken + ", authOverride: " + authOverride + "}";
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Builder {
      private Optional<Integer> limit = Optional.empty();

      private Optional<Integer> offset = Optional.empty();

      private Optional<String> pageToken = Optional.empty();

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      public Builder from(Request other) {
        limit(other.getLimit());
        offset(other.getOffset());
        pageToken(other.getPageToken());
        authOverride(other.getAuthOverride());
        return this;
      }

      public Builder limit(Optional<Integer> limit) {
        this.limit = limit;
        return this;
      }

      public Builder limit(Integer limit) {
        this.limit = Optional.of(limit);
        return this;
      }

      public Builder offset(Optional<Integer> offset) {
        this.offset = offset;
        return this;
      }

      public Builder offset(Integer offset) {
        this.offset = Optional.of(offset);
        return this;
      }

      public Builder pageToken(Optional<String> pageToken) {
        this.pageToken = pageToken;
        return this;
      }

      public Builder pageToken(String pageToken) {
        this.pageToken = Optional.of(pageToken);
        return this;
      }

      public Builder authOverride(Optional<BearerAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      public Builder authOverride(BearerAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      public Request build() {
        return new Request(limit, offset, pageToken, authOverride);
      }
    }
  }
}
