/**
 */
package com.flipt.api.resources.constraints;

import com.flipt.api.core.ApiError;
import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.core.RequestOptions;
import com.flipt.api.resources.constraints.types.Constraint;
import com.flipt.api.resources.constraints.types.ConstraintCreateRequest;
import com.flipt.api.resources.constraints.types.ConstraintUpdateRequest;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConstraintsClient {
    protected final ClientOptions clientOptions;

    public ConstraintsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public Constraint create(String namespaceKey, String segmentKey, ConstraintCreateRequest request) {
        return create(namespaceKey, segmentKey, request, null);
    }

    public Constraint create(
            String namespaceKey, String segmentKey, ConstraintCreateRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("segments")
                .addPathSegment(segmentKey)
                .addPathSegments("constraints")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Constraint.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String namespaceKey, String segmentKey, String id) {
        delete(namespaceKey, segmentKey, id, null);
    }

    public void delete(String namespaceKey, String segmentKey, String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("segments")
                .addPathSegment(segmentKey)
                .addPathSegments("constraints")
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

    public void update(String namespaceKey, String segmentKey, String id, ConstraintUpdateRequest request) {
        update(namespaceKey, segmentKey, id, request, null);
    }

    public void update(
            String namespaceKey,
            String segmentKey,
            String id,
            ConstraintUpdateRequest request,
            RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("segments")
                .addPathSegment(segmentKey)
                .addPathSegments("constraints")
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
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
