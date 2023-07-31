package com.flipt.api.resources.rollouts.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class RolloutType {
  public static final RolloutType THRESHOLD_ROLLOUT_TYPE = new RolloutType(Value.THRESHOLD_ROLLOUT_TYPE, "THRESHOLD_ROLLOUT_TYPE");

  public static final RolloutType UNKNOWN_ROLLOUT_TYPE = new RolloutType(Value.UNKNOWN_ROLLOUT_TYPE, "UNKNOWN_ROLLOUT_TYPE");

  public static final RolloutType SEGMENT_ROLLOUT_TYPE = new RolloutType(Value.SEGMENT_ROLLOUT_TYPE, "SEGMENT_ROLLOUT_TYPE");

  private final Value value;

  private final String string;

  RolloutType(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (this == other) 
      || (other instanceof RolloutType && this.string.equals(((RolloutType) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case THRESHOLD_ROLLOUT_TYPE:
        return visitor.visitThresholdRolloutType();
      case UNKNOWN_ROLLOUT_TYPE:
        return visitor.visitUnknownRolloutType();
      case SEGMENT_ROLLOUT_TYPE:
        return visitor.visitSegmentRolloutType();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static RolloutType valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "THRESHOLD_ROLLOUT_TYPE":
        return THRESHOLD_ROLLOUT_TYPE;
      case "UNKNOWN_ROLLOUT_TYPE":
        return UNKNOWN_ROLLOUT_TYPE;
      case "SEGMENT_ROLLOUT_TYPE":
        return SEGMENT_ROLLOUT_TYPE;
      default:
        return new RolloutType(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    UNKNOWN_ROLLOUT_TYPE,

    SEGMENT_ROLLOUT_TYPE,

    THRESHOLD_ROLLOUT_TYPE,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitUnknownRolloutType();

    T visitSegmentRolloutType();

    T visitThresholdRolloutType();

    T visitUnknown(String unknownType);
  }
}
