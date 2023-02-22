package com.flipt.api.client.auth.endpoints;

import com.flipt.api.core.BearerAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Callback {
  private Callback() {
  }

  public static final class Request {
    private final String provider;

    private final String code;

    private final String state;

    private final Optional<BearerAuth> authOverride;

    private int _cachedHashCode;

    Request(String provider, String code, String state, Optional<BearerAuth> authOverride) {
      this.provider = provider;
      this.code = code;
      this.state = state;
      this.authOverride = authOverride;
    }

    public String getProvider() {
      return provider;
    }

    public String getCode() {
      return code;
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
      return provider.equals(other.provider) && code.equals(other.code) && state.equals(other.state) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.provider, this.code, this.state, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Callback.Request{" + "provider: " + provider + ", code: " + code + ", state: " + state + ", authOverride: " + authOverride + "}";
    }

    public static ProviderStage builder() {
      return new Builder();
    }

    public interface ProviderStage {
      CodeStage provider(String provider);

      Builder from(Request other);
    }

    public interface CodeStage {
      StateStage code(String code);
    }

    public interface StateStage {
      _FinalStage state(String state);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BearerAuth> authOverride);

      _FinalStage authOverride(BearerAuth authOverride);
    }

    public static final class Builder implements ProviderStage, CodeStage, StateStage, _FinalStage {
      private String provider;

      private String code;

      private String state;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        provider(other.getProvider());
        code(other.getCode());
        state(other.getState());
        authOverride(other.getAuthOverride());
        return this;
      }

      @Override
      public CodeStage provider(String provider) {
        this.provider = provider;
        return this;
      }

      @Override
      public StateStage code(String code) {
        this.code = code;
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
        return new Request(provider, code, state, authOverride);
      }
    }
  }
}
