package com.flipt.api.client.constraints;

import com.flipt.api.client.constraints.endpoints.Create;
import com.flipt.api.client.constraints.endpoints.Delete;
import com.flipt.api.client.constraints.endpoints.Update;
import com.flipt.api.client.constraints.exceptions.CreateException;
import com.flipt.api.client.constraints.exceptions.DeleteException;
import com.flipt.api.client.constraints.exceptions.UpdateException;
import com.flipt.api.client.constraints.types.FliptConstraint;
import com.flipt.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class ConstraintsServiceClient {
  private final ConstraintsService service;

  private final Optional<BasicAuth> auth;

  public ConstraintsServiceClient(String url) {
    this.service = ConstraintsService.getClient(url);
    this.auth = Optional.empty();
  }

  public ConstraintsServiceClient(String url, BasicAuth auth) {
    this.service = ConstraintsService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public FliptConstraint create(Create.Request request) throws CreateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for create")));
    return this.service.create(authValue, request.getBody());
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
