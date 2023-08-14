package com.flipt.api.resources.distributions;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.core.RequestOptions;
import com.flipt.api.resources.distributions.requests.DistributionDeleteRequest;
import com.flipt.api.resources.distributions.types.Distribution;
import com.flipt.api.resources.distributions.types.DistributionCreateRequest;
import com.flipt.api.resources.distributions.types.DistributionUpdateRequest;
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
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("flags")
                .addPathSegment(flagKey)
                .addPathSegments("rules")
                .addPathSegment(ruleId)
                .addPathSegments("distributions")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Distribution.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
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
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/v1/namespaces")
                .addPathSegment(namespaceKey)
                .addPathSegments("flags")
                .addPathSegment(flagKey)
                .addPathSegments("rules")
                .addPathSegment(ruleId)
                .addPathSegments("distributions")
                .addPathSegment(id);
        _httpUrl.addQueryParameter("variantId", request.getVariantId());
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("DELETE", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)));
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return;
            }
            throw new RuntimeException();
        } catch (Exception e) {
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
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
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
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Distribution.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
