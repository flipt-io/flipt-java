package com.flipt.api.resources.constraints;

import com.flipt.api.resources.constraints.types.Constraint;
import com.flipt.api.resources.constraints.types.ConstraintCreateRequest;
import com.flipt.api.resources.constraints.types.ConstraintUpdateRequest;
import java.lang.String;

public interface ConstraintsClient {
  Constraint create(String namespaceKey, String segmentKey, ConstraintCreateRequest request);

  void delete(String namespaceKey, String segmentKey, String id);

  void update(String namespaceKey, String segmentKey, String id, ConstraintUpdateRequest request);
}
