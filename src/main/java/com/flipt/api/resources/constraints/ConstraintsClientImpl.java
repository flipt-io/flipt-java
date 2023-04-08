package com.flipt.api.resources.constraints;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.resources.constraints.requests.ConstraintCreateRequest;
import com.flipt.api.resources.constraints.requests.ConstraintUpdateRequest;
import com.flipt.api.resources.constraints.types.Constraint;
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

public final class ConstraintsClientImpl implements ConstraintsClient {
  private final ClientOptions clientOptions;

  public ConstraintsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public Constraint create(String segmentKey, ConstraintCreateRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("api/v1/segments/")
      .addPathSegment(segmentKey)
      .addPathSegments("constraints")
      ;HttpUrl _httpUrl = _httpUrlBuilder.build();
      Map<String, Object> _requestBodyProperties = new HashMap<>();
      _requestBodyProperties.put("type", request.getType());
      _requestBodyProperties.put("property", request.getProperty());
      _requestBodyProperties.put("operator", request.getOperator());
      _requestBodyProperties.put("value", request.getValue());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Constraint.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void delete(String segmentKey, String id) {
      HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/segments/")
        .addPathSegment(segmentKey)
        .addPathSegments("constraints")
        .addPathSegment(id)
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
    public void update(String segmentKey, String id, ConstraintUpdateRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/segments/")
        .addPathSegment(segmentKey)
        .addPathSegments("constraints")
        .addPathSegment(id)
        ;HttpUrl _httpUrl = _httpUrlBuilder.build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("type", request.getType());
        _requestBodyProperties.put("property", request.getProperty());
        _requestBodyProperties.put("operator", request.getOperator());
        _requestBodyProperties.put("value", request.getValue());
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
            return;
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }