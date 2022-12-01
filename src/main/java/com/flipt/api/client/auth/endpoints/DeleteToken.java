package com.flipt.api.client.auth.endpoints;

import com.flipt.api.core.BearerAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class DeleteToken {
  private DeleteToken() {
  }

  public static final class Request {
    private final String id;

    private final Optional<BearerAuth> authOverride;

    private int _cachedHashCode;

    Request(String id, Optional<BearerAuth> authOverride) {
      this.id = id;
      this.authOverride = authOverride;
    }

    public String getId() {
      return id;
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
      return id.equals(other.id) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.id, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "DeleteToken.Request{" + "id: " + id + ", authOverride: " + authOverride + "}";
    }

    public static IdStage builder() {
      return new Builder();
    }

    public interface IdStage {
      _FinalStage id(String id);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BearerAuth> authOverride);

      _FinalStage authOverride(BearerAuth authOverride);
    }

    public static final class Builder implements IdStage, _FinalStage {
      private String id;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        id(other.getId());
        authOverride(other.getAuthOverride());
        return this;
      }

      @Override
      public _FinalStage id(String id) {
        this.id = id;
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
        return new Request(id, authOverride);
      }
    }
  }
}
