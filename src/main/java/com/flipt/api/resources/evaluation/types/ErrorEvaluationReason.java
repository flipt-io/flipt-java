package com.flipt.api.resources.evaluation.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class ErrorEvaluationReason {
  public static final ErrorEvaluationReason UNKNOWN_ERROR_EVALUATION_REASON = new ErrorEvaluationReason(Value.UNKNOWN_ERROR_EVALUATION_REASON, "UNKNOWN_ERROR_EVALUATION_REASON");

  public static final ErrorEvaluationReason NOT_FOUND_ERROR_EVALUATION_REASON = new ErrorEvaluationReason(Value.NOT_FOUND_ERROR_EVALUATION_REASON, "NOT_FOUND_ERROR_EVALUATION_REASON");

  private final Value value;

  private final String string;

  ErrorEvaluationReason(Value value, String string) {
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
      || (other instanceof ErrorEvaluationReason && this.string.equals(((ErrorEvaluationReason) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case UNKNOWN_ERROR_EVALUATION_REASON:
        return visitor.visitUnknownErrorEvaluationReason();
      case NOT_FOUND_ERROR_EVALUATION_REASON:
        return visitor.visitNotFoundErrorEvaluationReason();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static ErrorEvaluationReason valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "UNKNOWN_ERROR_EVALUATION_REASON":
        return UNKNOWN_ERROR_EVALUATION_REASON;
      case "NOT_FOUND_ERROR_EVALUATION_REASON":
        return NOT_FOUND_ERROR_EVALUATION_REASON;
      default:
        return new ErrorEvaluationReason(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    UNKNOWN_ERROR_EVALUATION_REASON,

    NOT_FOUND_ERROR_EVALUATION_REASON,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitUnknownErrorEvaluationReason();

    T visitNotFoundErrorEvaluationReason();

    T visitUnknown(String unknownType);
  }
}
