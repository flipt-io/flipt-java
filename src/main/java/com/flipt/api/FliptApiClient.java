package com.flipt.api;

import com.flipt.api.client.constraints.ConstraintsServiceClient;
import com.flipt.api.client.distributions.DistributionsServiceClient;
import com.flipt.api.client.evaluate.EvaluateServiceClient;
import com.flipt.api.client.flags.FlagsServiceClient;
import com.flipt.api.client.rules.RulesServiceClient;
import com.flipt.api.client.segments.SegmentsServiceClient;
import com.flipt.api.client.variants.VariantsServiceClient;
import com.flipt.api.core.BasicAuth;
import com.flipt.api.core.Environment;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class FliptApiClient {
  private final Supplier<ConstraintsServiceClient> constraintsServiceClient;

  private final Supplier<DistributionsServiceClient> distributionsServiceClient;

  private final Supplier<EvaluateServiceClient> evaluateServiceClient;

  private final Supplier<FlagsServiceClient> flagsServiceClient;

  private final Supplier<RulesServiceClient> rulesServiceClient;

  private final Supplier<SegmentsServiceClient> segmentsServiceClient;

  private final Supplier<VariantsServiceClient> variantsServiceClient;

  public FliptApiClient(BasicAuth auth) {
    this(Environment.PRODUCTION, auth);
  }

  public FliptApiClient(Environment environment, BasicAuth auth) {
    this.segmentsServiceClient = memoize(() -> new SegmentsServiceClient(environment.getUrl(), auth));
    this.evaluateServiceClient = memoize(() -> new EvaluateServiceClient(environment.getUrl(), auth));
    this.rulesServiceClient = memoize(() -> new RulesServiceClient(environment.getUrl(), auth));
    this.distributionsServiceClient = memoize(() -> new DistributionsServiceClient(environment.getUrl(), auth));
    this.variantsServiceClient = memoize(() -> new VariantsServiceClient(environment.getUrl(), auth));
    this.flagsServiceClient = memoize(() -> new FlagsServiceClient(environment.getUrl(), auth));
    this.constraintsServiceClient = memoize(() -> new ConstraintsServiceClient(environment.getUrl(), auth));
  }

  public final ConstraintsServiceClient constraints() {
    return this.constraintsServiceClient.get();
  }

  public final DistributionsServiceClient distributions() {
    return this.distributionsServiceClient.get();
  }

  public final EvaluateServiceClient evaluate() {
    return this.evaluateServiceClient.get();
  }

  public final FlagsServiceClient flags() {
    return this.flagsServiceClient.get();
  }

  public final RulesServiceClient rules() {
    return this.rulesServiceClient.get();
  }

  public final SegmentsServiceClient segments() {
    return this.segmentsServiceClient.get();
  }

  public final VariantsServiceClient variants() {
    return this.variantsServiceClient.get();
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
