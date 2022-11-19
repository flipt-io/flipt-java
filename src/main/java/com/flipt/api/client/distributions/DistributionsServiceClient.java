package com.flipt.api.client.distributions;

import com.flipt.api.client.distributions.endpoints.Create;
import com.flipt.api.client.distributions.endpoints.Delete;
import com.flipt.api.client.distributions.endpoints.Update;
import com.flipt.api.client.distributions.exceptions.CreateException;
import com.flipt.api.client.distributions.exceptions.DeleteException;
import com.flipt.api.client.distributions.exceptions.UpdateException;
import com.flipt.api.client.distributions.types.Distribution;
import com.flipt.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class DistributionsServiceClient {
  private final DistributionsService service;

  private final Optional<BasicAuth> auth;

  public DistributionsServiceClient(String url) {
    this.service = DistributionsService.getClient(url);
    this.auth = Optional.empty();
  }

  public DistributionsServiceClient(String url, BasicAuth auth) {
    this.service = DistributionsService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public Distribution create(Create.Request request) throws CreateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for create")));
    return this.service.create(authValue, request.getBody());
  }

  public void delete(Delete.Request request) throws DeleteException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for delete")));
    this.service.delete(authValue, request.getId(), request.getVariantId());
  }

  public Distribution update(Update.Request request) throws UpdateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for update")));
    return this.service.update(authValue, request.getId(), request.getBody());
  }
}
