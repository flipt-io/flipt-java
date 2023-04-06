package com.flipt.api.resources.constraints;

import com.flipt.api.resources.constraints.requests.ConstraintCreateRequest;
import com.flipt.api.resources.constraints.requests.ConstraintUpdateRequest;
import com.flipt.api.resources.constraints.types.Constraint;
import java.lang.String;

public interface ConstraintsClient {
  Constraint create(String segmentKey, ConstraintCreateRequest request);

  void delete(String segmentKey, String id);

  void update(String segmentKey, String id, ConstraintUpdateRequest request);
}
