package com.flipt.api.client.segments.endpoints;

import com.flipt.api.client.segments.types.SegmentUpdateRequest;
import com.flipt.api.core.BasicAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Update {
  private Update() {
  }

  public static final class Request {
    private final Optional<BasicAuth> authOverride;

    private final String key;

    private final SegmentUpdateRequest body;

    private int _cachedHashCode;

    Request(Optional<BasicAuth> authOverride, String key, SegmentUpdateRequest body) {
      this.authOverride = authOverride;
      this.key = key;
      this.body = body;
    }

    public Optional<BasicAuth> getAuthOverride() {
      return authOverride;
    }

    public String getKey() {
      return key;
    }

    public SegmentUpdateRequest getBody() {
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
      _FinalStage body(SegmentUpdateRequest body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    static final class Builder implements KeyStage, BodyStage, _FinalStage {
      private String key;

      private SegmentUpdateRequest body;

      private Optional<BasicAuth> authOverride = Optional.empty();

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
      public _FinalStage body(SegmentUpdateRequest body) {
        this.body = body;
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
        return new Request(authOverride, key, body);
      }
    }
  }
}
