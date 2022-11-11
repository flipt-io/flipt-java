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
import com.flipt.api.client.flags.types.FliptFlag;
import com.flipt.api.client.flags.types.FliptFlagList;
import com.flipt.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class FlagsServiceClient {
  private final FlagsService service;

  private final Optional<BasicAuth> auth;

  public FlagsServiceClient(String url) {
    this.service = FlagsService.getClient(url);
    this.auth = Optional.empty();
  }

  public FlagsServiceClient(String url, BasicAuth auth) {
    this.service = FlagsService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public FliptFlagList list(List.Request request) throws ListException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for list")));
    return this.service.list(authValue, request.getLimit(), request.getOffset(), request.getPageToken());
  }

  public FliptFlag create(Create.Request request) throws CreateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for create")));
    return this.service.create(authValue, request.getBody());
  }

  public FliptFlag get(Get.Request request) throws GetException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for get")));
    return this.service.get(authValue, request.getKey());
  }

  public void delete(Delete.Request request) throws DeleteException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for delete")));
    this.service.delete(authValue, request.getKey());
  }

  public FliptFlag update(Update.Request request) throws UpdateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for update")));
    return this.service.update(authValue, request.getKey(), request.getBody());
  }
}
