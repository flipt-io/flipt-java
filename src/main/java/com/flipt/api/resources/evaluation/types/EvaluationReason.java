package com.flipt.api.resources.evaluation.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class EvaluationReason {
  public static final EvaluationReason DEFAULT_EVALUATION_REASON = new EvaluationReason(Value.DEFAULT_EVALUATION_REASON, "DEFAULT_EVALUATION_REASON");

  public static final EvaluationReason UNKNOWN_EVALUATION_REASON = new EvaluationReason(Value.UNKNOWN_EVALUATION_REASON, "UNKNOWN_EVALUATION_REASON");

  public static final EvaluationReason MATCH_EVALUATION_REASON = new EvaluationReason(Value.MATCH_EVALUATION_REASON, "MATCH_EVALUATION_REASON");

  public static final EvaluationReason FLAG_DISABLED_EVALUATION_REASON = new EvaluationReason(Value.FLAG_DISABLED_EVALUATION_REASON, "FLAG_DISABLED_EVALUATION_REASON");

  private final Value value;

  private final String string;

  EvaluationReason(Value value, String string) {
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
      || (other instanceof EvaluationReason && this.string.equals(((EvaluationReason) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case DEFAULT_EVALUATION_REASON:
        return visitor.visitDefaultEvaluationReason();
      case UNKNOWN_EVALUATION_REASON:
        return visitor.visitUnknownEvaluationReason();
      case MATCH_EVALUATION_REASON:
        return visitor.visitMatchEvaluationReason();
      case FLAG_DISABLED_EVALUATION_REASON:
        return visitor.visitFlagDisabledEvaluationReason();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static EvaluationReason valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "DEFAULT_EVALUATION_REASON":
        return DEFAULT_EVALUATION_REASON;
      case "UNKNOWN_EVALUATION_REASON":
        return UNKNOWN_EVALUATION_REASON;
      case "MATCH_EVALUATION_REASON":
        return MATCH_EVALUATION_REASON;
      case "FLAG_DISABLED_EVALUATION_REASON":
        return FLAG_DISABLED_EVALUATION_REASON;
      default:
        return new EvaluationReason(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    UNKNOWN_EVALUATION_REASON,

    FLAG_DISABLED_EVALUATION_REASON,

    MATCH_EVALUATION_REASON,

    DEFAULT_EVALUATION_REASON,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitUnknownEvaluationReason();

    T visitFlagDisabledEvaluationReason();

    T visitMatchEvaluationReason();

    T visitDefaultEvaluationReason();

    T visitUnknown(String unknownType);
  }
}
