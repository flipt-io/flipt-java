package com.flipt.api.client.evaluate;

import com.flipt.api.client.evaluate.endpoints.BatchEvaluate;
import com.flipt.api.client.evaluate.endpoints.Evaluate;
import com.flipt.api.client.evaluate.exceptions.BatchEvaluateException;
import com.flipt.api.client.evaluate.exceptions.EvaluateException;
import com.flipt.api.client.evaluate.types.BatchEvaluationResponse;
import com.flipt.api.client.evaluate.types.EvaluationResponse;
import com.flipt.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class EvaluationClient {
  private final Evaluation service;

  private final Optional<BearerAuth> auth;

  public EvaluationClient(String url) {
    this.service = Evaluation.getClient(url);
    this.auth = Optional.empty();
  }

  public EvaluationClient(String url, BearerAuth auth) {
    this.service = Evaluation.getClient(url);
    this.auth = Optional.of(auth);
  }

  public EvaluationResponse evaluate(Evaluate.Request request) throws EvaluateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.evaluate(authValue, request.getBody());
  }

  public BatchEvaluationResponse batchEvaluate(BatchEvaluate.Request request) throws
      BatchEvaluateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.batchEvaluate(authValue, request.getBody());
  }
}
