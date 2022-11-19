package com.flipt.api.client.evaluate;

import com.flipt.api.client.evaluate.endpoints.BatchEvaluate;
import com.flipt.api.client.evaluate.endpoints.Evaluate;
import com.flipt.api.client.evaluate.exceptions.BatchEvaluateException;
import com.flipt.api.client.evaluate.exceptions.EvaluateException;
import com.flipt.api.client.evaluate.types.BatchEvaluationResponse;
import com.flipt.api.client.evaluate.types.EvaluationResponse;
import com.flipt.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class EvaluateServiceClient {
  private final EvaluateService service;

  private final Optional<BasicAuth> auth;

  public EvaluateServiceClient(String url) {
    this.service = EvaluateService.getClient(url);
    this.auth = Optional.empty();
  }

  public EvaluateServiceClient(String url, BasicAuth auth) {
    this.service = EvaluateService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public EvaluationResponse evaluate(Evaluate.Request request) throws EvaluateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for evaluate")));
    return this.service.evaluate(authValue, request.getBody());
  }

  public BatchEvaluationResponse batchEvaluate(BatchEvaluate.Request request) throws
      BatchEvaluateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for batchEvaluate")));
    return this.service.batchEvaluate(authValue, request.getBody());
  }
}
