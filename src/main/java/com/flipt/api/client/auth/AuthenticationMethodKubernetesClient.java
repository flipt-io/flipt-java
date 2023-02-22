package com.flipt.api.client.auth;

import com.flipt.api.client.auth.endpoints.VerifyServiceAccount;
import com.flipt.api.client.auth.exceptions.VerifyServiceAccountException;
import com.flipt.api.client.auth.types.AuthenticationToken;
import java.lang.String;

public final class AuthenticationMethodKubernetesClient {
  private final AuthenticationMethodKubernetes service;

  public AuthenticationMethodKubernetesClient(String url) {
    this.service = AuthenticationMethodKubernetes.getClient(url);
  }

  public AuthenticationToken verifyServiceAccount(VerifyServiceAccount.Request request) throws
      VerifyServiceAccountException {
    return this.service.verifyServiceAccount(request.getBody());
  }
}
