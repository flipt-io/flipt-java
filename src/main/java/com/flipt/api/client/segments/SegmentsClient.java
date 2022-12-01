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
import com.flipt.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class SegmentsClient {
  private final Segments service;

  private final Optional<BearerAuth> auth;

  public SegmentsClient(String url) {
    this.service = Segments.getClient(url);
    this.auth = Optional.empty();
  }

  public SegmentsClient(String url, BearerAuth auth) {
    this.service = Segments.getClient(url);
    this.auth = Optional.of(auth);
  }

  public SegmentList list(List.Request request) throws ListException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.list(authValue, request.getLimit(), request.getOffset(), request.getPageToken());
  }

  public Segment create(Create.Request request) throws CreateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.create(authValue, request.getBody());
  }

  public Segment get(Get.Request request) throws GetException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.get(authValue, request.getKey());
  }

  public void delete(Delete.Request request) throws DeleteException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.delete(authValue, request.getKey());
  }

  public Segment update(Update.Request request) throws UpdateException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.update(authValue, request.getKey(), request.getBody());
  }
}
