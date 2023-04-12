package com.flipt.api.resources.distributions;

import com.flipt.api.resources.distributions.requests.DistributionDeleteRequest;
import com.flipt.api.resources.distributions.types.Distribution;
import com.flipt.api.resources.distributions.types.DistributionCreateRequest;
import com.flipt.api.resources.distributions.types.DistributionUpdateRequest;
import java.lang.String;

public interface DistributionsClient {
  Distribution create(String namespaceKey, String flagKey, String ruleId,
      DistributionCreateRequest request);

  void delete(String namespaceKey, String flagKey, String ruleId, String id,
      DistributionDeleteRequest request);

  Distribution update(String namespaceKey, String flagKey, String ruleId, String id,
      DistributionUpdateRequest request);
}
