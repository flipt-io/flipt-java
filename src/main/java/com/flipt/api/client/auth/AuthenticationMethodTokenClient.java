package com.flipt.api.client.auth;

import com.flipt.api.client.auth.endpoints.CreateToken;
import com.flipt.api.client.auth.exceptions.CreateTokenException;
import com.flipt.api.client.auth.types.AuthenticationToken;
import com.flipt.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class AuthenticationMethodTokenClient {
  private final AuthenticationMethodToken service;

  private final Optional<BearerAuth> auth;

  public AuthenticationMethodTokenClient(String url) {
    this.service = AuthenticationMethodToken.getClient(url);
    this.auth = Optional.empty();
  }

  public AuthenticationMethodTokenClient(String url, BearerAuth auth) {
    this.service = AuthenticationMethodToken.getClient(url);
    this.auth = Optional.of(auth);
  }

  public AuthenticationToken createToken(CreateToken.Request request) throws CreateTokenException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.createToken(authValue, request.getBody());
  }
}
