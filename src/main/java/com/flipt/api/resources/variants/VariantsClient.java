/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.flipt.api.resources.variants;

import com.flipt.api.core.ApiError;
import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.core.RequestOptions;
import com.flipt.api.resources.variants.types.Variant;
import com.flipt.api.resources.variants.types.VariantCreateRequest;
import com.flipt.api.resources.variants.types.VariantUpdateRequest;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class VariantsClient {
    protected final ClientOptions clientOptions;

    public VariantsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public Variant create(String namespaceKey, String flagKey, VariantCreateRequest request) {
        return create(namespaceKey, flagKey, request, null);
    }

    public Variant create(
            String namespaceKey, String flagKey, VariantCreateRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("flags")
                .addPathSegment(flagKey)
                .addPathSegments("variants")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Variant.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String namespaceKey, String flagKey, String id) {
        delete(namespaceKey, flagKey, id, null);
    }

    public void delete(String namespaceKey, String flagKey, String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("flags")
                .addPathSegment(flagKey)
                .addPathSegments("variants")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
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

    public Variant update(String namespaceKey, String flagKey, String id, VariantUpdateRequest request) {
        return update(namespaceKey, flagKey, id, request, null);
    }

    public Variant update(
            String namespaceKey,
            String flagKey,
            String id,
            VariantUpdateRequest request,
            RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("flags")
                .addPathSegment(flagKey)
                .addPathSegments("variants")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Variant.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
