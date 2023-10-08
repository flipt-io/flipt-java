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
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EvaluationResponse.Builder.class)
public final class EvaluationResponse {
    private final EvaluationResponseType type;

    private final Optional<BooleanEvaluationResponse> booleanResponse;

    private final Optional<VariantEvaluationResponse> variantResponse;

    private final Optional<ErrorEvaluationResponse> errorResponse;

    private EvaluationResponse(
            EvaluationResponseType type,
            Optional<BooleanEvaluationResponse> booleanResponse,
            Optional<VariantEvaluationResponse> variantResponse,
            Optional<ErrorEvaluationResponse> errorResponse) {
        this.type = type;
        this.booleanResponse = booleanResponse;
        this.variantResponse = variantResponse;
        this.errorResponse = errorResponse;
    }

    @JsonProperty("type")
    public EvaluationResponseType getType() {
        return type;
    }

    @JsonProperty("booleanResponse")
    public Optional<BooleanEvaluationResponse> getBooleanResponse() {
        return booleanResponse;
    }

    @JsonProperty("variantResponse")
    public Optional<VariantEvaluationResponse> getVariantResponse() {
        return variantResponse;
    }

    @JsonProperty("errorResponse")
    public Optional<ErrorEvaluationResponse> getErrorResponse() {
        return errorResponse;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EvaluationResponse && equalTo((EvaluationResponse) other);
    }

    private boolean equalTo(EvaluationResponse other) {
        return type.equals(other.type)
                && booleanResponse.equals(other.booleanResponse)
                && variantResponse.equals(other.variantResponse)
                && errorResponse.equals(other.errorResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.booleanResponse, this.variantResponse, this.errorResponse);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TypeStage builder() {
        return new Builder();
    }

    public interface TypeStage {
        _FinalStage type(EvaluationResponseType type);

        Builder from(EvaluationResponse other);
    }

    public interface _FinalStage {
        EvaluationResponse build();

        _FinalStage booleanResponse(Optional<BooleanEvaluationResponse> booleanResponse);

        _FinalStage booleanResponse(BooleanEvaluationResponse booleanResponse);

        _FinalStage variantResponse(Optional<VariantEvaluationResponse> variantResponse);

        _FinalStage variantResponse(VariantEvaluationResponse variantResponse);

        _FinalStage errorResponse(Optional<ErrorEvaluationResponse> errorResponse);

        _FinalStage errorResponse(ErrorEvaluationResponse errorResponse);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TypeStage, _FinalStage {
        private EvaluationResponseType type;

        private Optional<ErrorEvaluationResponse> errorResponse = Optional.empty();

        private Optional<VariantEvaluationResponse> variantResponse = Optional.empty();

        private Optional<BooleanEvaluationResponse> booleanResponse = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(EvaluationResponse other) {
            type(other.getType());
            booleanResponse(other.getBooleanResponse());
            variantResponse(other.getVariantResponse());
            errorResponse(other.getErrorResponse());
            return this;
        }

        @Override
        @JsonSetter("type")
        public _FinalStage type(EvaluationResponseType type) {
            this.type = type;
            return this;
        }

        @Override
        public _FinalStage errorResponse(ErrorEvaluationResponse errorResponse) {
            this.errorResponse = Optional.of(errorResponse);
            return this;
        }

        @Override
        @JsonSetter(value = "errorResponse", nulls = Nulls.SKIP)
        public _FinalStage errorResponse(Optional<ErrorEvaluationResponse> errorResponse) {
            this.errorResponse = errorResponse;
            return this;
        }

        @Override
        public _FinalStage variantResponse(VariantEvaluationResponse variantResponse) {
            this.variantResponse = Optional.of(variantResponse);
            return this;
        }

        @Override
        @JsonSetter(value = "variantResponse", nulls = Nulls.SKIP)
        public _FinalStage variantResponse(Optional<VariantEvaluationResponse> variantResponse) {
            this.variantResponse = variantResponse;
            return this;
        }

        @Override
        public _FinalStage booleanResponse(BooleanEvaluationResponse booleanResponse) {
            this.booleanResponse = Optional.of(booleanResponse);
            return this;
        }

        @Override
        @JsonSetter(value = "booleanResponse", nulls = Nulls.SKIP)
        public _FinalStage booleanResponse(Optional<BooleanEvaluationResponse> booleanResponse) {
            this.booleanResponse = booleanResponse;
            return this;
        }

        @Override
        public EvaluationResponse build() {
            return new EvaluationResponse(type, booleanResponse, variantResponse, errorResponse);
        }
    }
}
