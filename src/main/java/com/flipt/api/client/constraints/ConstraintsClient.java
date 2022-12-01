package com.flipt.api.client.constraints;

import com.flipt.api.client.constraints.endpoints.Create;
import com.flipt.api.client.constraints.endpoints.Delete;
import com.flipt.api.client.constraints.endpoints.Update;
import com.flipt.api.client.constraints.exceptions.CreateException;
import com.flipt.api.client.constraints.exceptions.DeleteException;
import com.flipt.api.client.constraints.exceptions.UpdateException;
import com.flipt.api.client.constraints.types.Constraint;
import com.flipt.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class ConstraintsClient {
  private final Constraints service;

  private final Optional<BearerAuth> auth;

  public ConstraintsClient(String url) {
    this.service = Constraints.getClient(url);
    this.auth = Optional.empty();
  }

  public ConstraintsClient(String url, BearerAuth auth) {
    this.service = Constraints.getClient(url);
    this.auth = Optional.of(auth);
  }

  public Constraint create(Create.Request request) throws CreateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.create(authValue, request.getBody());
  }

  public void delete(Delete.Request request) throws DeleteException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.delete(authValue, request.getId());
  }

  public void update(Update.Request request) throws UpdateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.update(authValue, request.getId(), request.getBody());
  }
}
