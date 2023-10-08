/**
 */
package com.flipt.api.resources.evaluation.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.core.ObjectMappers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EvaluationRequest.Builder.class)
public final class EvaluationRequest {
    private final Optional<String> requestId;

    private final String namespaceKey;

    private final String flagKey;

    private final String entityId;

    private final Map<String, String> context;

    private EvaluationRequest(
            Optional<String> requestId,
            String namespaceKey,
            String flagKey,
            String entityId,
            Map<String, String> context) {
        this.requestId = requestId;
        this.namespaceKey = namespaceKey;
        this.flagKey = flagKey;
        this.entityId = entityId;
        this.context = context;
    }

    @JsonProperty("requestId")
    public Optional<String> getRequestId() {
        return requestId;
    }

    @JsonProperty("namespaceKey")
    public String getNamespaceKey() {
        return namespaceKey;
    }

    @JsonProperty("flagKey")
    public String getFlagKey() {
        return flagKey;
    }

    @JsonProperty("entityId")
    public String getEntityId() {
        return entityId;
    }

    @JsonProperty("context")
    public Map<String, String> getContext() {
        return context;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EvaluationRequest && equalTo((EvaluationRequest) other);
    }

    private boolean equalTo(EvaluationRequest other) {
        return requestId.equals(other.requestId)
                && namespaceKey.equals(other.namespaceKey)
                && flagKey.equals(other.flagKey)
                && entityId.equals(other.entityId)
                && context.equals(other.context);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requestId, this.namespaceKey, this.flagKey, this.entityId, this.context);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NamespaceKeyStage builder() {
        return new Builder();
    }

    public interface NamespaceKeyStage {
        FlagKeyStage namespaceKey(String namespaceKey);

        Builder from(EvaluationRequest other);
    }

    public interface FlagKeyStage {
        EntityIdStage flagKey(String flagKey);
    }

    public interface EntityIdStage {
        _FinalStage entityId(String entityId);
    }

    public interface _FinalStage {
        EvaluationRequest build();

        _FinalStage requestId(Optional<String> requestId);

        _FinalStage requestId(String requestId);

        _FinalStage context(Map<String, String> context);

        _FinalStage putAllContext(Map<String, String> context);

        _FinalStage context(String key, String value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NamespaceKeyStage, FlagKeyStage, EntityIdStage, _FinalStage {
        private String namespaceKey;

        private String flagKey;

        private String entityId;

        private Map<String, String> context = new LinkedHashMap<>();

        private Optional<String> requestId = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(EvaluationRequest other) {
            requestId(other.getRequestId());
            namespaceKey(other.getNamespaceKey());
            flagKey(other.getFlagKey());
            entityId(other.getEntityId());
            context(other.getContext());
            return this;
        }

        @Override
        @JsonSetter("namespaceKey")
        public FlagKeyStage namespaceKey(String namespaceKey) {
            this.namespaceKey = namespaceKey;
            return this;
        }

        @Override
        @JsonSetter("flagKey")
        public EntityIdStage flagKey(String flagKey) {
            this.flagKey = flagKey;
            return this;
        }

        @Override
        @JsonSetter("entityId")
        public _FinalStage entityId(String entityId) {
            this.entityId = entityId;
            return this;
        }

        @Override
        public _FinalStage context(String key, String value) {
            this.context.put(key, value);
            return this;
        }

        @Override
        public _FinalStage putAllContext(Map<String, String> context) {
            this.context.putAll(context);
            return this;
        }

        @Override
        @JsonSetter(value = "context", nulls = Nulls.SKIP)
        public _FinalStage context(Map<String, String> context) {
            this.context.clear();
            this.context.putAll(context);
            return this;
        }

        @Override
        public _FinalStage requestId(String requestId) {
            this.requestId = Optional.of(requestId);
            return this;
        }

        @Override
        @JsonSetter(value = "requestId", nulls = Nulls.SKIP)
        public _FinalStage requestId(Optional<String> requestId) {
            this.requestId = requestId;
            return this;
        }

        @Override
        public EvaluationRequest build() {
            return new EvaluationRequest(requestId, namespaceKey, flagKey, entityId, context);
        }
    }
}
