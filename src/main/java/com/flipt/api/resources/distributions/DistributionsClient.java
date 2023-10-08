/**
 */
package com.flipt.api.resources.distributions;

import com.flipt.api.core.ApiError;
import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.core.RequestOptions;
import com.flipt.api.resources.distributions.requests.DistributionDeleteRequest;
import com.flipt.api.resources.distributions.types.Distribution;
import com.flipt.api.resources.distributions.types.DistributionCreateRequest;
import com.flipt.api.resources.distributions.types.DistributionUpdateRequest;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DistributionsClient {
    protected final ClientOptions clientOptions;

    public DistributionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public Distribution create(String namespaceKey, String flagKey, String ruleId, DistributionCreateRequest request) {
        return create(namespaceKey, flagKey, ruleId, request, null);
    }

    public Distribution create(
            String namespaceKey,
            String flagKey,
            String ruleId,
            DistributionCreateRequest request,
            RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("flags")
                .addPathSegment(flagKey)
                .addPathSegments("rules")
                .addPathSegment(ruleId)
                .addPathSegments("distributions")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Distribution.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(
            String namespaceKey, String flagKey, String ruleId, String id, DistributionDeleteRequest request) {
        delete(namespaceKey, flagKey, ruleId, id, request, null);
    }

    public void delete(
            String namespaceKey,
            String flagKey,
            String ruleId,
            String id,
            DistributionDeleteRequest request,
            RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("flags")
                .addPathSegment(flagKey)
                .addPathSegments("rules")
                .addPathSegment(ruleId)
                .addPathSegments("distributions")
                .addPathSegment(id);
        httpUrl.addQueryParameter("variantId", request.getVariantId());
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)));
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Distribution update(
            String namespaceKey, String flagKey, String ruleId, String id, DistributionUpdateRequest request) {
        return update(namespaceKey, flagKey, ruleId, id, request, null);
    }

    public Distribution update(
            String namespaceKey,
            String flagKey,
            String ruleId,
            String id,
            DistributionUpdateRequest request,
            RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("flags")
                .addPathSegment(flagKey)
                .addPathSegments("rules")
                .addPathSegment(ruleId)
                .addPathSegments("distributions")
                .addPathSegment(id)
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
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Distribution.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
