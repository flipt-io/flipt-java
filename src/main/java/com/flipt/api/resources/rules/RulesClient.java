package com.flipt.api.resources.rules;

import com.flipt.api.resources.rules.requests.RuleListRequest;
import com.flipt.api.resources.rules.types.Rule;
import com.flipt.api.resources.rules.types.RuleCreateRequest;
import com.flipt.api.resources.rules.types.RuleList;
import com.flipt.api.resources.rules.types.RuleOrderRequest;
import com.flipt.api.resources.rules.types.RuleUpdateRequest;
import java.lang.String;

public interface RulesClient {
  RuleList list(String namespaceKey, String flagKey, RuleListRequest request);

  Rule create(String namespaceKey, String flagKey, RuleCreateRequest request);

  void order(String namespaceKey, String flagKey, RuleOrderRequest request);

  Rule get(String namespaceKey, String flagKey, String id);

  void delete(String namespaceKey, String flagKey, String id);

  void update(String namespaceKey, String flagKey, String id, RuleUpdateRequest request);
}
