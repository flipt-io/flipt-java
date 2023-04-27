package com.flipt.api.resources.evaluate.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = BatchEvaluationResponse.Builder.class
)
public final class BatchEvaluationResponse {
  private final String requestId;

  private final List<EvaluationResponse> responses;

  private final double requestDurationMillis;

  private int _cachedHashCode;

  BatchEvaluationResponse(String requestId, List<EvaluationResponse> responses,
      double requestDurationMillis) {
    this.requestId = requestId;
    this.responses = responses;
    this.requestDurationMillis = requestDurationMillis;
  }

  @JsonProperty("requestId")
  public String getRequestId() {
    return requestId;
  }

  @JsonProperty("responses")
  public List<EvaluationResponse> getResponses() {
    return responses;
  }

  @JsonProperty("requestDurationMillis")
  public double getRequestDurationMillis() {
    return requestDurationMillis;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BatchEvaluationResponse && equalTo((BatchEvaluationResponse) other);
  }

  private boolean equalTo(BatchEvaluationResponse other) {
    return requestId.equals(other.requestId) && responses.equals(other.responses) && requestDurationMillis == other.requestDurationMillis;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.requestId, this.responses, this.requestDurationMillis);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BatchEvaluationResponse{" + "requestId: " + requestId + ", responses: " + responses + ", requestDurationMillis: " + requestDurationMillis + "}";
  }

  public static RequestIdStage builder() {
    return new Builder();
  }

  public interface RequestIdStage {
    RequestDurationMillisStage requestId(String requestId);

    Builder from(BatchEvaluationResponse other);
  }

  public interface RequestDurationMillisStage {
    _FinalStage requestDurationMillis(double requestDurationMillis);
  }

  public interface _FinalStage {
    BatchEvaluationResponse build();

    _FinalStage responses(List<EvaluationResponse> responses);

    _FinalStage addResponses(EvaluationResponse responses);

    _FinalStage addAllResponses(List<EvaluationResponse> responses);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements RequestIdStage, RequestDurationMillisStage, _FinalStage {
    private String requestId;

    private double requestDurationMillis;

    private List<EvaluationResponse> responses = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(BatchEvaluationResponse other) {
      requestId(other.getRequestId());
      responses(other.getResponses());
      requestDurationMillis(other.getRequestDurationMillis());
      return this;
    }

    @Override
    @JsonSetter("requestId")
    public RequestDurationMillisStage requestId(String requestId) {
      this.requestId = requestId;
      return this;
    }

    @Override
    @JsonSetter("requestDurationMillis")
    public _FinalStage requestDurationMillis(double requestDurationMillis) {
      this.requestDurationMillis = requestDurationMillis;
      return this;
    }

    @Override
    public _FinalStage addAllResponses(List<EvaluationResponse> responses) {
      this.responses.addAll(responses);
      return this;
    }

    @Override
    public _FinalStage addResponses(EvaluationResponse responses) {
      this.responses.add(responses);
      return this;
    }

    @Override
    @JsonSetter(
        value = "responses",
        nulls = Nulls.SKIP
    )
    public _FinalStage responses(List<EvaluationResponse> responses) {
      this.responses.clear();
      this.responses.addAll(responses);
      return this;
    }

    @Override
    public BatchEvaluationResponse build() {
      return new BatchEvaluationResponse(requestId, responses, requestDurationMillis);
    }
  }
}
