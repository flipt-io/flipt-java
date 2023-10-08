/**
 */
package com.flipt.api.resources.evaluation.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorEvaluationReason {
    UNKNOWN_ERROR_EVALUATION_REASON("UNKNOWN_ERROR_EVALUATION_REASON"),

    NOT_FOUND_ERROR_EVALUATION_REASON("NOT_FOUND_ERROR_EVALUATION_REASON");

    private final String value;

    ErrorEvaluationReason(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
