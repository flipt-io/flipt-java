package com.flipt.api.client.segments.endpoints;

import com.flipt.api.core.BearerAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Delete {
  private Delete() {
  }

  public static final class Request {
    private final String key;

    private final Optional<BearerAuth> authOverride;

    private int _cachedHashCode;

    Request(String key, Optional<BearerAuth> authOverride) {
      this.key = key;
      this.authOverride = authOverride;
    }

    public String getKey() {
      return key;
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
      return key.equals(other.key) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.key, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Delete.Request{" + "key: " + key + ", authOverride: " + authOverride + "}";
    }

    public static KeyStage builder() {
      return new Builder();
    }

    public interface KeyStage {
      _FinalStage key(String key);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BearerAuth> authOverride);

      _FinalStage authOverride(BearerAuth authOverride);
    }

    public static final class Builder implements KeyStage, _FinalStage {
      private String key;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        key(other.getKey());
        authOverride(other.getAuthOverride());
        return this;
      }

      @Override
      public _FinalStage key(String key) {
        this.key = key;
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
        return new Request(key, authOverride);
      }
    }
  }
}
