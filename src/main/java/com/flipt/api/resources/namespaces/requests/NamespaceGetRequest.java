/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.flipt.api.resources.namespaces.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = NamespaceGetRequest.Builder.class)
public final class NamespaceGetRequest {
    private final Optional<String> reference;

    private NamespaceGetRequest(Optional<String> reference) {
        this.reference = reference;
    }

    @JsonProperty("reference")
    public Optional<String> getReference() {
        return reference;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NamespaceGetRequest && equalTo((NamespaceGetRequest) other);
    }

    private boolean equalTo(NamespaceGetRequest other) {
        return reference.equals(other.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.reference);
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
        private Optional<String> reference = Optional.empty();

        private Builder() {}

        public Builder from(NamespaceGetRequest other) {
            reference(other.getReference());
            return this;
        }

        @JsonSetter(value = "reference", nulls = Nulls.SKIP)
        public Builder reference(Optional<String> reference) {
            this.reference = reference;
            return this;
        }

        public Builder reference(String reference) {
            this.reference = Optional.of(reference);
            return this;
        }

        public NamespaceGetRequest build() {
            return new NamespaceGetRequest(reference);
        }
    }
}
