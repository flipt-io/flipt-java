package com.flipt.api.client.rules;

import com.flipt.api.client.rules.endpoints.Create;
import com.flipt.api.client.rules.endpoints.Delete;
import com.flipt.api.client.rules.endpoints.Get;
import com.flipt.api.client.rules.endpoints.List;
import com.flipt.api.client.rules.endpoints.Order;
import com.flipt.api.client.rules.endpoints.Update;
import com.flipt.api.client.rules.exceptions.CreateException;
import com.flipt.api.client.rules.exceptions.DeleteException;
import com.flipt.api.client.rules.exceptions.GetException;
import com.flipt.api.client.rules.exceptions.ListException;
import com.flipt.api.client.rules.exceptions.OrderException;
import com.flipt.api.client.rules.exceptions.UpdateException;
import com.flipt.api.client.rules.types.FliptRule;
import com.flipt.api.client.rules.types.FliptRuleList;
import com.flipt.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class RulesServiceClient {
  private final RulesService service;

  private final Optional<BasicAuth> auth;

  public RulesServiceClient(String url) {
    this.service = RulesService.getClient(url);
    this.auth = Optional.empty();
  }

  public RulesServiceClient(String url, BasicAuth auth) {
    this.service = RulesService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public FliptRuleList list(List.Request request) throws ListException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for list")));
    return this.service.list(authValue, request.getLimit(), request.getOffset(), request.getPageToken());
  }

  public FliptRule create(Create.Request request) throws CreateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for create")));
    return this.service.create(authValue, request.getBody());
  }

  public void order(Order.Request request) throws OrderException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for order")));
    this.service.order(authValue, request.getBody());
  }

  public FliptRule get(Get.Request request) throws GetException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for get")));
    return this.service.get(authValue, request.getId());
  }

  public void delete(Delete.Request request) throws DeleteException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for delete")));
    this.service.delete(authValue, request.getId());
  }

  public void update(Update.Request request) throws UpdateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for update")));
    this.service.update(authValue, request.getId(), request.getBody());
  }
}
