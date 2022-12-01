package com.flipt.api.client.constraints.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class ConstraintComparisonType {
  public static final ConstraintComparisonType NUMBER_COMPARISON_TYPE = new ConstraintComparisonType(Value.NUMBER_COMPARISON_TYPE, "NUMBER_COMPARISON_TYPE");

  public static final ConstraintComparisonType UNKNOWN_COMPARISON_TYPE = new ConstraintComparisonType(Value.UNKNOWN_COMPARISON_TYPE, "UNKNOWN_COMPARISON_TYPE");

  public static final ConstraintComparisonType STRING_COMPARISON_TYPE = new ConstraintComparisonType(Value.STRING_COMPARISON_TYPE, "STRING_COMPARISON_TYPE");

  public static final ConstraintComparisonType BOOLEAN_COMPARISON_TYPE = new ConstraintComparisonType(Value.BOOLEAN_COMPARISON_TYPE, "BOOLEAN_COMPARISON_TYPE");

  private final Value value;

  private final String string;

  ConstraintComparisonType(Value value, String string) {
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
      || (other instanceof ConstraintComparisonType && this.string.equals(((ConstraintComparisonType) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case NUMBER_COMPARISON_TYPE:
        return visitor.visitNumberComparisonType();
      case UNKNOWN_COMPARISON_TYPE:
        return visitor.visitUnknownComparisonType();
      case STRING_COMPARISON_TYPE:
        return visitor.visitStringComparisonType();
      case BOOLEAN_COMPARISON_TYPE:
        return visitor.visitBooleanComparisonType();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static ConstraintComparisonType valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "NUMBER_COMPARISON_TYPE":
        return NUMBER_COMPARISON_TYPE;
      case "UNKNOWN_COMPARISON_TYPE":
        return UNKNOWN_COMPARISON_TYPE;
      case "STRING_COMPARISON_TYPE":
        return STRING_COMPARISON_TYPE;
      case "BOOLEAN_COMPARISON_TYPE":
        return BOOLEAN_COMPARISON_TYPE;
      default:
        return new ConstraintComparisonType(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    UNKNOWN_COMPARISON_TYPE,

    STRING_COMPARISON_TYPE,

    NUMBER_COMPARISON_TYPE,

    BOOLEAN_COMPARISON_TYPE,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitUnknownComparisonType();

    T visitStringComparisonType();

    T visitNumberComparisonType();

    T visitBooleanComparisonType();

    T visitUnknown(String unknownType);
  }
}
