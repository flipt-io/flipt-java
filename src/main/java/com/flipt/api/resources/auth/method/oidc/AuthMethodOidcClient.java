package com.flipt.api.resources.auth.method.oidc;

import com.flipt.api.resources.auth.method.oidc.requests.OidcAuthorizeUrlRequest;
import com.flipt.api.resources.auth.method.oidc.requests.OidcCallbackRequest;
import com.flipt.api.resources.auth.method.oidc.types.OidcAuthorizeUrlResponse;
import com.flipt.api.resources.auth.method.oidc.types.OidcCallbackResponse;
import java.lang.String;

public interface AuthMethodOidcClient {
  OidcAuthorizeUrlResponse authorizeUrl(String provider, OidcAuthorizeUrlRequest request);

  OidcCallbackResponse callback(String provider, OidcCallbackRequest request);
}
