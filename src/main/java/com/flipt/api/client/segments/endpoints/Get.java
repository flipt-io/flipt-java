package com.flipt.api.client.segments.endpoints;

import com.flipt.api.core.BasicAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Get {
  private Get() {
  }

  public static final class Request {
    private final Optional<BasicAuth> authOverride;

    private final String key;

    private int _cachedHashCode;

    Request(Optional<BasicAuth> authOverride, String key) {
      this.authOverride = authOverride;
      this.key = key;
    }

    public Optional<BasicAuth> getAuthOverride() {
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
      return "Get.Request{" + "authOverride: " + authOverride + ", key: " + key + "}";
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

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    static final class Builder implements KeyStage, _FinalStage {
      private String key;

      private Optional<BasicAuth> authOverride = Optional.empty();

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
      public _FinalStage authOverride(BasicAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<BasicAuth> authOverride) {
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
