package com.flipt.api.client.evaluate;

import com.flipt.api.client.evaluate.exceptions.BatchEvaluateException;
import com.flipt.api.client.evaluate.exceptions.EvaluateException;
import com.flipt.api.core.ObjectMappers;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class EvaluationErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("evaluate")) {
        return decodeException(response, EvaluateException.class);
      }
      if (methodKey.contains("batchEvaluate")) {
        return decodeException(response, BatchEvaluateException.class);
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
