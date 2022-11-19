package com.flipt.api.client.constraints.endpoints;

import com.flipt.api.client.constraints.types.ConstraintUpdateRequest;
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

    private final String id;

    private final ConstraintUpdateRequest body;

    private int _cachedHashCode;

    Request(Optional<BasicAuth> authOverride, String id, ConstraintUpdateRequest body) {
      this.authOverride = authOverride;
      this.id = id;
      this.body = body;
    }

    public Optional<BasicAuth> getAuthOverride() {
      return authOverride;
    }

    public String getId() {
      return id;
    }

    public ConstraintUpdateRequest getBody() {
      return body;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return authOverride.equals(other.authOverride) && id.equals(other.id) && body.equals(other.body);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.authOverride, this.id, this.body);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Update.Request{" + "authOverride: " + authOverride + ", id: " + id + ", body: " + body + "}";
    }

    public static IdStage builder() {
      return new Builder();
    }

    public interface IdStage {
      BodyStage id(String id);

      Builder from(Request other);
    }

    public interface BodyStage {
      _FinalStage body(ConstraintUpdateRequest body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    static final class Builder implements IdStage, BodyStage, _FinalStage {
      private String id;

      private ConstraintUpdateRequest body;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        authOverride(other.getAuthOverride());
        id(other.getId());
        body(other.getBody());
        return this;
      }

      @Override
      public BodyStage id(String id) {
        this.id = id;
        return this;
      }

      @Override
      public _FinalStage body(ConstraintUpdateRequest body) {
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
        return new Request(authOverride, id, body);
      }
    }
  }
}
