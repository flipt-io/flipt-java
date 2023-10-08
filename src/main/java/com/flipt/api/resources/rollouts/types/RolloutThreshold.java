/**
 */
package com.flipt.api.resources.rollouts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RolloutThreshold.Builder.class)
public final class RolloutThreshold {
    private final double percentage;

    private final boolean value;

    private RolloutThreshold(double percentage, boolean value) {
        this.percentage = percentage;
        this.value = value;
    }

    @JsonProperty("percentage")
    public double getPercentage() {
        return percentage;
    }

    @JsonProperty("value")
    public boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RolloutThreshold && equalTo((RolloutThreshold) other);
    }

    private boolean equalTo(RolloutThreshold other) {
        return percentage == other.percentage && value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.percentage, this.value);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PercentageStage builder() {
        return new Builder();
    }

    public interface PercentageStage {
        ValueStage percentage(double percentage);

        Builder from(RolloutThreshold other);
    }

    public interface ValueStage {
        _FinalStage value(boolean value);
    }

    public interface _FinalStage {
        RolloutThreshold build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PercentageStage, ValueStage, _FinalStage {
        private double percentage;

        private boolean value;

        private Builder() {}

        @Override
        public Builder from(RolloutThreshold other) {
            percentage(other.getPercentage());
            value(other.getValue());
            return this;
        }

        @Override
        @JsonSetter("percentage")
        public ValueStage percentage(double percentage) {
            this.percentage = percentage;
            return this;
        }

        @Override
        @JsonSetter("value")
        public _FinalStage value(boolean value) {
            this.value = value;
            return this;
        }

        @Override
        public RolloutThreshold build() {
            return new RolloutThreshold(percentage, value);
        }
    }
}
