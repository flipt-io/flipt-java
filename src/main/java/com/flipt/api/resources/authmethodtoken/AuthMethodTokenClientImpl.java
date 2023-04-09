package com.flipt.api.resources.authmethodtoken;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.resources.auth.types.AuthenticationToken;
import com.flipt.api.resources.authmethodtoken.requests.AuthenticationTokenCreateRequest;
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

public final class AuthMethodTokenClientImpl implements AuthMethodTokenClient {
  private final ClientOptions clientOptions;

  public AuthMethodTokenClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public AuthenticationToken createToken(AuthenticationTokenCreateRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("auth/v1/method/token")
      ;HttpUrl _httpUrl = _httpUrlBuilder.build();
      Map<String, Object> _requestBodyProperties = new HashMap<>();
      _requestBodyProperties.put("name", request.getName());
      _requestBodyProperties.put("description", request.getDescription());
      _requestBodyProperties.put("expiresAt", request.getExpiresAt());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AuthenticationToken.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
