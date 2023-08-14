package com.flipt.api.resources.auth.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AuthenticationMethod {
    METHOD_NONE("METHOD_NONE"),

    METHOD_TOKEN("METHOD_TOKEN"),

    METHOD_OIDC("METHOD_OIDC"),

    METHOD_KUBERNETES("METHOD_KUBERNETES");

    private final String value;

    AuthenticationMethod(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
