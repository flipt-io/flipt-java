package com.flipt.api.resources.segments;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.resources.segments.requests.SegmentCreateRequest;
import com.flipt.api.resources.segments.requests.SegmentListRequest;
import com.flipt.api.resources.segments.requests.SegmentUpdateRequest;
import com.flipt.api.resources.segments.types.Segment;
import com.flipt.api.resources.segments.types.SegmentList;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class SegmentsClientImpl implements SegmentsClient {
  private final ClientOptions clientOptions;

  public SegmentsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public SegmentList list(SegmentListRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("api/v1/segments")
      ;if (request.getLimit().isPresent()) {
        _httpUrlBuilder.addQueryParameter("limit", request.getLimit().get().toString());
      }
      if (request.getOffset().isPresent()) {
        _httpUrlBuilder.addQueryParameter("offset", request.getOffset().get().toString());
      }
      if (request.getPageToken().isPresent()) {
        _httpUrlBuilder.addQueryParameter("pageToken", request.getPageToken().get());
      }
      HttpUrl _httpUrl = _httpUrlBuilder.build();
      RequestBody _requestBody = RequestBody.create("", null);
      Request.Builder _requestBuilder = new Request.Builder()
        .url(_httpUrl)
        .method("GET", _requestBody)
        .headers(Headers.of(clientOptions.headers()));
      Request _request = _requestBuilder.build();
      try {
        Response _response = clientOptions.httpClient().newCall(_request).execute();
        if (_response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), SegmentList.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public Segment create(SegmentCreateRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/segments")
        ;HttpUrl _httpUrl = _httpUrlBuilder.build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("key", request.getKey());
        _requestBodyProperties.put("name", request.getName());
        _requestBodyProperties.put("description", request.getDescription());
        _requestBodyProperties.put("matchType", request.getMatchType());
        RequestBody _requestBody;
        try {
          _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties), MediaType.parse("application/json"));
        }
        catch(Exception e) {
          throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
          .url(_httpUrl)
          .method("POST", _requestBody)
          .headers(Headers.of(clientOptions.headers()));
        Request _request = _requestBuilder.build();
        try {
          Response _response = clientOptions.httpClient().newCall(_request).execute();
          if (_response.isSuccessful()) {
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Segment.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public Segment get(String key) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
          .addPathSegments("api/v1/segments")
          .addPathSegment(key)
          .build();Request _request = new Request.Builder()
          .url(_httpUrl)
          .method("GET", RequestBody.create("", null))
          .headers(Headers.of(clientOptions.headers()))
          .build();
        try {
          Response _response = clientOptions.httpClient().newCall(_request).execute();
          if (_response.isSuccessful()) {
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Segment.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public void delete(String key) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
          .addPathSegments("api/v1/segments")
          .addPathSegment(key)
          .build();Request _request = new Request.Builder()
          .url(_httpUrl)
          .method("DELETE", RequestBody.create("", null))
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
      public Segment update(String key, SegmentUpdateRequest request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
          .addPathSegments("api/v1/segments")
          .addPathSegment(key)
          ;HttpUrl _httpUrl = _httpUrlBuilder.build();
          Map<String, Object> _requestBodyProperties = new HashMap<>();
          _requestBodyProperties.put("name", request.getName());
          _requestBodyProperties.put("description", request.getDescription());
          _requestBodyProperties.put("matchType", request.getMatchType());
          RequestBody _requestBody;
          try {
            _requestBody = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties), MediaType.parse("application/json"));
          }
          catch(Exception e) {
            throw new RuntimeException(e);
          }
          Request.Builder _requestBuilder = new Request.Builder()
            .url(_httpUrl)
            .method("PUT", _requestBody)
            .headers(Headers.of(clientOptions.headers()));
          Request _request = _requestBuilder.build();
          try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Segment.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
      }
