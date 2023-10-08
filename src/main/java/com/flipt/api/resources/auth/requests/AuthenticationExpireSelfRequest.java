/**
 */
package com.flipt.api.resources.auth.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AuthenticationExpireSelfRequest.Builder.class)
public final class AuthenticationExpireSelfRequest {
    private final Optional<OffsetDateTime> expiresAt;

    private AuthenticationExpireSelfRequest(Optional<OffsetDateTime> expiresAt) {
        this.expiresAt = expiresAt;
    }

    @JsonProperty("expiresAt")
    public Optional<OffsetDateTime> getExpiresAt() {
        return expiresAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AuthenticationExpireSelfRequest && equalTo((AuthenticationExpireSelfRequest) other);
    }

    private boolean equalTo(AuthenticationExpireSelfRequest other) {
        return expiresAt.equals(other.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.expiresAt);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<OffsetDateTime> expiresAt = Optional.empty();

        private Builder() {}

        public Builder from(AuthenticationExpireSelfRequest other) {
            expiresAt(other.getExpiresAt());
            return this;
        }

        @JsonSetter(value = "expiresAt", nulls = Nulls.SKIP)
        public Builder expiresAt(Optional<OffsetDateTime> expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public Builder expiresAt(OffsetDateTime expiresAt) {
            this.expiresAt = Optional.of(expiresAt);
            return this;
        }

        public AuthenticationExpireSelfRequest build() {
            return new AuthenticationExpireSelfRequest(expiresAt);
        }
    }
}
