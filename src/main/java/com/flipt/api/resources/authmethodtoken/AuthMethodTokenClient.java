package com.flipt.api.resources.authmethodtoken;

import com.flipt.api.resources.auth.types.AuthenticationToken;
import com.flipt.api.resources.authmethodtoken.requests.AuthenticationTokenCreateRequest;

public interface AuthMethodTokenClient {
  AuthenticationToken createToken(AuthenticationTokenCreateRequest request);
}
