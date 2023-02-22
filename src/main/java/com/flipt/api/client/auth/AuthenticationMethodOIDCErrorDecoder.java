package com.flipt.api.client.auth;

import com.flipt.api.client.auth.exceptions.AuthorizeUrlException;
import com.flipt.api.client.auth.exceptions.CallbackException;
import com.flipt.api.core.ObjectMappers;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class AuthenticationMethodOIDCErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("authorizeURL")) {
        return decodeException(response, AuthorizeUrlException.class);
      }
      if (methodKey.contains("callback")) {
        return decodeException(response, CallbackException.class);
      }
    }
    catch (IOException e) {
    }
    return new RuntimeException("Failed to read response body. Received status " + response.status() + " for method " + methodKey);
  }

  private static <T extends Exception> Exception decodeException(Response response, Class<T> clazz)
      throws IOException {
    return ObjectMappers.JSON_MAPPER.reader().withAttribute("statusCode", response.status()).readValue(response.body().asInputStream(), clazz);
  }
}
