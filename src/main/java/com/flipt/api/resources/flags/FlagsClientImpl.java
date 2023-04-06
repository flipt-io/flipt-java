package com.flipt.api.resources.flags;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.resources.flags.requests.FlagCreateRequest;
import com.flipt.api.resources.flags.requests.FlagListRequest;
import com.flipt.api.resources.flags.requests.FlagUpdateRequest;
import com.flipt.api.resources.flags.types.Flag;
import com.flipt.api.resources.flags.types.FlagList;
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

public final class FlagsClientImpl implements FlagsClient {
  private final ClientOptions clientOptions;

  public FlagsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public FlagList list(FlagListRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("api/v1/flags")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), FlagList.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public Flag create(FlagCreateRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/flags")
        ;HttpUrl _httpUrl = _httpUrlBuilder.build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("key", request.getKey());
        _requestBodyProperties.put("name", request.getName());
        _requestBodyProperties.put("description", request.getDescription());
        _requestBodyProperties.put("enabled", request.getEnabled());
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
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Flag.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public Flag get(String key) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
          .addPathSegments("api/v1/flags")
          .addPathSegment(key)
          .build();Request _request = new Request.Builder()
          .url(_httpUrl)
          .method("GET", RequestBody.create("", null))
          .headers(Headers.of(clientOptions.headers()))
          .build();
        try {
          Response _response = clientOptions.httpClient().newCall(_request).execute();
          if (_response.isSuccessful()) {
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Flag.class);
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
          .addPathSegments("api/v1/flags")
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
      public Flag update(String key, FlagUpdateRequest request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
          .addPathSegments("api/v1/flags")
          .addPathSegment(key)
          ;HttpUrl _httpUrl = _httpUrlBuilder.build();
          Map<String, Object> _requestBodyProperties = new HashMap<>();
          _requestBodyProperties.put("name", request.getName());
          _requestBodyProperties.put("description", request.getDescription());
          _requestBodyProperties.put("enabled", request.getEnabled());
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
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Flag.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
      }
