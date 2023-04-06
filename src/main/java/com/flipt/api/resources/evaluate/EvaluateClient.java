package com.flipt.api.resources.evaluate;

import com.flipt.api.resources.evaluate.requests.BatchEvaluationRequest;
import com.flipt.api.resources.evaluate.types.BatchEvaluationResponse;
import com.flipt.api.resources.evaluate.types.EvaluationRequest;
import com.flipt.api.resources.evaluate.types.EvaluationResponse;

public interface EvaluateClient {
  EvaluationResponse evaluate(EvaluationRequest request);

  BatchEvaluationResponse batchEvaluate(BatchEvaluationRequest request);
}
