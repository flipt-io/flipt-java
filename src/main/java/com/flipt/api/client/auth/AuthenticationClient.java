package com.flipt.api.client.auth;

import com.flipt.api.client.auth.endpoints.CreateToken;
import com.flipt.api.client.auth.endpoints.DeleteToken;
import com.flipt.api.client.auth.endpoints.ExpireSelf;
import com.flipt.api.client.auth.endpoints.GetSelf;
import com.flipt.api.client.auth.endpoints.GetToken;
import com.flipt.api.client.auth.endpoints.ListTokens;
import com.flipt.api.client.auth.exceptions.CreateTokenException;
import com.flipt.api.client.auth.exceptions.DeleteTokenException;
import com.flipt.api.client.auth.exceptions.ExpireSelfException;
import com.flipt.api.client.auth.exceptions.GetSelfException;
import com.flipt.api.client.auth.exceptions.GetTokenException;
import com.flipt.api.client.auth.exceptions.ListTokensException;
import com.flipt.api.client.auth.types.AuthenticationList;
import com.flipt.api.client.auth.types.AuthenticationToken;
import com.flipt.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class AuthenticationClient {
  private final Authentication service;

  private final Optional<BearerAuth> auth;

  public AuthenticationClient(String url) {
    this.service = Authentication.getClient(url);
    this.auth = Optional.empty();
  }

  public AuthenticationClient(String url, BearerAuth auth) {
    this.service = Authentication.getClient(url);
    this.auth = Optional.of(auth);
  }

  public AuthenticationList listTokens(ListTokens.Request request) throws ListTokensException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.listTokens(authValue);
  }

  public com.flipt.api.client.auth.types.Authentication getToken(GetToken.Request request) throws
      GetTokenException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.getToken(authValue, request.getId());
  }

  public void deleteToken(DeleteToken.Request request) throws DeleteTokenException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.deleteToken(authValue, request.getId());
  }

  public com.flipt.api.client.auth.types.Authentication getSelf(GetSelf.Request request) throws
      GetSelfException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.getSelf(authValue);
  }

  public void expireSelf(ExpireSelf.Request request) throws ExpireSelfException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.expireSelf(authValue, request.getBody());
  }

  public AuthenticationToken createToken(CreateToken.Request request) throws CreateTokenException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.createToken(authValue, request.getBody());
  }
}
