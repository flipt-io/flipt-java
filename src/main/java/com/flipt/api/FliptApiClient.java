package com.flipt.api;

import com.flipt.api.client.auth.AuthenticationClient;
import com.flipt.api.client.constraints.ConstraintsClient;
import com.flipt.api.client.distributions.DistributionsClient;
import com.flipt.api.client.evaluate.EvaluationClient;
import com.flipt.api.client.flags.FlagsClient;
import com.flipt.api.client.rules.RulesClient;
import com.flipt.api.client.segments.SegmentsClient;
import com.flipt.api.client.variants.VariantsClient;
import com.flipt.api.core.BearerAuth;
import com.flipt.api.core.Environment;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class FliptApiClient {
  private final Supplier<AuthenticationClient> authenticationClient;

  private final Supplier<ConstraintsClient> constraintsClient;

  private final Supplier<DistributionsClient> distributionsClient;

  private final Supplier<EvaluationClient> evaluationClient;

  private final Supplier<FlagsClient> flagsClient;

  private final Supplier<RulesClient> rulesClient;

  private final Supplier<SegmentsClient> segmentsClient;

  private final Supplier<VariantsClient> variantsClient;

  public FliptApiClient(BearerAuth auth) {
    this(Environment.PRODUCTION, auth);
  }

  public FliptApiClient(Environment environment, BearerAuth auth) {
    this.rulesClient = memoize(() -> new RulesClient(environment.getUrl(), auth));
    this.segmentsClient = memoize(() -> new SegmentsClient(environment.getUrl(), auth));
    this.flagsClient = memoize(() -> new FlagsClient(environment.getUrl(), auth));
    this.variantsClient = memoize(() -> new VariantsClient(environment.getUrl(), auth));
    this.authenticationClient = memoize(() -> new AuthenticationClient(environment.getUrl(), auth));
    this.distributionsClient = memoize(() -> new DistributionsClient(environment.getUrl(), auth));
    this.constraintsClient = memoize(() -> new ConstraintsClient(environment.getUrl(), auth));
    this.evaluationClient = memoize(() -> new EvaluationClient(environment.getUrl(), auth));
  }

  public final AuthenticationClient auth() {
    return this.authenticationClient.get();
  }

  public final ConstraintsClient constraints() {
    return this.constraintsClient.get();
  }

  public final DistributionsClient distributions() {
    return this.distributionsClient.get();
  }

  public final EvaluationClient evaluate() {
    return this.evaluationClient.get();
  }

  public final FlagsClient flags() {
    return this.flagsClient.get();
  }

  public final RulesClient rules() {
    return this.rulesClient.get();
  }

  public final SegmentsClient segments() {
    return this.segmentsClient.get();
  }

  public final VariantsClient variants() {
    return this.variantsClient.get();
  }

  private static <T> Supplier<T> memoize(Supplier<T> delegate) {
    AtomicReference<T> value = new AtomicReference<>();
    return () ->  {
      T val = value.get();
      if (val == null) {
        val = value.updateAndGet(cur -> cur == null ? Objects.requireNonNull(delegate.get()) : cur);
      }
      return val;
    } ;
  }
}
