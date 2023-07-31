package com.flipt.api.resources.flags.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class FlagType {
  public static final FlagType VARIANT_FLAG_TYPE = new FlagType(Value.VARIANT_FLAG_TYPE, "VARIANT_FLAG_TYPE");

  public static final FlagType BOOLEAN_FLAG_TYPE = new FlagType(Value.BOOLEAN_FLAG_TYPE, "BOOLEAN_FLAG_TYPE");

  private final Value value;

  private final String string;

  FlagType(Value value, String string) {
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
      || (other instanceof FlagType && this.string.equals(((FlagType) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case VARIANT_FLAG_TYPE:
        return visitor.visitVariantFlagType();
      case BOOLEAN_FLAG_TYPE:
        return visitor.visitBooleanFlagType();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static FlagType valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "VARIANT_FLAG_TYPE":
        return VARIANT_FLAG_TYPE;
      case "BOOLEAN_FLAG_TYPE":
        return BOOLEAN_FLAG_TYPE;
      default:
        return new FlagType(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    VARIANT_FLAG_TYPE,

    BOOLEAN_FLAG_TYPE,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitVariantFlagType();

    T visitBooleanFlagType();

    T visitUnknown(String unknownType);
  }
}
