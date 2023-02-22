package com.flipt.api.client.auth.endpoints;

import com.flipt.api.core.BearerAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class AuthorizeUrl {
  private AuthorizeUrl() {
  }

  public static final class Request {
    private final String provider;

    private final String state;

    private final Optional<BearerAuth> authOverride;

    private int _cachedHashCode;

    Request(String provider, String state, Optional<BearerAuth> authOverride) {
      this.provider = provider;
      this.state = state;
      this.authOverride = authOverride;
    }

    public String getProvider() {
      return provider;
    }

    public String getState() {
      return state;
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
      return provider.equals(other.provider) && state.equals(other.state) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.provider, this.state, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "AuthorizeUrl.Request{" + "provider: " + provider + ", state: " + state + ", authOverride: " + authOverride + "}";
    }

    public static ProviderStage builder() {
      return new Builder();
    }

    public interface ProviderStage {
      StateStage provider(String provider);

      Builder from(Request other);
    }

    public interface StateStage {
      _FinalStage state(String state);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BearerAuth> authOverride);

      _FinalStage authOverride(BearerAuth authOverride);
    }

    public static final class Builder implements ProviderStage, StateStage, _FinalStage {
      private String provider;

      private String state;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        provider(other.getProvider());
        state(other.getState());
        authOverride(other.getAuthOverride());
        return this;
      }

      @Override
      public StateStage provider(String provider) {
        this.provider = provider;
        return this;
      }

      @Override
      public _FinalStage state(String state) {
        this.state = state;
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
        return new Request(provider, state, authOverride);
      }
    }
  }
}
