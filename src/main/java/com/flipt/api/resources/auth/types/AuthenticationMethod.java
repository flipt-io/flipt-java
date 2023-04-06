package com.flipt.api.resources.auth.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class AuthenticationMethod {
  public static final AuthenticationMethod METHOD_OIDC = new AuthenticationMethod(Value.METHOD_OIDC, "METHOD_OIDC");

  public static final AuthenticationMethod METHOD_NONE = new AuthenticationMethod(Value.METHOD_NONE, "METHOD_NONE");

  public static final AuthenticationMethod METHOD_KUBERNETES = new AuthenticationMethod(Value.METHOD_KUBERNETES, "METHOD_KUBERNETES");

  public static final AuthenticationMethod METHOD_TOKEN = new AuthenticationMethod(Value.METHOD_TOKEN, "METHOD_TOKEN");

  private final Value value;

  private final String string;

  AuthenticationMethod(Value value, String string) {
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
      || (other instanceof AuthenticationMethod && this.string.equals(((AuthenticationMethod) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case METHOD_OIDC:
        return visitor.visitMethodOidc();
      case METHOD_NONE:
        return visitor.visitMethodNone();
      case METHOD_KUBERNETES:
        return visitor.visitMethodKubernetes();
      case METHOD_TOKEN:
        return visitor.visitMethodToken();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static AuthenticationMethod valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "METHOD_OIDC":
        return METHOD_OIDC;
      case "METHOD_NONE":
        return METHOD_NONE;
      case "METHOD_KUBERNETES":
        return METHOD_KUBERNETES;
      case "METHOD_TOKEN":
        return METHOD_TOKEN;
      default:
        return new AuthenticationMethod(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    METHOD_NONE,

    METHOD_TOKEN,

    METHOD_OIDC,

    METHOD_KUBERNETES,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitMethodNone();

    T visitMethodToken();

    T visitMethodOidc();

    T visitMethodKubernetes();

    T visitUnknown(String unknownType);
  }
}
