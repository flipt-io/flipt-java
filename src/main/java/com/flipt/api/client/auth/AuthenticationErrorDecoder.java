package com.flipt.api.client.auth;

import com.flipt.api.client.auth.exceptions.CreateTokenException;
import com.flipt.api.client.auth.exceptions.DeleteTokenException;
import com.flipt.api.client.auth.exceptions.ExpireSelfException;
import com.flipt.api.client.auth.exceptions.GetSelfException;
import com.flipt.api.client.auth.exceptions.GetTokenException;
import com.flipt.api.client.auth.exceptions.ListTokensException;
import com.flipt.api.core.ObjectMappers;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class AuthenticationErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("listTokens")) {
        return decodeException(response, ListTokensException.class);
      }
      if (methodKey.contains("getToken")) {
        return decodeException(response, GetTokenException.class);
      }
      if (methodKey.contains("deleteToken")) {
        return decodeException(response, DeleteTokenException.class);
      }
      if (methodKey.contains("getSelf")) {
        return decodeException(response, GetSelfException.class);
      }
      if (methodKey.contains("expireSelf")) {
        return decodeException(response, ExpireSelfException.class);
      }
      if (methodKey.contains("createToken")) {
        return decodeException(response, CreateTokenException.class);
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
