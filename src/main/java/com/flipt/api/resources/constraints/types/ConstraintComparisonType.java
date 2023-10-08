/**
 */
package com.flipt.api.resources.constraints.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ConstraintComparisonType {
    UNKNOWN_COMPARISON_TYPE("UNKNOWN_COMPARISON_TYPE"),

    STRING_COMPARISON_TYPE("STRING_COMPARISON_TYPE"),

    NUMBER_COMPARISON_TYPE("NUMBER_COMPARISON_TYPE"),

    BOOLEAN_COMPARISON_TYPE("BOOLEAN_COMPARISON_TYPE"),

    DATETIME_COMPARISON_TYPE("DATETIME_COMPARISON_TYPE");

    private final String value;

    ConstraintComparisonType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
