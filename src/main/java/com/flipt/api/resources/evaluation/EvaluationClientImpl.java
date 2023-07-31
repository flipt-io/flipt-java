package com.flipt.api.resources.evaluation;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.resources.evaluation.types.BatchEvaluationRequest;
import com.flipt.api.resources.evaluation.types.BatchEvaluationResponse;
import com.flipt.api.resources.evaluation.types.BooleanEvaluationResponse;
import com.flipt.api.resources.evaluation.types.EvaluationRequest;
import com.flipt.api.resources.evaluation.types.VariantEvaluationResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class EvaluationClientImpl implements EvaluationClient {
  private final ClientOptions clientOptions;

  public EvaluationClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public BooleanEvaluationResponse boolean_(EvaluationRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("evaluate/v1")
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
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), BooleanEvaluationResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public VariantEvaluationResponse variant(EvaluationRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("evaluate/v1")
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
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), VariantEvaluationResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public BatchEvaluationResponse batch(BatchEvaluationRequest request) {
    HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("evaluate/v1")
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
        return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), BatchEvaluationResponse.class);
      }
      throw new RuntimeException();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
