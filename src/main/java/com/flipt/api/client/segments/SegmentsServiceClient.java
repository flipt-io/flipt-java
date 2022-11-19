package com.flipt.api.client.segments;

import com.flipt.api.client.segments.endpoints.Create;
import com.flipt.api.client.segments.endpoints.Delete;
import com.flipt.api.client.segments.endpoints.Get;
import com.flipt.api.client.segments.endpoints.List;
import com.flipt.api.client.segments.endpoints.Update;
import com.flipt.api.client.segments.exceptions.CreateException;
import com.flipt.api.client.segments.exceptions.DeleteException;
import com.flipt.api.client.segments.exceptions.GetException;
import com.flipt.api.client.segments.exceptions.ListException;
import com.flipt.api.client.segments.exceptions.UpdateException;
import com.flipt.api.client.segments.types.Segment;
import com.flipt.api.client.segments.types.SegmentList;
import com.flipt.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class SegmentsServiceClient {
  private final SegmentsService service;

  private final Optional<BasicAuth> auth;

  public SegmentsServiceClient(String url) {
    this.service = SegmentsService.getClient(url);
    this.auth = Optional.empty();
  }

  public SegmentsServiceClient(String url, BasicAuth auth) {
    this.service = SegmentsService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public SegmentList list(List.Request request) throws ListException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for list")));
    return this.service.list(authValue, request.getLimit(), request.getOffset(), request.getPageToken());
  }

  public Segment create(Create.Request request) throws CreateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for create")));
    return this.service.create(authValue, request.getBody());
  }

  public Segment get(Get.Request request) throws GetException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for get")));
    return this.service.get(authValue, request.getKey());
  }

  public void delete(Delete.Request request) throws DeleteException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for delete")));
    this.service.delete(authValue, request.getKey());
  }

  public Segment update(Update.Request request) throws UpdateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for update")));
    return this.service.update(authValue, request.getKey(), request.getBody());
  }
}
