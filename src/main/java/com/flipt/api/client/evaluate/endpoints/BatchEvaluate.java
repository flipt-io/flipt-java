package com.flipt.api.client.evaluate.endpoints;

import com.flipt.api.client.evaluate.types.BatchEvaluationRequest;
import com.flipt.api.core.BearerAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class BatchEvaluate {
  private BatchEvaluate() {
  }

  public static final class Request {
    private final BatchEvaluationRequest body;

    private final Optional<BearerAuth> authOverride;

    private int _cachedHashCode;

    Request(BatchEvaluationRequest body, Optional<BearerAuth> authOverride) {
      this.body = body;
      this.authOverride = authOverride;
    }

    public BatchEvaluationRequest getBody() {
      return body;
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
      return body.equals(other.body) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.body, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "BatchEvaluate.Request{" + "body: " + body + ", authOverride: " + authOverride + "}";
    }

    public static BodyStage builder() {
      return new Builder();
    }

    public interface BodyStage {
      _FinalStage body(BatchEvaluationRequest body);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BearerAuth> authOverride);

      _FinalStage authOverride(BearerAuth authOverride);
    }

    public static final class Builder implements BodyStage, _FinalStage {
      private BatchEvaluationRequest body;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        body(other.getBody());
        authOverride(other.getAuthOverride());
        return this;
      }

      @Override
      public _FinalStage body(BatchEvaluationRequest body) {
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
        return new Request(body, authOverride);
      }
    }
  }
}
