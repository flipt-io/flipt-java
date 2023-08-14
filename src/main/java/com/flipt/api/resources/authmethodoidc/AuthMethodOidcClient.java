package com.flipt.api.resources.authmethodoidc;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.core.RequestOptions;
import com.flipt.api.resources.authmethodoidc.requests.OidcAuthorizeUrlRequest;
import com.flipt.api.resources.authmethodoidc.requests.OidcCallbackRequest;
import com.flipt.api.resources.authmethodoidc.types.OidcAuthorizeUrlResponse;
import com.flipt.api.resources.authmethodoidc.types.OidcCallbackResponse;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthMethodOidcClient {
    protected final ClientOptions clientOptions;

    public AuthMethodOidcClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public OidcAuthorizeUrlResponse authorizeUrl(String provider, OidcAuthorizeUrlRequest request) {
        return authorizeUrl(provider, request, null);
    }

    public OidcAuthorizeUrlResponse authorizeUrl(
            String provider, OidcAuthorizeUrlRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("auth/v1/method/oidc")
                .addPathSegment(provider)
                .addPathSegments("authorize");
        _httpUrl.addQueryParameter("state", request.getState());
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), OidcAuthorizeUrlResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public OidcCallbackResponse callback(String provider, OidcCallbackRequest request) {
        return callback(provider, request, null);
    }

    public OidcCallbackResponse callback(String provider, OidcCallbackRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("auth/v1/method/oidc")
                .addPathSegment(provider)
                .addPathSegments("callback");
        _httpUrl.addQueryParameter("code", request.getCode());
        _httpUrl.addQueryParameter("state", request.getState());
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), OidcCallbackResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
