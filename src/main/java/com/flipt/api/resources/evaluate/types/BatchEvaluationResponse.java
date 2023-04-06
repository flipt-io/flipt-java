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

  private final List<EvaluationResponse> response;

  private final double requestDurationMillis;

  private int _cachedHashCode;

  BatchEvaluationResponse(String requestId, List<EvaluationResponse> response,
      double requestDurationMillis) {
    this.requestId = requestId;
    this.response = response;
    this.requestDurationMillis = requestDurationMillis;
  }

  @JsonProperty("requestId")
  public String getRequestId() {
    return requestId;
  }

  @JsonProperty("response")
  public List<EvaluationResponse> getResponse() {
    return response;
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
    return requestId.equals(other.requestId) && response.equals(other.response) && requestDurationMillis == other.requestDurationMillis;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.requestId, this.response, this.requestDurationMillis);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BatchEvaluationResponse{" + "requestId: " + requestId + ", response: " + response + ", requestDurationMillis: " + requestDurationMillis + "}";
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

    _FinalStage response(List<EvaluationResponse> response);

    _FinalStage addResponse(EvaluationResponse response);

    _FinalStage addAllResponse(List<EvaluationResponse> response);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements RequestIdStage, RequestDurationMillisStage, _FinalStage {
    private String requestId;

    private double requestDurationMillis;

    private List<EvaluationResponse> response = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(BatchEvaluationResponse other) {
      requestId(other.getRequestId());
      response(other.getResponse());
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
    public _FinalStage addAllResponse(List<EvaluationResponse> response) {
      this.response.addAll(response);
      return this;
    }

    @Override
    public _FinalStage addResponse(EvaluationResponse response) {
      this.response.add(response);
      return this;
    }

    @Override
    @JsonSetter(
        value = "response",
        nulls = Nulls.SKIP
    )
    public _FinalStage response(List<EvaluationResponse> response) {
      this.response.clear();
      this.response.addAll(response);
      return this;
    }

    @Override
    public BatchEvaluationResponse build() {
      return new BatchEvaluationResponse(requestId, response, requestDurationMillis);
    }
  }
}
