package com.flipt.api.resources.rollouts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RolloutSegment.Builder.class)
public final class RolloutSegment {
    private final String segmentKey;

    private final Optional<List<String>> segmentKeys;

    private final Optional<RolloutSegmentOperator> segmentOperator;

    private final boolean value;

    private RolloutSegment(
            String segmentKey,
            Optional<List<String>> segmentKeys,
            Optional<RolloutSegmentOperator> segmentOperator,
            boolean value) {
        this.segmentKey = segmentKey;
        this.segmentKeys = segmentKeys;
        this.segmentOperator = segmentOperator;
        this.value = value;
    }

    @JsonProperty("segmentKey")
    public String getSegmentKey() {
        return segmentKey;
    }

    @JsonProperty("segmentKeys")
    public Optional<List<String>> getSegmentKeys() {
        return segmentKeys;
    }

    @JsonProperty("segmentOperator")
    public Optional<RolloutSegmentOperator> getSegmentOperator() {
        return segmentOperator;
    }

    @JsonProperty("value")
    public boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RolloutSegment && equalTo((RolloutSegment) other);
    }

    private boolean equalTo(RolloutSegment other) {
        return segmentKey.equals(other.segmentKey)
                && segmentKeys.equals(other.segmentKeys)
                && segmentOperator.equals(other.segmentOperator)
                && value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.segmentKey, this.segmentKeys, this.segmentOperator, this.value);
    }

    @Override
    public String toString() {
        return "RolloutSegment{" + "segmentKey: " + segmentKey + ", segmentKeys: " + segmentKeys + ", segmentOperator: "
                + segmentOperator + ", value: " + value + "}";
    }

    public static SegmentKeyStage builder() {
        return new Builder();
    }

    public interface SegmentKeyStage {
        ValueStage segmentKey(String segmentKey);

        Builder from(RolloutSegment other);
    }

    public interface ValueStage {
        _FinalStage value(boolean value);
    }

    public interface _FinalStage {
        RolloutSegment build();

        _FinalStage segmentKeys(Optional<List<String>> segmentKeys);

        _FinalStage segmentKeys(List<String> segmentKeys);

        _FinalStage segmentOperator(Optional<RolloutSegmentOperator> segmentOperator);

        _FinalStage segmentOperator(RolloutSegmentOperator segmentOperator);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SegmentKeyStage, ValueStage, _FinalStage {
        private String segmentKey;

        private boolean value;

        private Optional<RolloutSegmentOperator> segmentOperator = Optional.empty();

        private Optional<List<String>> segmentKeys = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RolloutSegment other) {
            segmentKey(other.getSegmentKey());
            segmentKeys(other.getSegmentKeys());
            segmentOperator(other.getSegmentOperator());
            value(other.getValue());
            return this;
        }

        @Override
        @JsonSetter("segmentKey")
        public ValueStage segmentKey(String segmentKey) {
            this.segmentKey = segmentKey;
            return this;
        }

        @Override
        @JsonSetter("value")
        public _FinalStage value(boolean value) {
            this.value = value;
            return this;
        }

        @Override
        public _FinalStage segmentOperator(RolloutSegmentOperator segmentOperator) {
            this.segmentOperator = Optional.of(segmentOperator);
            return this;
        }

        @Override
        @JsonSetter(value = "segmentOperator", nulls = Nulls.SKIP)
        public _FinalStage segmentOperator(Optional<RolloutSegmentOperator> segmentOperator) {
            this.segmentOperator = segmentOperator;
            return this;
        }

        @Override
        public _FinalStage segmentKeys(List<String> segmentKeys) {
            this.segmentKeys = Optional.of(segmentKeys);
            return this;
        }

        @Override
        @JsonSetter(value = "segmentKeys", nulls = Nulls.SKIP)
        public _FinalStage segmentKeys(Optional<List<String>> segmentKeys) {
            this.segmentKeys = segmentKeys;
            return this;
        }

        @Override
        public RolloutSegment build() {
            return new RolloutSegment(segmentKey, segmentKeys, segmentOperator, value);
        }
    }
}
