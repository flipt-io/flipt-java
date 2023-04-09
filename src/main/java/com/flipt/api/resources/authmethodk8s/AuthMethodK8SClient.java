package com.flipt.api.resources.authmethodk8s;

import com.flipt.api.resources.auth.types.AuthenticationToken;
import com.flipt.api.resources.authmethodk8s.requests.KubernetesVerifyServiceAccount;

public interface AuthMethodK8SClient {
  AuthenticationToken verifyServiceAccount(KubernetesVerifyServiceAccount request);
}
