package com.flipt.api.client.auth;

import com.flipt.api.client.auth.endpoints.AuthorizeUrl;
import com.flipt.api.client.auth.endpoints.Callback;
import com.flipt.api.client.auth.exceptions.AuthorizeUrlException;
import com.flipt.api.client.auth.exceptions.CallbackException;
import com.flipt.api.client.auth.types.OidcAuthorizeUrlResponse;
import com.flipt.api.client.auth.types.OidcCallbackResponse;
import java.lang.String;

public final class AuthenticationMethodOIDCClient {
  private final AuthenticationMethodOIDC service;

  public AuthenticationMethodOIDCClient(String url) {
    this.service = AuthenticationMethodOIDC.getClient(url);
  }

  public OidcAuthorizeUrlResponse authorizeURL(AuthorizeUrl.Request request) throws
      AuthorizeUrlException {
    return this.service.authorizeUrl(request.getProvider(), request.getState());
  }

  public OidcCallbackResponse callback(Callback.Request request) throws CallbackException {
    return this.service.callback(request.getProvider(), request.getCode(), request.getState());
  }
}
