package com.flipt.api.resources.rollouts;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.resources.rollouts.requests.RolloutListRequest;
import com.flipt.api.resources.rollouts.types.Rollout;
import com.flipt.api.resources.rollouts.types.RolloutCreateRequest;
import com.flipt.api.resources.rollouts.types.RolloutList;
import com.flipt.api.resources.rollouts.types.RolloutOrderRequest;
import com.flipt.api.resources.rollouts.types.RolloutUpdateRequest;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class RolloutsClientImpl implements RolloutsClient {
  private final ClientOptions clientOptions;

  public RolloutsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public RolloutList list(String namespaceKey, String flagKey, RolloutListRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("api/v1/namespaces/")
      .addPathSegment(namespaceKey)
      .addPathSegments("flags/")
      .addPathSegment(flagKey)
      .addPathSegments("rollouts")
      ;if (request.getLimit().isPresent()) {
        _httpUrlBuilder.addQueryParameter("limit", request.getLimit().get().toString());
      }
      if (request.getOffset().isPresent()) {
        _httpUrlBuilder.addQueryParameter("offset", request.getOffset().get().toString());
      }
      if (request.getPageToken().isPresent()) {
        _httpUrlBuilder.addQueryParameter("pageToken", request.getPageToken().get());
      }
      HttpUrl _httpUrl = _httpUrlBuilder.build()
          ;
      RequestBody _requestBody = null;
      Request.Builder _requestBuilder = new Request.Builder()
        .url(_httpUrl)
        .method("GET", _requestBody)
        .headers(Headers.of(clientOptions.headers()))
        .addHeader("Content-Type", "application/json");
      Request _request = _requestBuilder.build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), RolloutList.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public Rollout create(String namespaceKey, String flagKey, RolloutCreateRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/namespaces/")
        .addPathSegment(namespaceKey)
        .addPathSegments("flags/")
        .addPathSegment(flagKey)
        .addPathSegments("rollouts")
        .build();
      RequestBody _requestBody;
      try {
        _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
      }
      catch(Exception e) {
        throw new RuntimeException(e);
      }
      Request _request = new Request.Builder()
        .url(_httpUrl)
        .method("POST", _requestBody)
        .headers(Headers.of(clientOptions.headers()))
        .addHeader("Content-Type", "application/json")
        .build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Rollout.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void order(String namespaceKey, String flagKey, RolloutOrderRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/namespaces/")
        .addPathSegment(namespaceKey)
        .addPathSegments("flags/")
        .addPathSegment(flagKey)
        .addPathSegments("rollouts")
        .build();
      RequestBody _requestBody;
      try {
        _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
      }
      catch(Exception e) {
        throw new RuntimeException(e);
      }
      Request _request = new Request.Builder()
        .url(_httpUrl)
        .method("PUT", _requestBody)
        .headers(Headers.of(clientOptions.headers()))
        .addHeader("Content-Type", "application/json")
        .build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return;
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public Rollout get(String namespaceKey, String flagKey, String id) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/namespaces/")
        .addPathSegment(namespaceKey)
        .addPathSegments("flags/")
        .addPathSegment(flagKey)
        .addPathSegments("rollouts")
        .addPathSegment(id)
        .build();Request _request = new Request.Builder()
        .url(_httpUrl)
        .method("GET", null)
        .headers(Headers.of(clientOptions.headers()))
        .addHeader("Content-Type", "application/json")
        .build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Rollout.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void delete(String namespaceKey, String flagKey, String id) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/namespaces/")
        .addPathSegment(namespaceKey)
        .addPathSegments("flags/")
        .addPathSegment(flagKey)
        .addPathSegments("rollouts")
        .addPathSegment(id)
        .build();Request _request = new Request.Builder()
        .url(_httpUrl)
        .method("DELETE", null)
        .headers(Headers.of(clientOptions.headers()))
        .build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return;
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void update(String namespaceKey, String flagKey, String id,
        RolloutUpdateRequest request) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/namespaces/")
        .addPathSegment(namespaceKey)
        .addPathSegments("flags/")
        .addPathSegment(flagKey)
        .addPathSegments("rollouts")
        .addPathSegment(id)
        .build();
      RequestBody _requestBody;
      try {
        _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
      }
      catch(Exception e) {
        throw new RuntimeException(e);
      }
      Request _request = new Request.Builder()
        .url(_httpUrl)
        .method("PUT", _requestBody)
        .headers(Headers.of(clientOptions.headers()))
        .addHeader("Content-Type", "application/json")
        .build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return;
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
