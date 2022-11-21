package com.flipt.api.client.flags.endpoints;

import com.flipt.api.client.flags.types.FlagUpdateRequest;
import com.flipt.api.core.BearerAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Update {
  private Update() {
  }

  public static final class Request {
    private final Optional<BearerAuth> authOverride;

    private final String key;

    private final FlagUpdateRequest body;

    private int _cachedHashCode;

    Request(Optional<BearerAuth> authOverride, String key, FlagUpdateRequest body) {
      this.authOverride = authOverride;
      this.key = key;
      this.body = body;
    }

    public Optional<BearerAuth> getAuthOverride() {
      return authOverride;
    }

    public String getKey() {
      return key;
    }

    public FlagUpdateRequest getBody() {
      return body;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && key.equals(other.key) && body.equals(other.body);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.key, this.body);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Update.Request{" + "authOverride: " + authOverride + ", key: " + key + ", body: " + body + "}";
    }

    public static KeyStage builder() {
      return new Builder();
    }

    public interface KeyStage {
      BodyStage key(String key);

      Builder from(Request other);
    }

    public interface BodyStage {
      _FinalStage body(FlagUpdateRequest body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BearerAuth> authOverride);

      _FinalStage authOverride(BearerAuth authOverride);
    }

    static final class Builder implements KeyStage, BodyStage, _FinalStage {
      private String key;

      private FlagUpdateRequest body;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        key(other.getKey());
        body(other.getBody());
        return this;
      }

      @Override
      public BodyStage key(String key) {
        this.key = key;
        return this;
      }

      @Override
      public _FinalStage body(FlagUpdateRequest body) {
        this.body = body;
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
        return new Request(authOverride, key, body);
      }
    }
  }
}
