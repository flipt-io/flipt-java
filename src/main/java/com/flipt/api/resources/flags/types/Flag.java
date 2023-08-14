package com.flipt.api.resources.flags.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.resources.variants.types.Variant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Flag.Builder.class)
public final class Flag {
    private final String namespaceKey;

    private final String key;

    private final String name;

    private final String description;

    private final boolean enabled;

    private final OffsetDateTime createdAt;

    private final OffsetDateTime updatedAt;

    private final List<Variant> variants;

    private final FlagType type;

    private Flag(
            String namespaceKey,
            String key,
            String name,
            String description,
            boolean enabled,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt,
            List<Variant> variants,
            FlagType type) {
        this.namespaceKey = namespaceKey;
        this.key = key;
        this.name = name;
        this.description = description;
        this.enabled = enabled;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.variants = variants;
        this.type = type;
    }

    @JsonProperty("namespaceKey")
    public String getNamespaceKey() {
        return namespaceKey;
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
    public String getDescription() {
        return description;
    }

    @JsonProperty("enabled")
    public boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("createdAt")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("updatedAt")
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("variants")
    public List<Variant> getVariants() {
        return variants;
    }

    @JsonProperty("type")
    public FlagType getType() {
        return type;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Flag && equalTo((Flag) other);
    }

    private boolean equalTo(Flag other) {
        return namespaceKey.equals(other.namespaceKey)
                && key.equals(other.key)
                && name.equals(other.name)
                && description.equals(other.description)
                && enabled == other.enabled
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && variants.equals(other.variants)
                && type.equals(other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.namespaceKey,
                this.key,
                this.name,
                this.description,
                this.enabled,
                this.createdAt,
                this.updatedAt,
                this.variants,
                this.type);
    }

    @Override
    public String toString() {
        return "Flag{" + "namespaceKey: " + namespaceKey + ", key: " + key + ", name: " + name + ", description: "
                + description + ", enabled: " + enabled + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt
                + ", variants: " + variants + ", type: " + type + "}";
    }

    public static NamespaceKeyStage builder() {
        return new Builder();
    }

    public interface NamespaceKeyStage {
        KeyStage namespaceKey(String namespaceKey);

        Builder from(Flag other);
    }

    public interface KeyStage {
        NameStage key(String key);
    }

    public interface NameStage {
        DescriptionStage name(String name);
    }

    public interface DescriptionStage {
        EnabledStage description(String description);
    }

    public interface EnabledStage {
        CreatedAtStage enabled(boolean enabled);
    }

    public interface CreatedAtStage {
        UpdatedAtStage createdAt(OffsetDateTime createdAt);
    }

    public interface UpdatedAtStage {
        TypeStage updatedAt(OffsetDateTime updatedAt);
    }

    public interface TypeStage {
        _FinalStage type(FlagType type);
    }

    public interface _FinalStage {
        Flag build();

        _FinalStage variants(List<Variant> variants);

        _FinalStage addVariants(Variant variants);

        _FinalStage addAllVariants(List<Variant> variants);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements NamespaceKeyStage,
                    KeyStage,
                    NameStage,
                    DescriptionStage,
                    EnabledStage,
                    CreatedAtStage,
                    UpdatedAtStage,
                    TypeStage,
                    _FinalStage {
        private String namespaceKey;

        private String key;

        private String name;

        private String description;

        private boolean enabled;

        private OffsetDateTime createdAt;

        private OffsetDateTime updatedAt;

        private FlagType type;

        private List<Variant> variants = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(Flag other) {
            namespaceKey(other.getNamespaceKey());
            key(other.getKey());
            name(other.getName());
            description(other.getDescription());
            enabled(other.getEnabled());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            variants(other.getVariants());
            type(other.getType());
            return this;
        }

        @Override
        @JsonSetter("namespaceKey")
        public KeyStage namespaceKey(String namespaceKey) {
            this.namespaceKey = namespaceKey;
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
        public DescriptionStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("description")
        public EnabledStage description(String description) {
            this.description = description;
            return this;
        }

        @Override
        @JsonSetter("enabled")
        public CreatedAtStage enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        @Override
        @JsonSetter("createdAt")
        public UpdatedAtStage createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @Override
        @JsonSetter("updatedAt")
        public TypeStage updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        @Override
        @JsonSetter("type")
        public _FinalStage type(FlagType type) {
            this.type = type;
            return this;
        }

        @Override
        public _FinalStage addAllVariants(List<Variant> variants) {
            this.variants.addAll(variants);
            return this;
        }

        @Override
        public _FinalStage addVariants(Variant variants) {
            this.variants.add(variants);
            return this;
        }

        @Override
        @JsonSetter(value = "variants", nulls = Nulls.SKIP)
        public _FinalStage variants(List<Variant> variants) {
            this.variants.clear();
            this.variants.addAll(variants);
            return this;
        }

        @Override
        public Flag build() {
            return new Flag(namespaceKey, key, name, description, enabled, createdAt, updatedAt, variants, type);
        }
    }
}
