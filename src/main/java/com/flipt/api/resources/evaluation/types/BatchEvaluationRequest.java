package com.flipt.api.resources.evaluation.types;

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
import java.util.Optional;

@JsonDeserialize(
    builder = BatchEvaluationRequest.Builder.class
)
public final class BatchEvaluationRequest {
  private final Optional<String> requestId;

  private final List<EvaluationRequest> requests;

  private int _cachedHashCode;

  BatchEvaluationRequest(Optional<String> requestId, List<EvaluationRequest> requests) {
    this.requestId = requestId;
    this.requests = requests;
  }

  @JsonProperty("requestId")
  public Optional<String> getRequestId() {
    return requestId;
  }

  @JsonProperty("requests")
  public List<EvaluationRequest> getRequests() {
    return requests;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BatchEvaluationRequest && equalTo((BatchEvaluationRequest) other);
  }

  private boolean equalTo(BatchEvaluationRequest other) {
    return requestId.equals(other.requestId) && requests.equals(other.requests);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.requestId, this.requests);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BatchEvaluationRequest{" + "requestId: " + requestId + ", requests: " + requests + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> requestId = Optional.empty();

    private List<EvaluationRequest> requests = new ArrayList<>();

    private Builder() {
    }

    public Builder from(BatchEvaluationRequest other) {
      requestId(other.getRequestId());
      requests(other.getRequests());
      return this;
    }

    @JsonSetter(
        value = "requestId",
        nulls = Nulls.SKIP
    )
    public Builder requestId(Optional<String> requestId) {
      this.requestId = requestId;
      return this;
    }

    public Builder requestId(String requestId) {
      this.requestId = Optional.of(requestId);
      return this;
    }

    @JsonSetter(
        value = "requests",
        nulls = Nulls.SKIP
    )
    public Builder requests(List<EvaluationRequest> requests) {
      this.requests.clear();
      this.requests.addAll(requests);
      return this;
    }

    public Builder addRequests(EvaluationRequest requests) {
      this.requests.add(requests);
      return this;
    }

    public Builder addAllRequests(List<EvaluationRequest> requests) {
      this.requests.addAll(requests);
      return this;
    }

    public BatchEvaluationRequest build() {
      return new BatchEvaluationRequest(requestId, requests);
    }
  }
}
