package com.flipt.api.resources.evaluation.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EvaluationResponseType {
    VARIANT_EVALUATION_RESPONSE_TYPE("VARIANT_EVALUATION_RESPONSE_TYPE"),

    BOOLEAN_EVALUATION_RESPONSE_TYPE("BOOLEAN_EVALUATION_RESPONSE_TYPE"),

    ERROR_EVALUATION_RESPONSE_TYPE("ERROR_EVALUATION_RESPONSE_TYPE");

    private final String value;

    EvaluationResponseType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
