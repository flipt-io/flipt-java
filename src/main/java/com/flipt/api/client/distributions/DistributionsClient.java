package com.flipt.api.client.distributions;

import com.flipt.api.client.distributions.endpoints.Create;
import com.flipt.api.client.distributions.endpoints.Delete;
import com.flipt.api.client.distributions.endpoints.Update;
import com.flipt.api.client.distributions.exceptions.CreateException;
import com.flipt.api.client.distributions.exceptions.DeleteException;
import com.flipt.api.client.distributions.exceptions.UpdateException;
import com.flipt.api.client.distributions.types.Distribution;
import com.flipt.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class DistributionsClient {
  private final Distributions service;

  private final Optional<BearerAuth> auth;

  public DistributionsClient(String url) {
    this.service = Distributions.getClient(url);
    this.auth = Optional.empty();
  }

  public DistributionsClient(String url, BearerAuth auth) {
    this.service = Distributions.getClient(url);
    this.auth = Optional.of(auth);
  }

  public Distribution create(Create.Request request) throws CreateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.create(authValue, request.getBody());
  }

  public void delete(Delete.Request request) throws DeleteException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.delete(authValue, request.getId(), request.getVariantId());
  }

  public Distribution update(Update.Request request) throws UpdateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.update(authValue, request.getId(), request.getBody());
  }
}
