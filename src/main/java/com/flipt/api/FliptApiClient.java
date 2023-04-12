package com.flipt.api;

import com.flipt.api.core.Environment;
import com.flipt.api.resources.auth.AuthClient;
import com.flipt.api.resources.authmethodk8s.AuthMethodK8SClient;
import com.flipt.api.resources.authmethodoidc.AuthMethodOidcClient;
import com.flipt.api.resources.authmethodtoken.AuthMethodTokenClient;
import com.flipt.api.resources.constraints.ConstraintsClient;
import com.flipt.api.resources.distributions.DistributionsClient;
import com.flipt.api.resources.evaluate.EvaluateClient;
import com.flipt.api.resources.flags.FlagsClient;
import com.flipt.api.resources.namespaces.NamespacesClient;
import com.flipt.api.resources.rules.RulesClient;
import com.flipt.api.resources.segments.SegmentsClient;
import com.flipt.api.resources.variants.VariantsClient;
import java.lang.String;

public interface FliptApiClient {
  AuthMethodK8SClient authMethodK8S();

  AuthMethodOidcClient authMethodOidc();

  AuthMethodTokenClient authMethodToken();

  AuthClient auth();

  ConstraintsClient constraints();

  DistributionsClient distributions();

  EvaluateClient evaluate();

  FlagsClient flags();

  NamespacesClient namespaces();

  RulesClient rules();

  SegmentsClient segments();

  VariantsClient variants();

  static Builder builder() {
    return new FliptApiClientImpl.Builder();
  }

  interface Builder {
    Builder token(String token);

    Builder environment(Environment environment);

    Builder url(String url);

    FliptApiClient build();
  }
}
