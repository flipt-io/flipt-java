/**
 */
package com.flipt.api.resources.rules.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.core.ObjectMappers;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RuleUpdateRequest.Builder.class)
public final class RuleUpdateRequest {
    private final String segmentKey;

    private final Optional<List<String>> segmentKeys;

    private final Optional<RuleSegmentOperator> segmentOperator;

    private RuleUpdateRequest(
            String segmentKey, Optional<List<String>> segmentKeys, Optional<RuleSegmentOperator> segmentOperator) {
        this.segmentKey = segmentKey;
        this.segmentKeys = segmentKeys;
        this.segmentOperator = segmentOperator;
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
    public Optional<RuleSegmentOperator> getSegmentOperator() {
        return segmentOperator;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RuleUpdateRequest && equalTo((RuleUpdateRequest) other);
    }

    private boolean equalTo(RuleUpdateRequest other) {
        return segmentKey.equals(other.segmentKey)
                && segmentKeys.equals(other.segmentKeys)
                && segmentOperator.equals(other.segmentOperator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.segmentKey, this.segmentKeys, this.segmentOperator);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SegmentKeyStage builder() {
        return new Builder();
    }

    public interface SegmentKeyStage {
        _FinalStage segmentKey(String segmentKey);

        Builder from(RuleUpdateRequest other);
    }

    public interface _FinalStage {
        RuleUpdateRequest build();

        _FinalStage segmentKeys(Optional<List<String>> segmentKeys);

        _FinalStage segmentKeys(List<String> segmentKeys);

        _FinalStage segmentOperator(Optional<RuleSegmentOperator> segmentOperator);

        _FinalStage segmentOperator(RuleSegmentOperator segmentOperator);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SegmentKeyStage, _FinalStage {
        private String segmentKey;

        private Optional<RuleSegmentOperator> segmentOperator = Optional.empty();

        private Optional<List<String>> segmentKeys = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RuleUpdateRequest other) {
            segmentKey(other.getSegmentKey());
            segmentKeys(other.getSegmentKeys());
            segmentOperator(other.getSegmentOperator());
            return this;
        }

        @Override
        @JsonSetter("segmentKey")
        public _FinalStage segmentKey(String segmentKey) {
            this.segmentKey = segmentKey;
            return this;
        }

        @Override
        public _FinalStage segmentOperator(RuleSegmentOperator segmentOperator) {
            this.segmentOperator = Optional.of(segmentOperator);
            return this;
        }

        @Override
        @JsonSetter(value = "segmentOperator", nulls = Nulls.SKIP)
        public _FinalStage segmentOperator(Optional<RuleSegmentOperator> segmentOperator) {
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
        public RuleUpdateRequest build() {
            return new RuleUpdateRequest(segmentKey, segmentKeys, segmentOperator);
        }
    }
}
