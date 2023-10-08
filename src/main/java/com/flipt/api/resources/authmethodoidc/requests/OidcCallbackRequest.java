/**
 */
package com.flipt.api.resources.authmethodoidc.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = OidcCallbackRequest.Builder.class)
public final class OidcCallbackRequest {
    private final String code;

    private final String state;

    private OidcCallbackRequest(String code, String state) {
        this.code = code;
        this.state = state;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OidcCallbackRequest && equalTo((OidcCallbackRequest) other);
    }

    private boolean equalTo(OidcCallbackRequest other) {
        return code.equals(other.code) && state.equals(other.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code, this.state);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CodeStage builder() {
        return new Builder();
    }

    public interface CodeStage {
        StateStage code(String code);

        Builder from(OidcCallbackRequest other);
    }

    public interface StateStage {
        _FinalStage state(String state);
    }

    public interface _FinalStage {
        OidcCallbackRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CodeStage, StateStage, _FinalStage {
        private String code;

        private String state;

        private Builder() {}

        @Override
        public Builder from(OidcCallbackRequest other) {
            code(other.getCode());
            state(other.getState());
            return this;
        }

        @Override
        @JsonSetter("code")
        public StateStage code(String code) {
            this.code = code;
            return this;
        }

        @Override
        @JsonSetter("state")
        public _FinalStage state(String state) {
            this.state = state;
            return this;
        }

        @Override
        public OidcCallbackRequest build() {
            return new OidcCallbackRequest(code, state);
        }
    }
}
