package com.flipt.api;

import com.flipt.api.core.Environment;
import com.flipt.api.resources.auth.AuthClient;
import com.flipt.api.resources.auth.method.k.8.s.AuthMethodK8SClient;
import com.flipt.api.resources.auth.method.oidc.AuthMethodOidcClient;
import com.flipt.api.resources.auth.method.token.AuthMethodTokenClient;
import com.flipt.api.resources.constraints.ConstraintsClient;
import com.flipt.api.resources.distributions.DistributionsClient;
import com.flipt.api.resources.evaluate.EvaluateClient;
import com.flipt.api.resources.flags.FlagsClient;
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
