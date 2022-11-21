package com.flipt.api.client.flags.endpoints;

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
    private final Optional<BearerAuth> authOverride;

    private final String key;

    private int _cachedHashCode;

    Request(Optional<BearerAuth> authOverride, String key) {
      this.authOverride = authOverride;
      this.key = key;
    }

    public Optional<BearerAuth> getAuthOverride() {
      return authOverride;
    }

    public String getKey() {
      return key;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && key.equals(other.key);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.key);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Delete.Request{" + "authOverride: " + authOverride + ", key: " + key + "}";
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

    static final class Builder implements KeyStage, _FinalStage {
      private String key;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        key(other.getKey());
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
        return new Request(authOverride, key);
      }
    }
  }
}
