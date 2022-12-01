package com.flipt.api.client.variants.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = Variant.Builder.class
)
public final class Variant {
  private final String id;

  private final String flagKey;

  private final String key;

  private final String name;

  private final String description;

  private final String createdAt;

  private final String updatedAt;

  private final String attachment;

  private int _cachedHashCode;

  Variant(String id, String flagKey, String key, String name, String description, String createdAt,
      String updatedAt, String attachment) {
    this.id = id;
    this.flagKey = flagKey;
    this.key = key;
    this.name = name;
    this.description = description;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.attachment = attachment;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("flagKey")
  public String getFlagKey() {
    return flagKey;
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

  @JsonProperty("createdAt")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("updatedAt")
  public String getUpdatedAt() {
    return updatedAt;
  }

  @JsonProperty("attachment")
  public String getAttachment() {
    return attachment;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Variant && equalTo((Variant) other);
  }

  private boolean equalTo(Variant other) {
    return id.equals(other.id) && flagKey.equals(other.flagKey) && key.equals(other.key) && name.equals(other.name) && description.equals(other.description) && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt) && attachment.equals(other.attachment);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.flagKey, this.key, this.name, this.description, this.createdAt, this.updatedAt, this.attachment);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Variant{" + "id: " + id + ", flagKey: " + flagKey + ", key: " + key + ", name: " + name + ", description: " + description + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + ", attachment: " + attachment + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    FlagKeyStage id(String id);

    Builder from(Variant other);
  }

  public interface FlagKeyStage {
    KeyStage flagKey(String flagKey);
  }

  public interface KeyStage {
    NameStage key(String key);
  }

  public interface NameStage {
    DescriptionStage name(String name);
  }

  public interface DescriptionStage {
    CreatedAtStage description(String description);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    AttachmentStage updatedAt(String updatedAt);
  }

  public interface AttachmentStage {
    _FinalStage attachment(String attachment);
  }

  public interface _FinalStage {
    Variant build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdStage, FlagKeyStage, KeyStage, NameStage, DescriptionStage, CreatedAtStage, UpdatedAtStage, AttachmentStage, _FinalStage {
    private String id;

    private String flagKey;

    private String key;

    private String name;

    private String description;

    private String createdAt;

    private String updatedAt;

    private String attachment;

    private Builder() {
    }

    @Override
    public Builder from(Variant other) {
      id(other.getId());
      flagKey(other.getFlagKey());
      key(other.getKey());
      name(other.getName());
      description(other.getDescription());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      attachment(other.getAttachment());
      return this;
    }

    @Override
    @JsonSetter("id")
    public FlagKeyStage id(String id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("flagKey")
    public KeyStage flagKey(String flagKey) {
      this.flagKey = flagKey;
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
    public CreatedAtStage description(String description) {
      this.description = description;
      return this;
    }

    @Override
    @JsonSetter("createdAt")
    public UpdatedAtStage createdAt(String createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    @Override
    @JsonSetter("updatedAt")
    public AttachmentStage updatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    @JsonSetter("attachment")
    public _FinalStage attachment(String attachment) {
      this.attachment = attachment;
      return this;
    }

    @Override
    public Variant build() {
      return new Variant(id, flagKey, key, name, description, createdAt, updatedAt, attachment);
    }
  }
}
