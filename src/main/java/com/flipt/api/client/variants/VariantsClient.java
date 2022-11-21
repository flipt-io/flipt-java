package com.flipt.api.client.variants;

import com.flipt.api.client.variants.endpoints.Create;
import com.flipt.api.client.variants.endpoints.Delete;
import com.flipt.api.client.variants.endpoints.Update;
import com.flipt.api.client.variants.exceptions.CreateException;
import com.flipt.api.client.variants.exceptions.DeleteException;
import com.flipt.api.client.variants.exceptions.UpdateException;
import com.flipt.api.client.variants.types.Variant;
import com.flipt.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class VariantsClient {
  private final Variants service;

  private final Optional<BearerAuth> auth;

  public VariantsClient(String url) {
    this.service = Variants.getClient(url);
    this.auth = Optional.empty();
  }

  public VariantsClient(String url, BearerAuth auth) {
    this.service = Variants.getClient(url);
    this.auth = Optional.of(auth);
  }

  public Variant create(Create.Request request) throws CreateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for create")));
    return this.service.create(authValue, request.getBody());
  }

  public void delete(Delete.Request request) throws DeleteException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for delete")));
    this.service.delete(authValue, request.getId());
  }

  public Variant update(Update.Request request) throws UpdateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for update")));
    return this.service.update(authValue, request.getId(), request.getBody());
  }
}
