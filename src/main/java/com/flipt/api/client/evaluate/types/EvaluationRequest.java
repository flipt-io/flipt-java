package com.flipt.api.client.evaluate.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = EvaluationRequest.Builder.class
)
public final class EvaluationRequest {
  private final Optional<String> requestId;

  private final String flagKey;

  private final String entityId;

  private final String context;

  private int _cachedHashCode;

  EvaluationRequest(Optional<String> requestId, String flagKey, String entityId, String context) {
    this.requestId = requestId;
    this.flagKey = flagKey;
    this.entityId = entityId;
    this.context = context;
  }

  @JsonProperty("requestId")
  public Optional<String> getRequestId() {
    return requestId;
  }

  @JsonProperty("flagKey")
  public String getFlagKey() {
    return flagKey;
  }

  @JsonProperty("entityId")
  public String getEntityId() {
    return entityId;
  }

  @JsonProperty("context")
  public String getContext() {
    return context;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EvaluationRequest && equalTo((EvaluationRequest) other);
  }

  private boolean equalTo(EvaluationRequest other) {
    return requestId.equals(other.requestId) && flagKey.equals(other.flagKey) && entityId.equals(other.entityId) && context.equals(other.context);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.requestId, this.flagKey, this.entityId, this.context);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EvaluationRequest{" + "requestId: " + requestId + ", flagKey: " + flagKey + ", entityId: " + entityId + ", context: " + context + "}";
  }

  public static FlagKeyStage builder() {
    return new Builder();
  }

  public interface FlagKeyStage {
    EntityIdStage flagKey(String flagKey);

    Builder from(EvaluationRequest other);
  }

  public interface EntityIdStage {
    ContextStage entityId(String entityId);
  }

  public interface ContextStage {
    _FinalStage context(String context);
  }

  public interface _FinalStage {
    EvaluationRequest build();

    _FinalStage requestId(Optional<String> requestId);

    _FinalStage requestId(String requestId);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements FlagKeyStage, EntityIdStage, ContextStage, _FinalStage {
    private String flagKey;

    private String entityId;

    private String context;

    private Optional<String> requestId = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(EvaluationRequest other) {
      requestId(other.getRequestId());
      flagKey(other.getFlagKey());
      entityId(other.getEntityId());
      context(other.getContext());
      return this;
    }

    @Override
    @JsonSetter("flagKey")
    public EntityIdStage flagKey(String flagKey) {
      this.flagKey = flagKey;
      return this;
    }

    @Override
    @JsonSetter("entityId")
    public ContextStage entityId(String entityId) {
      this.entityId = entityId;
      return this;
    }

    @Override
    @JsonSetter("context")
    public _FinalStage context(String context) {
      this.context = context;
      return this;
    }

    @Override
    public _FinalStage requestId(String requestId) {
      this.requestId = Optional.of(requestId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "requestId",
        nulls = Nulls.SKIP
    )
    public _FinalStage requestId(Optional<String> requestId) {
      this.requestId = requestId;
      return this;
    }

    @Override
    public EvaluationRequest build() {
      return new EvaluationRequest(requestId, flagKey, entityId, context);
    }
  }
}
