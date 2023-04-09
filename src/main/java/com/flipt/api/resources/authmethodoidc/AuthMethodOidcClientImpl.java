package com.flipt.api.resources.authmethodoidc;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.resources.authmethodoidc.requests.OidcAuthorizeUrlRequest;
import com.flipt.api.resources.authmethodoidc.requests.OidcCallbackRequest;
import com.flipt.api.resources.authmethodoidc.types.OidcAuthorizeUrlResponse;
import com.flipt.api.resources.authmethodoidc.types.OidcCallbackResponse;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class AuthMethodOidcClientImpl implements AuthMethodOidcClient {
  private final ClientOptions clientOptions;

  public AuthMethodOidcClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  @Override
  public OidcAuthorizeUrlResponse authorizeUrl(String provider, OidcAuthorizeUrlRequest request) {
    HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("auth/v1/method/oidc")
      .addPathSegment(provider)
      .addPathSegments("authorize")
      ;_httpUrlBuilder.addQueryParameter("state", request.getState());
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
          return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), OidcAuthorizeUrlResponse.class);
        }
        throw new RuntimeException();
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public OidcCallbackResponse callback(String provider, OidcCallbackRequest request) {
      HttpUrl.Builder _httpUrlBuilder = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("auth/v1/method/oidc")
        .addPathSegment(provider)
        .addPathSegments("callback")
        ;_httpUrlBuilder.addQueryParameter("code", request.getCode());
        _httpUrlBuilder.addQueryParameter("state", request.getState());
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
            return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), OidcCallbackResponse.class);
          }
          throw new RuntimeException();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }
