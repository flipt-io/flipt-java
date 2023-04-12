package com.flipt.api;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.Environment;
import com.flipt.api.core.Suppliers;
import com.flipt.api.resources.auth.AuthClient;
import com.flipt.api.resources.auth.AuthClientImpl;
import com.flipt.api.resources.authmethodk8s.AuthMethodK8SClient;
import com.flipt.api.resources.authmethodk8s.AuthMethodK8SClientImpl;
import com.flipt.api.resources.authmethodoidc.AuthMethodOidcClient;
import com.flipt.api.resources.authmethodoidc.AuthMethodOidcClientImpl;
import com.flipt.api.resources.authmethodtoken.AuthMethodTokenClient;
import com.flipt.api.resources.authmethodtoken.AuthMethodTokenClientImpl;
import com.flipt.api.resources.constraints.ConstraintsClient;
import com.flipt.api.resources.constraints.ConstraintsClientImpl;
import com.flipt.api.resources.distributions.DistributionsClient;
import com.flipt.api.resources.distributions.DistributionsClientImpl;
import com.flipt.api.resources.evaluate.EvaluateClient;
import com.flipt.api.resources.evaluate.EvaluateClientImpl;
import com.flipt.api.resources.flags.FlagsClient;
import com.flipt.api.resources.flags.FlagsClientImpl;
import com.flipt.api.resources.namespaces.NamespacesClient;
import com.flipt.api.resources.namespaces.NamespacesClientImpl;
import com.flipt.api.resources.rules.RulesClient;
import com.flipt.api.resources.rules.RulesClientImpl;
import com.flipt.api.resources.segments.SegmentsClient;
import com.flipt.api.resources.segments.SegmentsClientImpl;
import com.flipt.api.resources.variants.VariantsClient;
import com.flipt.api.resources.variants.VariantsClientImpl;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

public final class FliptApiClientImpl implements FliptApiClient {
  private final ClientOptions clientOptions;

  private final Supplier<AuthMethodK8SClient> authMethodK8SClient;

  private final Supplier<AuthMethodOidcClient> authMethodOidcClient;

  private final Supplier<AuthMethodTokenClient> authMethodTokenClient;

  private final Supplier<AuthClient> authClient;

  private final Supplier<ConstraintsClient> constraintsClient;

  private final Supplier<DistributionsClient> distributionsClient;

  private final Supplier<EvaluateClient> evaluateClient;

  private final Supplier<FlagsClient> flagsClient;

  private final Supplier<NamespacesClient> namespacesClient;

  private final Supplier<RulesClient> rulesClient;

  private final Supplier<SegmentsClient> segmentsClient;

  private final Supplier<VariantsClient> variantsClient;

  public FliptApiClientImpl(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.authMethodK8SClient = Suppliers.memoize(() -> new AuthMethodK8SClientImpl(clientOptions));
    this.authMethodOidcClient = Suppliers.memoize(() -> new AuthMethodOidcClientImpl(clientOptions));
    this.authMethodTokenClient = Suppliers.memoize(() -> new AuthMethodTokenClientImpl(clientOptions));
    this.authClient = Suppliers.memoize(() -> new AuthClientImpl(clientOptions));
    this.constraintsClient = Suppliers.memoize(() -> new ConstraintsClientImpl(clientOptions));
    this.distributionsClient = Suppliers.memoize(() -> new DistributionsClientImpl(clientOptions));
    this.evaluateClient = Suppliers.memoize(() -> new EvaluateClientImpl(clientOptions));
    this.flagsClient = Suppliers.memoize(() -> new FlagsClientImpl(clientOptions));
    this.namespacesClient = Suppliers.memoize(() -> new NamespacesClientImpl(clientOptions));
    this.rulesClient = Suppliers.memoize(() -> new RulesClientImpl(clientOptions));
    this.segmentsClient = Suppliers.memoize(() -> new SegmentsClientImpl(clientOptions));
    this.variantsClient = Suppliers.memoize(() -> new VariantsClientImpl(clientOptions));
  }

  @Override
  public AuthMethodK8SClient authMethodK8S() {
    return this.authMethodK8SClient.get();
  }

  @Override
  public AuthMethodOidcClient authMethodOidc() {
    return this.authMethodOidcClient.get();
  }

  @Override
  public AuthMethodTokenClient authMethodToken() {
    return this.authMethodTokenClient.get();
  }

  @Override
  public AuthClient auth() {
    return this.authClient.get();
  }

  @Override
  public ConstraintsClient constraints() {
    return this.constraintsClient.get();
  }

  @Override
  public DistributionsClient distributions() {
    return this.distributionsClient.get();
  }

  @Override
  public EvaluateClient evaluate() {
    return this.evaluateClient.get();
  }

  @Override
  public FlagsClient flags() {
    return this.flagsClient.get();
  }

  @Override
  public NamespacesClient namespaces() {
    return this.namespacesClient.get();
  }

  @Override
  public RulesClient rules() {
    return this.rulesClient.get();
  }

  @Override
  public SegmentsClient segments() {
    return this.segmentsClient.get();
  }

  @Override
  public VariantsClient variants() {
    return this.variantsClient.get();
  }

  public static final class Builder implements FliptApiClient.Builder {
    ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    Environment environment = Environment.PRODUCTION;

    @Override
    public FliptApiClient.Builder token(String token) {
      this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + token);
      return this;
    }

    @Override
    public FliptApiClient.Builder environment(Environment environment) {
      this.environment = environment;
      return this;
    }

    @Override
    public FliptApiClient.Builder url(String url) {
      this.environment = Environment.custom(url);
      return this;
    }

    @Override
    public FliptApiClient build() {
      clientOptionsBuilder.environment(this.environment);
      return new FliptApiClientImpl(clientOptionsBuilder.build());
    }
  }
}
