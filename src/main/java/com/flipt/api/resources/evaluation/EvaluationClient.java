package com.flipt.api.resources.evaluation;

import com.flipt.api.resources.evaluation.types.BatchEvaluationRequest;
import com.flipt.api.resources.evaluation.types.BatchEvaluationResponse;
import com.flipt.api.resources.evaluation.types.BooleanEvaluationResponse;
import com.flipt.api.resources.evaluation.types.EvaluationRequest;
import com.flipt.api.resources.evaluation.types.VariantEvaluationResponse;

public interface EvaluationClient {
  BooleanEvaluationResponse boolean_(EvaluationRequest request);

  VariantEvaluationResponse variant(EvaluationRequest request);

  BatchEvaluationResponse batch(BatchEvaluationRequest request);
}
