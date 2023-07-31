package com.flipt.api.resources.rollouts;

import com.flipt.api.resources.rollouts.requests.RolloutListRequest;
import com.flipt.api.resources.rollouts.types.Rollout;
import com.flipt.api.resources.rollouts.types.RolloutCreateRequest;
import com.flipt.api.resources.rollouts.types.RolloutList;
import com.flipt.api.resources.rollouts.types.RolloutOrderRequest;
import com.flipt.api.resources.rollouts.types.RolloutUpdateRequest;
import java.lang.String;

public interface RolloutsClient {
  RolloutList list(String namespaceKey, String flagKey, RolloutListRequest request);

  Rollout create(String namespaceKey, String flagKey, RolloutCreateRequest request);

  void order(String namespaceKey, String flagKey, RolloutOrderRequest request);

  Rollout get(String namespaceKey, String flagKey, String id);

  void delete(String namespaceKey, String flagKey, String id);

  void update(String namespaceKey, String flagKey, String id, RolloutUpdateRequest request);
}
