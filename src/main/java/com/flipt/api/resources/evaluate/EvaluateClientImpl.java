package com.flipt.api.resources.evaluate;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.resources.evaluate.requests.BatchEvaluationRequest;
import com.flipt.api.resources.evaluate.types.BatchEvaluationResponse;
import com.flipt.api.resources.evaluate.types.EvaluationRequest;
import com.flipt.api.resources.evaluate.types.EvaluationResponse;
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

public final class EvaluateClientImpl implements EvaluateClient {
  private final ClientOptions clientOptions;

  public EvaluateClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public EvaluationResponse evaluate(EvaluationRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("api/v1")
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
      .build();
    try {
      Response _response = clientOptions.httpClient().newCall(_request).execute();
      if (_response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), EvaluationResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public BatchEvaluationResponse batchEvaluate(BatchEvaluationRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("api/v1")
      ;HttpUrl _httpUrl = _httpUrlBuilder.build();
      Map<String, Object> _requestBodyProperties = new HashMap<>();
      _requestBodyProperties.put("requestId", request.getRequestId());
      _requestBodyProperties.put("requests", request.getRequests());
      _requestBodyProperties.put("excludeNotFound", request.getExcludeNotFound());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), BatchEvaluationResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
