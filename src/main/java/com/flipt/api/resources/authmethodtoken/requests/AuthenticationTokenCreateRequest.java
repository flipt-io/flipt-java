package com.flipt.api.resources.authmethodtoken.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AuthenticationTokenCreateRequest.Builder.class)
public final class AuthenticationTokenCreateRequest {
    private final String name;

    private final String description;

    private final Optional<OffsetDateTime> expiresAt;

    private AuthenticationTokenCreateRequest(String name, String description, Optional<OffsetDateTime> expiresAt) {
        this.name = name;
        this.description = description;
        this.expiresAt = expiresAt;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("expiresAt")
    public Optional<OffsetDateTime> getExpiresAt() {
        return expiresAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AuthenticationTokenCreateRequest && equalTo((AuthenticationTokenCreateRequest) other);
    }

    private boolean equalTo(AuthenticationTokenCreateRequest other) {
        return name.equals(other.name) && description.equals(other.description) && expiresAt.equals(other.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.description, this.expiresAt);
    }

    @Override
    public String toString() {
        return "AuthenticationTokenCreateRequest{" + "name: " + name + ", description: " + description + ", expiresAt: "
                + expiresAt + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        DescriptionStage name(String name);

        Builder from(AuthenticationTokenCreateRequest other);
    }

    public interface DescriptionStage {
        _FinalStage description(String description);
    }

    public interface _FinalStage {
        AuthenticationTokenCreateRequest build();

        _FinalStage expiresAt(Optional<OffsetDateTime> expiresAt);

        _FinalStage expiresAt(OffsetDateTime expiresAt);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, DescriptionStage, _FinalStage {
        private String name;

        private String description;

        private Optional<OffsetDateTime> expiresAt = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(AuthenticationTokenCreateRequest other) {
            name(other.getName());
            description(other.getDescription());
            expiresAt(other.getExpiresAt());
            return this;
        }

        @Override
        @JsonSetter("name")
        public DescriptionStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("description")
        public _FinalStage description(String description) {
            this.description = description;
            return this;
        }

        @Override
        public _FinalStage expiresAt(OffsetDateTime expiresAt) {
            this.expiresAt = Optional.of(expiresAt);
            return this;
        }

        @Override
        @JsonSetter(value = "expiresAt", nulls = Nulls.SKIP)
        public _FinalStage expiresAt(Optional<OffsetDateTime> expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        @Override
        public AuthenticationTokenCreateRequest build() {
            return new AuthenticationTokenCreateRequest(name, description, expiresAt);
        }
    }
}
