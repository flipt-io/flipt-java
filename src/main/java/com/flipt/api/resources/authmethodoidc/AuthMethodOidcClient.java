/**
 */
package com.flipt.api.resources.authmethodoidc;

import com.flipt.api.core.ApiError;
import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.core.RequestOptions;
import com.flipt.api.resources.authmethodoidc.requests.OidcAuthorizeUrlRequest;
import com.flipt.api.resources.authmethodoidc.requests.OidcCallbackRequest;
import com.flipt.api.resources.authmethodoidc.types.OidcAuthorizeUrlResponse;
import com.flipt.api.resources.authmethodoidc.types.OidcCallbackResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
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
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("auth/v1/method/oidc")
                .addPathSegment(provider)
                .addPathSegments("authorize");
        httpUrl.addQueryParameter("state", request.getState());
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), OidcAuthorizeUrlResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public OidcCallbackResponse callback(String provider, OidcCallbackRequest request) {
        return callback(provider, request, null);
    }

    public OidcCallbackResponse callback(String provider, OidcCallbackRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("auth/v1/method/oidc")
                .addPathSegment(provider)
                .addPathSegments("callback");
        httpUrl.addQueryParameter("code", request.getCode());
        httpUrl.addQueryParameter("state", request.getState());
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), OidcCallbackResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
