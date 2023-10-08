/**
 */
package com.flipt.api.resources.evaluate.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EvaluationReason {
    UNKNOWN_EVALUATION_REASON("UNKNOWN_EVALUATION_REASON"),

    FLAG_DISABLED_EVALUATION_REASON("FLAG_DISABLED_EVALUATION_REASON"),

    FLAG_NOT_FOUND_EVALUATION_REASON("FLAG_NOT_FOUND_EVALUATION_REASON"),

    MATCH_EVALUATION_REASON("MATCH_EVALUATION_REASON"),

    ERROR_EVALUATION_REASON("ERROR_EVALUATION_REASON");

    private final String value;

    EvaluationReason(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
