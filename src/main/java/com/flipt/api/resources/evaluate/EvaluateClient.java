package com.flipt.api.resources.evaluate;

import com.flipt.api.resources.evaluate.types.BatchEvaluationRequest;
import com.flipt.api.resources.evaluate.types.BatchEvaluationResponse;
import com.flipt.api.resources.evaluate.types.EvaluationRequest;
import com.flipt.api.resources.evaluate.types.EvaluationResponse;
import java.lang.String;

public interface EvaluateClient {
  EvaluationResponse evaluate(String namespaceKey, EvaluationRequest request);

  BatchEvaluationResponse batchEvaluate(String namespaceKey, BatchEvaluationRequest request);
}
