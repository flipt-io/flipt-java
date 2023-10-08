/**
 */
package com.flipt.api.resources.flags.types;

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
@JsonDeserialize(builder = FlagCreateRequest.Builder.class)
public final class FlagCreateRequest {
    private final String key;

    private final String name;

    private final Optional<String> description;

    private final Optional<Boolean> enabled;

    private final FlagType type;

    private FlagCreateRequest(
            String key, String name, Optional<String> description, Optional<Boolean> enabled, FlagType type) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.enabled = enabled;
        this.type = type;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("enabled")
    public Optional<Boolean> getEnabled() {
        return enabled;
    }

    @JsonProperty("type")
    public FlagType getType() {
        return type;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FlagCreateRequest && equalTo((FlagCreateRequest) other);
    }

    private boolean equalTo(FlagCreateRequest other) {
        return key.equals(other.key)
                && name.equals(other.name)
                && description.equals(other.description)
                && enabled.equals(other.enabled)
                && type.equals(other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.name, this.description, this.enabled, this.type);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static KeyStage builder() {
        return new Builder();
    }

    public interface KeyStage {
        NameStage key(String key);

        Builder from(FlagCreateRequest other);
    }

    public interface NameStage {
        TypeStage name(String name);
    }

    public interface TypeStage {
        _FinalStage type(FlagType type);
    }

    public interface _FinalStage {
        FlagCreateRequest build();

        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);

        _FinalStage enabled(Optional<Boolean> enabled);

        _FinalStage enabled(Boolean enabled);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements KeyStage, NameStage, TypeStage, _FinalStage {
        private String key;

        private String name;

        private FlagType type;

        private Optional<Boolean> enabled = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(FlagCreateRequest other) {
            key(other.getKey());
            name(other.getName());
            description(other.getDescription());
            enabled(other.getEnabled());
            type(other.getType());
            return this;
        }

        @Override
        @JsonSetter("key")
        public NameStage key(String key) {
            this.key = key;
            return this;
        }

        @Override
        @JsonSetter("name")
        public TypeStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("type")
        public _FinalStage type(FlagType type) {
            this.type = type;
            return this;
        }

        @Override
        public _FinalStage enabled(Boolean enabled) {
            this.enabled = Optional.of(enabled);
            return this;
        }

        @Override
        @JsonSetter(value = "enabled", nulls = Nulls.SKIP)
        public _FinalStage enabled(Optional<Boolean> enabled) {
            this.enabled = enabled;
            return this;
        }

        @Override
        public _FinalStage description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        @Override
        public FlagCreateRequest build() {
            return new FlagCreateRequest(key, name, description, enabled, type);
        }
    }
}
