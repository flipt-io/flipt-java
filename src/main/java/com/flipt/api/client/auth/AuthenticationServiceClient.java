package com.flipt.api.client.auth;

import com.flipt.api.client.auth.endpoints.CreateToken;
import com.flipt.api.client.auth.endpoints.DeleteToken;
import com.flipt.api.client.auth.endpoints.GetSelf;
import com.flipt.api.client.auth.endpoints.GetToken;
import com.flipt.api.client.auth.endpoints.ListTokens;
import com.flipt.api.client.auth.exceptions.CreateTokenException;
import com.flipt.api.client.auth.exceptions.DeleteTokenException;
import com.flipt.api.client.auth.exceptions.GetSelfException;
import com.flipt.api.client.auth.exceptions.GetTokenException;
import com.flipt.api.client.auth.exceptions.ListTokensException;
import com.flipt.api.client.auth.types.Authentication;
import com.flipt.api.client.auth.types.AuthenticationList;
import com.flipt.api.client.auth.types.AuthenticationToken;
import com.flipt.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class AuthenticationServiceClient {
  private final AuthenticationService service;

  private final Optional<BasicAuth> auth;

  public AuthenticationServiceClient(String url) {
    this.service = AuthenticationService.getClient(url);
    this.auth = Optional.empty();
  }

  public AuthenticationServiceClient(String url, BasicAuth auth) {
    this.service = AuthenticationService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public AuthenticationList listTokens(ListTokens.Request request) throws ListTokensException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for listTokens")));
    return this.service.listTokens(authValue);
  }

  public Authentication getToken(GetToken.Request request) throws GetTokenException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getToken")));
    return this.service.getToken(authValue, request.getId());
  }

  public AuthenticationToken createToken(CreateToken.Request request) throws CreateTokenException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for createToken")));
    return this.service.createToken(authValue, request.getBody());
  }

  public void deleteToken(DeleteToken.Request request) throws DeleteTokenException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for deleteToken")));
    this.service.deleteToken(authValue, request.getId());
  }

  public Authentication getSelf(GetSelf.Request request) throws GetSelfException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for getSelf")));
    return this.service.getSelf(authValue);
  }
}
