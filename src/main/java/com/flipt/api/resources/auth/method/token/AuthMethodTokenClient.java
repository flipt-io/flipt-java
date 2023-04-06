package com.flipt.api.resources.auth.method.token;

import com.flipt.api.resources.auth.method.token.requests.AuthenticationTokenCreateRequest;
import com.flipt.api.resources.auth.types.AuthenticationToken;

public interface AuthMethodTokenClient {
  AuthenticationToken createToken(AuthenticationTokenCreateRequest request);
}
