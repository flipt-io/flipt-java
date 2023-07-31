package com.flipt.api.resources.evaluation.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class EvaluationResponseType {
  public static final EvaluationResponseType VARIANT_EVALUATION_RESPONSE_TYPE = new EvaluationResponseType(Value.VARIANT_EVALUATION_RESPONSE_TYPE, "VARIANT_EVALUATION_RESPONSE_TYPE");

  public static final EvaluationResponseType ERROR_EVALUATION_RESPONSE_TYPE = new EvaluationResponseType(Value.ERROR_EVALUATION_RESPONSE_TYPE, "ERROR_EVALUATION_RESPONSE_TYPE");

  public static final EvaluationResponseType BOOLEAN_EVALUATION_RESPONSE_TYPE = new EvaluationResponseType(Value.BOOLEAN_EVALUATION_RESPONSE_TYPE, "BOOLEAN_EVALUATION_RESPONSE_TYPE");

  private final Value value;

  private final String string;

  EvaluationResponseType(Value value, String string) {
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
      || (other instanceof EvaluationResponseType && this.string.equals(((EvaluationResponseType) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case VARIANT_EVALUATION_RESPONSE_TYPE:
        return visitor.visitVariantEvaluationResponseType();
      case ERROR_EVALUATION_RESPONSE_TYPE:
        return visitor.visitErrorEvaluationResponseType();
      case BOOLEAN_EVALUATION_RESPONSE_TYPE:
        return visitor.visitBooleanEvaluationResponseType();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static EvaluationResponseType valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "VARIANT_EVALUATION_RESPONSE_TYPE":
        return VARIANT_EVALUATION_RESPONSE_TYPE;
      case "ERROR_EVALUATION_RESPONSE_TYPE":
        return ERROR_EVALUATION_RESPONSE_TYPE;
      case "BOOLEAN_EVALUATION_RESPONSE_TYPE":
        return BOOLEAN_EVALUATION_RESPONSE_TYPE;
      default:
        return new EvaluationResponseType(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    VARIANT_EVALUATION_RESPONSE_TYPE,

    BOOLEAN_EVALUATION_RESPONSE_TYPE,

    ERROR_EVALUATION_RESPONSE_TYPE,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitVariantEvaluationResponseType();

    T visitBooleanEvaluationResponseType();

    T visitErrorEvaluationResponseType();

    T visitUnknown(String unknownType);
  }
}
