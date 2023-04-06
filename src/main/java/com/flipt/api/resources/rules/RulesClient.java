package com.flipt.api.resources.rules;

import com.flipt.api.resources.rules.requests.RuleCreateRequest;
import com.flipt.api.resources.rules.requests.RuleListRequest;
import com.flipt.api.resources.rules.requests.RuleOrder;
import com.flipt.api.resources.rules.requests.RuleUpdateRequest;
import com.flipt.api.resources.rules.types.Rule;
import com.flipt.api.resources.rules.types.RuleList;
import java.lang.String;

public interface RulesClient {
  RuleList list(String flagKey, RuleListRequest request);

  Rule create(String flagKey, RuleCreateRequest request);

  void order(String flagKey, RuleOrder request);

  Rule get(String flagKey, String id);

  void delete(String flagKey, String id);

  void update(String flagKey, String id, RuleUpdateRequest request);
}
