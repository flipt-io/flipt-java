package com.flipt.api.resources.distributions;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.resources.distributions.requests.DistributionCreateRequest;
import com.flipt.api.resources.distributions.requests.DistributionDeleteRequest;
import com.flipt.api.resources.distributions.requests.DistributionUpdateRequest;
import com.flipt.api.resources.distributions.types.Distribution;
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

public final class DistributionsClientImpl implements DistributionsClient {
  private final ClientOptions clientOptions;

  public DistributionsClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public Distribution create(String flagKey, String ruleId, DistributionCreateRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("api/v1/flags/")
      .addPathSegment(flagKey)
      .addPathSegments("rules/")
      .addPathSegment(ruleId)
      .addPathSegments("distributions")
      ;HttpUrl _httpUrl = _httpUrlBuilder.build();
      Map<String, Object> _requestBodyProperties = new HashMap<>();
      _requestBodyProperties.put("variantId", request.getVariantId());
      _requestBodyProperties.put("rollout", request.getRollout());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Distribution.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void delete(String flagKey, String ruleId, String id,
        DistributionDeleteRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/flags/")
        .addPathSegment(flagKey)
        .addPathSegments("rules/")
        .addPathSegment(ruleId)
        .addPathSegments("distributions")
        .addPathSegment(id)
        ;_httpUrlBuilder.addQueryParameter("variantId", request.getVariantId());
        HttpUrl _httpUrl = _httpUrlBuilder.build();
        RequestBody _requestBody = RequestBody.create("", null);
        Request.Builder _requestBuilder = new Request.Builder()
          .url(_httpUrl)
          .method("DELETE", _requestBody)
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

      @Override
      public Distribution update(String flagKey, String ruleId, String id,
          DistributionUpdateRequest request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
          .addPathSegments("api/v1/flags/")
          .addPathSegment(flagKey)
          .addPathSegments("rules/")
          .addPathSegment(ruleId)
          .addPathSegments("distributions")
          .addPathSegment(id)
          ;HttpUrl _httpUrl = _httpUrlBuilder.build();
          Map<String, Object> _requestBodyProperties = new HashMap<>();
          _requestBodyProperties.put("variantId", request.getVariantId());
          _requestBodyProperties.put("rollout", request.getRollout());
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
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Distribution.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
      }
