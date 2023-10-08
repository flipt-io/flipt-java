/**
 */
package com.flipt.api.resources.segments.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SegmentMatchType {
    ALL_MATCH_TYPE("ALL_MATCH_TYPE"),

    ANY_MATCH_TYPE("ANY_MATCH_TYPE");

    private final String value;

    SegmentMatchType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
