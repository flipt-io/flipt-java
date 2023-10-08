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
@JsonDeserialize(builder = OidcAuthorizeUrlRequest.Builder.class)
public final class OidcAuthorizeUrlRequest {
    private final String state;

    private OidcAuthorizeUrlRequest(String state) {
        this.state = state;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OidcAuthorizeUrlRequest && equalTo((OidcAuthorizeUrlRequest) other);
    }

    private boolean equalTo(OidcAuthorizeUrlRequest other) {
        return state.equals(other.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.state);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StateStage builder() {
        return new Builder();
    }

    public interface StateStage {
        _FinalStage state(String state);

        Builder from(OidcAuthorizeUrlRequest other);
    }

    public interface _FinalStage {
        OidcAuthorizeUrlRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StateStage, _FinalStage {
        private String state;

        private Builder() {}

        @Override
        public Builder from(OidcAuthorizeUrlRequest other) {
            state(other.getState());
            return this;
        }

        @Override
        @JsonSetter("state")
        public _FinalStage state(String state) {
            this.state = state;
            return this;
        }

        @Override
        public OidcAuthorizeUrlRequest build() {
            return new OidcAuthorizeUrlRequest(state);
        }
    }
}
