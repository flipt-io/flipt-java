package com.flipt.api.client.segments.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class SegmentMatchType {
  public static final SegmentMatchType ANY_MATCH_TYPE = new SegmentMatchType(Value.ANY_MATCH_TYPE, "ANY_MATCH_TYPE");

  public static final SegmentMatchType ALL_MATCH_TYPE = new SegmentMatchType(Value.ALL_MATCH_TYPE, "ALL_MATCH_TYPE");

  private final Value value;

  private final String string;

  SegmentMatchType(Value value, String string) {
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
      || (other instanceof SegmentMatchType && this.string.equals(((SegmentMatchType) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case ANY_MATCH_TYPE:
        return visitor.visitAnyMatchType();
      case ALL_MATCH_TYPE:
        return visitor.visitAllMatchType();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static SegmentMatchType valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "ANY_MATCH_TYPE":
        return ANY_MATCH_TYPE;
      case "ALL_MATCH_TYPE":
        return ALL_MATCH_TYPE;
      default:
        return new SegmentMatchType(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    ALL_MATCH_TYPE,

    ANY_MATCH_TYPE,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitAllMatchType();

    T visitAnyMatchType();

    T visitUnknown(String unknownType);
  }
}
