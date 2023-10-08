/**
 */
package com.flipt.api.resources.evaluation.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ErrorEvaluationResponse.Builder.class)
public final class ErrorEvaluationResponse {
    private final String flagKey;

    private final String namespaceKey;

    private final ErrorEvaluationReason reason;

    private ErrorEvaluationResponse(String flagKey, String namespaceKey, ErrorEvaluationReason reason) {
        this.flagKey = flagKey;
        this.namespaceKey = namespaceKey;
        this.reason = reason;
    }

    @JsonProperty("flagKey")
    public String getFlagKey() {
        return flagKey;
    }

    @JsonProperty("namespaceKey")
    public String getNamespaceKey() {
        return namespaceKey;
    }

    @JsonProperty("reason")
    public ErrorEvaluationReason getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ErrorEvaluationResponse && equalTo((ErrorEvaluationResponse) other);
    }

    private boolean equalTo(ErrorEvaluationResponse other) {
        return flagKey.equals(other.flagKey) && namespaceKey.equals(other.namespaceKey) && reason.equals(other.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.flagKey, this.namespaceKey, this.reason);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static FlagKeyStage builder() {
        return new Builder();
    }

    public interface FlagKeyStage {
        NamespaceKeyStage flagKey(String flagKey);

        Builder from(ErrorEvaluationResponse other);
    }

    public interface NamespaceKeyStage {
        ReasonStage namespaceKey(String namespaceKey);
    }

    public interface ReasonStage {
        _FinalStage reason(ErrorEvaluationReason reason);
    }

    public interface _FinalStage {
        ErrorEvaluationResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FlagKeyStage, NamespaceKeyStage, ReasonStage, _FinalStage {
        private String flagKey;

        private String namespaceKey;

        private ErrorEvaluationReason reason;

        private Builder() {}

        @Override
        public Builder from(ErrorEvaluationResponse other) {
            flagKey(other.getFlagKey());
            namespaceKey(other.getNamespaceKey());
            reason(other.getReason());
            return this;
        }

        @Override
        @JsonSetter("flagKey")
        public NamespaceKeyStage flagKey(String flagKey) {
            this.flagKey = flagKey;
            return this;
        }

        @Override
        @JsonSetter("namespaceKey")
        public ReasonStage namespaceKey(String namespaceKey) {
            this.namespaceKey = namespaceKey;
            return this;
        }

        @Override
        @JsonSetter("reason")
        public _FinalStage reason(ErrorEvaluationReason reason) {
            this.reason = reason;
            return this;
        }

        @Override
        public ErrorEvaluationResponse build() {
            return new ErrorEvaluationResponse(flagKey, namespaceKey, reason);
        }
    }
}
