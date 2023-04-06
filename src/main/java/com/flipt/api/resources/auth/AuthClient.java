package com.flipt.api.resources.auth;

import com.flipt.api.resources.auth.requests.AuthenticationExpireSelfRequest;
import com.flipt.api.resources.auth.types.Authentication;
import com.flipt.api.resources.auth.types.AuthenticationList;
import java.lang.String;

public interface AuthClient {
  AuthenticationList listTokens();

  Authentication getToken(String id);

  void deleteToken(String id);

  Authentication getSelf();

  void expireSelf(AuthenticationExpireSelfRequest request);
}
