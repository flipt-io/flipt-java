package com.flipt.api.resources.evaluate.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
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

  private final Optional<Boolean> excludeNotFound;

  private int _cachedHashCode;

  BatchEvaluationRequest(Optional<String> requestId, List<EvaluationRequest> requests,
      Optional<Boolean> excludeNotFound) {
    this.requestId = requestId;
    this.requests = requests;
    this.excludeNotFound = excludeNotFound;
  }

  @JsonProperty("requestId")
  public Optional<String> getRequestId() {
    return requestId;
  }

  @JsonProperty("requests")
  public List<EvaluationRequest> getRequests() {
    return requests;
  }

  @JsonProperty("excludeNotFound")
  public Optional<Boolean> getExcludeNotFound() {
    return excludeNotFound;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BatchEvaluationRequest && equalTo((BatchEvaluationRequest) other);
  }

  private boolean equalTo(BatchEvaluationRequest other) {
    return requestId.equals(other.requestId) && requests.equals(other.requests) && excludeNotFound.equals(other.excludeNotFound);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.requestId, this.requests, this.excludeNotFound);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BatchEvaluationRequest{" + "requestId: " + requestId + ", requests: " + requests + ", excludeNotFound: " + excludeNotFound + "}";
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

    private Optional<Boolean> excludeNotFound = Optional.empty();

    private Builder() {
    }

    public Builder from(BatchEvaluationRequest other) {
      requestId(other.getRequestId());
      requests(other.getRequests());
      excludeNotFound(other.getExcludeNotFound());
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

    @JsonSetter(
        value = "excludeNotFound",
        nulls = Nulls.SKIP
    )
    public Builder excludeNotFound(Optional<Boolean> excludeNotFound) {
      this.excludeNotFound = excludeNotFound;
      return this;
    }

    public Builder excludeNotFound(Boolean excludeNotFound) {
      this.excludeNotFound = Optional.of(excludeNotFound);
      return this;
    }

    public BatchEvaluationRequest build() {
      return new BatchEvaluationRequest(requestId, requests, excludeNotFound);
    }
  }
}
