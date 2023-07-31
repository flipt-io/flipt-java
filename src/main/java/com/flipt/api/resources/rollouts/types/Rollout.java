package com.flipt.api.resources.rollouts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Rollout.Builder.class
)
public final class Rollout {
  private final String id;

  private final String namespaceKey;

  private final String flagKey;

  private final RolloutType type;

  private final int rank;

  private final String description;

  private final String createdAt;

  private final String updatedAt;

  private final Optional<RolloutSegment> segment;

  private final Optional<RolloutThreshold> threshold;

  private int _cachedHashCode;

  Rollout(String id, String namespaceKey, String flagKey, RolloutType type, int rank,
      String description, String createdAt, String updatedAt, Optional<RolloutSegment> segment,
      Optional<RolloutThreshold> threshold) {
    this.id = id;
    this.namespaceKey = namespaceKey;
    this.flagKey = flagKey;
    this.type = type;
    this.rank = rank;
    this.description = description;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.segment = segment;
    this.threshold = threshold;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("namespaceKey")
  public String getNamespaceKey() {
    return namespaceKey;
  }

  @JsonProperty("flagKey")
  public String getFlagKey() {
    return flagKey;
  }

  @JsonProperty("type")
  public RolloutType getType() {
    return type;
  }

  @JsonProperty("rank")
  public int getRank() {
    return rank;
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

  @JsonProperty("segment")
  public Optional<RolloutSegment> getSegment() {
    return segment;
  }

  @JsonProperty("threshold")
  public Optional<RolloutThreshold> getThreshold() {
    return threshold;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Rollout && equalTo((Rollout) other);
  }

  private boolean equalTo(Rollout other) {
    return id.equals(other.id) && namespaceKey.equals(other.namespaceKey) && flagKey.equals(other.flagKey) && type.equals(other.type) && rank == other.rank && description.equals(other.description) && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt) && segment.equals(other.segment) && threshold.equals(other.threshold);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.namespaceKey, this.flagKey, this.type, this.rank, this.description, this.createdAt, this.updatedAt, this.segment, this.threshold);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Rollout{" + "id: " + id + ", namespaceKey: " + namespaceKey + ", flagKey: " + flagKey + ", type: " + type + ", rank: " + rank + ", description: " + description + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + ", segment: " + segment + ", threshold: " + threshold + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    NamespaceKeyStage id(String id);

    Builder from(Rollout other);
  }

  public interface NamespaceKeyStage {
    FlagKeyStage namespaceKey(String namespaceKey);
  }

  public interface FlagKeyStage {
    TypeStage flagKey(String flagKey);
  }

  public interface TypeStage {
    RankStage type(RolloutType type);
  }

  public interface RankStage {
    DescriptionStage rank(int rank);
  }

  public interface DescriptionStage {
    CreatedAtStage description(String description);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    _FinalStage updatedAt(String updatedAt);
  }

  public interface _FinalStage {
    Rollout build();

    _FinalStage segment(Optional<RolloutSegment> segment);

    _FinalStage segment(RolloutSegment segment);

    _FinalStage threshold(Optional<RolloutThreshold> threshold);

    _FinalStage threshold(RolloutThreshold threshold);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdStage, NamespaceKeyStage, FlagKeyStage, TypeStage, RankStage, DescriptionStage, CreatedAtStage, UpdatedAtStage, _FinalStage {
    private String id;

    private String namespaceKey;

    private String flagKey;

    private RolloutType type;

    private int rank;

    private String description;

    private String createdAt;

    private String updatedAt;

    private Optional<RolloutThreshold> threshold = Optional.empty();

    private Optional<RolloutSegment> segment = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Rollout other) {
      id(other.getId());
      namespaceKey(other.getNamespaceKey());
      flagKey(other.getFlagKey());
      type(other.getType());
      rank(other.getRank());
      description(other.getDescription());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      segment(other.getSegment());
      threshold(other.getThreshold());
      return this;
    }

    @Override
    @JsonSetter("id")
    public NamespaceKeyStage id(String id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("namespaceKey")
    public FlagKeyStage namespaceKey(String namespaceKey) {
      this.namespaceKey = namespaceKey;
      return this;
    }

    @Override
    @JsonSetter("flagKey")
    public TypeStage flagKey(String flagKey) {
      this.flagKey = flagKey;
      return this;
    }

    @Override
    @JsonSetter("type")
    public RankStage type(RolloutType type) {
      this.type = type;
      return this;
    }

    @Override
    @JsonSetter("rank")
    public DescriptionStage rank(int rank) {
      this.rank = rank;
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
    public _FinalStage updatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    public _FinalStage threshold(RolloutThreshold threshold) {
      this.threshold = Optional.of(threshold);
      return this;
    }

    @Override
    @JsonSetter(
        value = "threshold",
        nulls = Nulls.SKIP
    )
    public _FinalStage threshold(Optional<RolloutThreshold> threshold) {
      this.threshold = threshold;
      return this;
    }

    @Override
    public _FinalStage segment(RolloutSegment segment) {
      this.segment = Optional.of(segment);
      return this;
    }

    @Override
    @JsonSetter(
        value = "segment",
        nulls = Nulls.SKIP
    )
    public _FinalStage segment(Optional<RolloutSegment> segment) {
      this.segment = segment;
      return this;
    }

    @Override
    public Rollout build() {
      return new Rollout(id, namespaceKey, flagKey, type, rank, description, createdAt, updatedAt, segment, threshold);
    }
  }
}
