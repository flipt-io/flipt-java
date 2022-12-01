package com.flipt.api.client.flags;

import com.flipt.api.client.flags.endpoints.Create;
import com.flipt.api.client.flags.endpoints.Delete;
import com.flipt.api.client.flags.endpoints.Get;
import com.flipt.api.client.flags.endpoints.List;
import com.flipt.api.client.flags.endpoints.Update;
import com.flipt.api.client.flags.exceptions.CreateException;
import com.flipt.api.client.flags.exceptions.DeleteException;
import com.flipt.api.client.flags.exceptions.GetException;
import com.flipt.api.client.flags.exceptions.ListException;
import com.flipt.api.client.flags.exceptions.UpdateException;
import com.flipt.api.client.flags.types.Flag;
import com.flipt.api.client.flags.types.FlagList;
import com.flipt.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class FlagsClient {
  private final Flags service;

  private final Optional<BearerAuth> auth;

  public FlagsClient(String url) {
    this.service = Flags.getClient(url);
    this.auth = Optional.empty();
  }

  public FlagsClient(String url, BearerAuth auth) {
    this.service = Flags.getClient(url);
    this.auth = Optional.of(auth);
  }

  public FlagList list(List.Request request) throws ListException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.list(authValue, request.getLimit(), request.getOffset(), request.getPageToken());
  }

  public Flag create(Create.Request request) throws CreateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.create(authValue, request.getBody());
  }

  public Flag get(Get.Request request) throws GetException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.get(authValue, request.getKey());
  }

  public void delete(Delete.Request request) throws DeleteException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.delete(authValue, request.getKey());
  }

  public Flag update(Update.Request request) throws UpdateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.update(authValue, request.getKey(), request.getBody());
  }
}
