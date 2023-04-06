package com.flipt.api.resources.rules;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.resources.rules.requests.RuleCreateRequest;
import com.flipt.api.resources.rules.requests.RuleListRequest;
import com.flipt.api.resources.rules.requests.RuleOrder;
import com.flipt.api.resources.rules.requests.RuleUpdateRequest;
import com.flipt.api.resources.rules.types.Rule;
import com.flipt.api.resources.rules.types.RuleList;
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

public final class RulesClientImpl implements RulesClient {
  private final ClientOptions clientOptions;

  public RulesClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public RuleList list(String flagKey, RuleListRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("api/v1/flags/")
      .addPathSegment(flagKey)
      .addPathSegments("rules")
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), RuleList.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public Rule create(String flagKey, RuleCreateRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("api/v1/flags/")
        .addPathSegment(flagKey)
        .addPathSegments("rules")
        ;HttpUrl _httpUrl = _httpUrlBuilder.build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("segmentKey", request.getSegmentKey());
        _requestBodyProperties.put("rank", request.getRank());
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
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Rule.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public void order(String flagKey, RuleOrder request) {
        HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
          .addPathSegments("api/v1/flags/")
          .addPathSegment(flagKey)
          .addPathSegments("rules")
          ;HttpUrl _httpUrl = _httpUrlBuilder.build();
          Map<String, Object> _requestBodyProperties = new HashMap<>();
          _requestBodyProperties.put("ruleIds", request.getRuleIds());
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

        @Override
        public Rule get(String flagKey, String id) {
          HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
            .addPathSegments("api/v1/flags/")
            .addPathSegment(flagKey)
            .addPathSegments("rules")
            .addPathSegment(id)
            .build();Request _request = new Request.Builder()
            .url(_httpUrl)
            .method("GET", RequestBody.create("", null))
            .headers(Headers.of(clientOptions.headers()))
            .build();
          try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
              return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Rule.class);
            }
            throw new RuntimeException();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }

        @Override
        public void delete(String flagKey, String id) {
          HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
            .addPathSegments("api/v1/flags/")
            .addPathSegment(flagKey)
            .addPathSegments("rules")
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
        public void update(String flagKey, String id, RuleUpdateRequest request) {
          HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
            .addPathSegments("api/v1/flags/")
            .addPathSegment(flagKey)
            .addPathSegments("rules")
            .addPathSegment(id)
            ;HttpUrl _httpUrl = _httpUrlBuilder.build();
            Map<String, Object> _requestBodyProperties = new HashMap<>();
            _requestBodyProperties.put("segmentKey", request.getSegmentKey());
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
