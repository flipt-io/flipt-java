package com.flipt.api.client.distributions.endpoints;

import com.flipt.api.core.BasicAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Delete {
  private Delete() {
  }

  public static final class Request {
    private final Optional<BasicAuth> authOverride;

    private final String id;

    private final String variantId;

    private int _cachedHashCode;

    Request(Optional<BasicAuth> authOverride, String id, String variantId) {
      this.authOverride = authOverride;
      this.id = id;
      this.variantId = variantId;
    }

    public Optional<BasicAuth> getAuthOverride() {
      return authOverride;
    }

    public String getId() {
      return id;
    }

    public String getVariantId() {
      return variantId;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && id.equals(other.id) && variantId.equals(other.variantId);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.id, this.variantId);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Delete.Request{" + "authOverride: " + authOverride + ", id: " + id + ", variantId: " + variantId + "}";
    }

    public static IdStage builder() {
      return new Builder();
    }

    public interface IdStage {
      VariantIdStage id(String id);

      Builder from(Request other);
    }

    public interface VariantIdStage {
      _FinalStage variantId(String variantId);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    static final class Builder implements IdStage, VariantIdStage, _FinalStage {
      private String id;

      private String variantId;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        id(other.getId());
        variantId(other.getVariantId());
        return this;
      }

      @Override
      public VariantIdStage id(String id) {
        this.id = id;
        return this;
      }

      @Override
      public _FinalStage variantId(String variantId) {
        this.variantId = variantId;
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
        return new Request(authOverride, id, variantId);
      }
    }
  }
}
