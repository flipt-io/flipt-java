package com.flipt.api.resources.distributions;

import com.flipt.api.resources.distributions.requests.DistributionCreateRequest;
import com.flipt.api.resources.distributions.requests.DistributionDeleteRequest;
import com.flipt.api.resources.distributions.requests.DistributionUpdateRequest;
import com.flipt.api.resources.distributions.types.Distribution;
import java.lang.String;

public interface DistributionsClient {
  Distribution create(String flagKey, String ruleId, DistributionCreateRequest request);

  void delete(String flagKey, String ruleId, String id, DistributionDeleteRequest request);

  Distribution update(String flagKey, String ruleId, String id, DistributionUpdateRequest request);
}
