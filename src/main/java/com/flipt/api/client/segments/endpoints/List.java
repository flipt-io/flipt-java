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
    private final Optional<BearerAuth> authOverride;

    private final Integer limit;

    private final Integer offset;

    private final String pageToken;

    private int _cachedHashCode;

    Request(Optional<BearerAuth> authOverride, Integer limit, Integer offset, String pageToken) {
      this.authOverride = authOverride;
      this.limit = limit;
      this.offset = offset;
      this.pageToken = pageToken;
    }

    public Optional<BearerAuth> getAuthOverride() {
      return authOverride;
    }

    public Integer getLimit() {
      return limit;
    }

    public Integer getOffset() {
      return offset;
    }

    public String getPageToken() {
      return pageToken;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && limit.equals(other.limit) && offset.equals(other.offset) && pageToken.equals(other.pageToken);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.limit, this.offset, this.pageToken);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "List.Request{" + "authOverride: " + authOverride + ", limit: " + limit + ", offset: " + offset + ", pageToken: " + pageToken + "}";
    }

    public static LimitStage builder() {
      return new Builder();
    }

    public interface LimitStage {
      OffsetStage limit(Integer limit);

      Builder from(Request other);
    }

    public interface OffsetStage {
      PageTokenStage offset(Integer offset);
    }

    public interface PageTokenStage {
      _FinalStage pageToken(String pageToken);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BearerAuth> authOverride);

      _FinalStage authOverride(BearerAuth authOverride);
    }

    static final class Builder implements LimitStage, OffsetStage, PageTokenStage, _FinalStage {
      private Integer limit;

      private Integer offset;

      private String pageToken;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        limit(other.getLimit());
        offset(other.getOffset());
        pageToken(other.getPageToken());
        return this;
      }

      @Override
      public OffsetStage limit(Integer limit) {
        this.limit = limit;
        return this;
      }

      @Override
      public PageTokenStage offset(Integer offset) {
        this.offset = offset;
        return this;
      }

      @Override
      public _FinalStage pageToken(String pageToken) {
        this.pageToken = pageToken;
        return this;
      }

      @Override
      public _FinalStage authOverride(BearerAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<BearerAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      @Override
      public Request build() {
        return new Request(authOverride, limit, offset, pageToken);
      }
    }
  }
}
