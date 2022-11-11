package com.flipt.api.client.variants;

import com.flipt.api.client.variants.endpoints.Create;
import com.flipt.api.client.variants.endpoints.Delete;
import com.flipt.api.client.variants.endpoints.Update;
import com.flipt.api.client.variants.exceptions.CreateException;
import com.flipt.api.client.variants.exceptions.DeleteException;
import com.flipt.api.client.variants.exceptions.UpdateException;
import com.flipt.api.client.variants.types.FliptVariant;
import com.flipt.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class VariantsServiceClient {
  private final VariantsService service;

  private final Optional<BasicAuth> auth;

  public VariantsServiceClient(String url) {
    this.service = VariantsService.getClient(url);
    this.auth = Optional.empty();
  }

  public VariantsServiceClient(String url, BasicAuth auth) {
    this.service = VariantsService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public FliptVariant create(Create.Request request) throws CreateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for create")));
    return this.service.create(authValue, request.getBody());
  }

  public void delete(Delete.Request request) throws DeleteException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for delete")));
    this.service.delete(authValue, request.getId());
  }

  public FliptVariant update(Update.Request request) throws UpdateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for update")));
    return this.service.update(authValue, request.getId(), request.getBody());
  }
}
