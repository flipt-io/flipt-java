package com.flipt.api.client.evaluate.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class FliptEvaluationReason {
  public static final FliptEvaluationReason FLAG_DISABLED_EVALUATION_REASON = new FliptEvaluationReason(Value.FLAG_DISABLED_EVALUATION_REASON, "FLAG_DISABLED_EVALUATION_REASON");

  public static final FliptEvaluationReason ERROR_EVALUATION_REASON = new FliptEvaluationReason(Value.ERROR_EVALUATION_REASON, "ERROR_EVALUATION_REASON");

  public static final FliptEvaluationReason UNKNOWN_EVALUATION_REASON = new FliptEvaluationReason(Value.UNKNOWN_EVALUATION_REASON, "UNKNOWN_EVALUATION_REASON");

  public static final FliptEvaluationReason FLAG_NOT_FOUND_EVALUATION_REASON = new FliptEvaluationReason(Value.FLAG_NOT_FOUND_EVALUATION_REASON, "FLAG_NOT_FOUND_EVALUATION_REASON");

  public static final FliptEvaluationReason MATCH_EVALUATION_REASON = new FliptEvaluationReason(Value.MATCH_EVALUATION_REASON, "MATCH_EVALUATION_REASON");

  private final Value value;

  private final String string;

  FliptEvaluationReason(Value value, String string) {
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
      || (other instanceof FliptEvaluationReason && this.string.equals(((FliptEvaluationReason) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case FLAG_DISABLED_EVALUATION_REASON:
        return visitor.visitFlagDisabledEvaluationReason();
      case ERROR_EVALUATION_REASON:
        return visitor.visitErrorEvaluationReason();
      case UNKNOWN_EVALUATION_REASON:
        return visitor.visitUnknownEvaluationReason();
      case FLAG_NOT_FOUND_EVALUATION_REASON:
        return visitor.visitFlagNotFoundEvaluationReason();
      case MATCH_EVALUATION_REASON:
        return visitor.visitMatchEvaluationReason();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static FliptEvaluationReason valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "FLAG_DISABLED_EVALUATION_REASON":
        return FLAG_DISABLED_EVALUATION_REASON;
      case "ERROR_EVALUATION_REASON":
        return ERROR_EVALUATION_REASON;
      case "UNKNOWN_EVALUATION_REASON":
        return UNKNOWN_EVALUATION_REASON;
      case "FLAG_NOT_FOUND_EVALUATION_REASON":
        return FLAG_NOT_FOUND_EVALUATION_REASON;
      case "MATCH_EVALUATION_REASON":
        return MATCH_EVALUATION_REASON;
      default:
        return new FliptEvaluationReason(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    UNKNOWN_EVALUATION_REASON,

    FLAG_DISABLED_EVALUATION_REASON,

    FLAG_NOT_FOUND_EVALUATION_REASON,

    MATCH_EVALUATION_REASON,

    ERROR_EVALUATION_REASON,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitUnknownEvaluationReason();

    T visitFlagDisabledEvaluationReason();

    T visitFlagNotFoundEvaluationReason();

    T visitMatchEvaluationReason();

    T visitErrorEvaluationReason();

    T visitUnknown(String unknownType);
  }
}
