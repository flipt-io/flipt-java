/**
 */
package com.flipt.api.resources.authmethodk8s;

import com.flipt.api.core.ApiError;
import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.core.RequestOptions;
import com.flipt.api.resources.auth.types.AuthenticationToken;
import com.flipt.api.resources.authmethodk8s.requests.KubernetesVerifyServiceAccount;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthMethodK8SClient {
    protected final ClientOptions clientOptions;

    public AuthMethodK8SClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public AuthenticationToken verifyServiceAccount(KubernetesVerifyServiceAccount request) {
        return verifyServiceAccount(request, null);
    }

    public AuthenticationToken verifyServiceAccount(
            KubernetesVerifyServiceAccount request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("auth/v1/method/kubernetes")
                .addPathSegments("serviceaccount")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), AuthenticationToken.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
