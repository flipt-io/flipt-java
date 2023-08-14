package com.flipt.api.resources.auth.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Authentication.Builder.class)
public final class Authentication {
    private final String id;

    private final AuthenticationMethod method;

    private final OffsetDateTime createdAt;

    private final OffsetDateTime updatedAt;

    private final Optional<OffsetDateTime> expiresAt;

    private final Map<String, String> metadata;

    private Authentication(
            String id,
            AuthenticationMethod method,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt,
            Optional<OffsetDateTime> expiresAt,
            Map<String, String> metadata) {
        this.id = id;
        this.method = method;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.expiresAt = expiresAt;
        this.metadata = metadata;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("method")
    public AuthenticationMethod getMethod() {
        return method;
    }

    @JsonProperty("createdAt")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("updatedAt")
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("expiresAt")
    public Optional<OffsetDateTime> getExpiresAt() {
        return expiresAt;
    }

    @JsonProperty("metadata")
    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Authentication && equalTo((Authentication) other);
    }

    private boolean equalTo(Authentication other) {
        return id.equals(other.id)
                && method.equals(other.method)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && expiresAt.equals(other.expiresAt)
                && metadata.equals(other.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.method, this.createdAt, this.updatedAt, this.expiresAt, this.metadata);
    }

    @Override
    public String toString() {
        return "Authentication{" + "id: " + id + ", method: " + method + ", createdAt: " + createdAt + ", updatedAt: "
                + updatedAt + ", expiresAt: " + expiresAt + ", metadata: " + metadata + "}";
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        MethodStage id(String id);

        Builder from(Authentication other);
    }

    public interface MethodStage {
        CreatedAtStage method(AuthenticationMethod method);
    }

    public interface CreatedAtStage {
        UpdatedAtStage createdAt(OffsetDateTime createdAt);
    }

    public interface UpdatedAtStage {
        _FinalStage updatedAt(OffsetDateTime updatedAt);
    }

    public interface _FinalStage {
        Authentication build();

        _FinalStage expiresAt(Optional<OffsetDateTime> expiresAt);

        _FinalStage expiresAt(OffsetDateTime expiresAt);

        _FinalStage metadata(Map<String, String> metadata);

        _FinalStage putAllMetadata(Map<String, String> metadata);

        _FinalStage metadata(String key, String value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, MethodStage, CreatedAtStage, UpdatedAtStage, _FinalStage {
        private String id;

        private AuthenticationMethod method;

        private OffsetDateTime createdAt;

        private OffsetDateTime updatedAt;

        private Map<String, String> metadata = new LinkedHashMap<>();

        private Optional<OffsetDateTime> expiresAt = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Authentication other) {
            id(other.getId());
            method(other.getMethod());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            expiresAt(other.getExpiresAt());
            metadata(other.getMetadata());
            return this;
        }

        @Override
        @JsonSetter("id")
        public MethodStage id(String id) {
            this.id = id;
            return this;
        }

        @Override
        @JsonSetter("method")
        public CreatedAtStage method(AuthenticationMethod method) {
            this.method = method;
            return this;
        }

        @Override
        @JsonSetter("createdAt")
        public UpdatedAtStage createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @Override
        @JsonSetter("updatedAt")
        public _FinalStage updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        @Override
        public _FinalStage metadata(String key, String value) {
            this.metadata.put(key, value);
            return this;
        }

        @Override
        public _FinalStage putAllMetadata(Map<String, String> metadata) {
            this.metadata.putAll(metadata);
            return this;
        }

        @Override
        @JsonSetter(value = "metadata", nulls = Nulls.SKIP)
        public _FinalStage metadata(Map<String, String> metadata) {
            this.metadata.clear();
            this.metadata.putAll(metadata);
            return this;
        }

        @Override
        public _FinalStage expiresAt(OffsetDateTime expiresAt) {
            this.expiresAt = Optional.of(expiresAt);
            return this;
        }

        @Override
        @JsonSetter(value = "expiresAt", nulls = Nulls.SKIP)
        public _FinalStage expiresAt(Optional<OffsetDateTime> expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        @Override
        public Authentication build() {
            return new Authentication(id, method, createdAt, updatedAt, expiresAt, metadata);
        }
    }
}
