package com.flipt.api.resources.authmethodoidc;

import com.flipt.api.resources.authmethodoidc.requests.OidcAuthorizeUrlRequest;
import com.flipt.api.resources.authmethodoidc.requests.OidcCallbackRequest;
import com.flipt.api.resources.authmethodoidc.types.OidcAuthorizeUrlResponse;
import com.flipt.api.resources.authmethodoidc.types.OidcCallbackResponse;
import java.lang.String;

public interface AuthMethodOidcClient {
  OidcAuthorizeUrlResponse authorizeUrl(String provider, OidcAuthorizeUrlRequest request);

  OidcCallbackResponse callback(String provider, OidcCallbackRequest request);
}
