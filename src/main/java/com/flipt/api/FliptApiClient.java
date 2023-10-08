/**
 */
package com.flipt.api;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.Suppliers;
import com.flipt.api.resources.auth.AuthClient;
import com.flipt.api.resources.authmethodk8s.AuthMethodK8SClient;
import com.flipt.api.resources.authmethodoidc.AuthMethodOidcClient;
import com.flipt.api.resources.authmethodtoken.AuthMethodTokenClient;
import com.flipt.api.resources.constraints.ConstraintsClient;
import com.flipt.api.resources.distributions.DistributionsClient;
import com.flipt.api.resources.evaluate.EvaluateClient;
import com.flipt.api.resources.evaluation.EvaluationClient;
import com.flipt.api.resources.flags.FlagsClient;
import com.flipt.api.resources.namespaces.NamespacesClient;
import com.flipt.api.resources.rollouts.RolloutsClient;
import com.flipt.api.resources.rules.RulesClient;
import com.flipt.api.resources.segments.SegmentsClient;
import com.flipt.api.resources.variants.VariantsClient;
import java.util.function.Supplier;

public class FliptApiClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<EvaluationClient> evaluationClient;

    protected final Supplier<AuthMethodK8SClient> authMethodK8SClient;

    protected final Supplier<AuthMethodOidcClient> authMethodOidcClient;

    protected final Supplier<AuthMethodTokenClient> authMethodTokenClient;

    protected final Supplier<AuthClient> authClient;

    protected final Supplier<ConstraintsClient> constraintsClient;

    protected final Supplier<DistributionsClient> distributionsClient;

    protected final Supplier<EvaluateClient> evaluateClient;

    protected final Supplier<FlagsClient> flagsClient;

    protected final Supplier<NamespacesClient> namespacesClient;

    protected final Supplier<RolloutsClient> rolloutsClient;

    protected final Supplier<RulesClient> rulesClient;

    protected final Supplier<SegmentsClient> segmentsClient;

    protected final Supplier<VariantsClient> variantsClient;

    public FliptApiClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.evaluationClient = Suppliers.memoize(() -> new EvaluationClient(clientOptions));
        this.authMethodK8SClient = Suppliers.memoize(() -> new AuthMethodK8SClient(clientOptions));
        this.authMethodOidcClient = Suppliers.memoize(() -> new AuthMethodOidcClient(clientOptions));
        this.authMethodTokenClient = Suppliers.memoize(() -> new AuthMethodTokenClient(clientOptions));
        this.authClient = Suppliers.memoize(() -> new AuthClient(clientOptions));
        this.constraintsClient = Suppliers.memoize(() -> new ConstraintsClient(clientOptions));
        this.distributionsClient = Suppliers.memoize(() -> new DistributionsClient(clientOptions));
        this.evaluateClient = Suppliers.memoize(() -> new EvaluateClient(clientOptions));
        this.flagsClient = Suppliers.memoize(() -> new FlagsClient(clientOptions));
        this.namespacesClient = Suppliers.memoize(() -> new NamespacesClient(clientOptions));
        this.rolloutsClient = Suppliers.memoize(() -> new RolloutsClient(clientOptions));
        this.rulesClient = Suppliers.memoize(() -> new RulesClient(clientOptions));
        this.segmentsClient = Suppliers.memoize(() -> new SegmentsClient(clientOptions));
        this.variantsClient = Suppliers.memoize(() -> new VariantsClient(clientOptions));
    }

    public EvaluationClient evaluation() {
        return this.evaluationClient.get();
    }

    public AuthMethodK8SClient authMethodK8S() {
        return this.authMethodK8SClient.get();
    }

    public AuthMethodOidcClient authMethodOidc() {
        return this.authMethodOidcClient.get();
    }

    public AuthMethodTokenClient authMethodToken() {
        return this.authMethodTokenClient.get();
    }

    public AuthClient auth() {
        return this.authClient.get();
    }

    public ConstraintsClient constraints() {
        return this.constraintsClient.get();
    }

    public DistributionsClient distributions() {
        return this.distributionsClient.get();
    }

    public EvaluateClient evaluate() {
        return this.evaluateClient.get();
    }

    public FlagsClient flags() {
        return this.flagsClient.get();
    }

    public NamespacesClient namespaces() {
        return this.namespacesClient.get();
    }

    public RolloutsClient rollouts() {
        return this.rolloutsClient.get();
    }

    public RulesClient rules() {
        return this.rulesClient.get();
    }

    public SegmentsClient segments() {
        return this.segmentsClient.get();
    }

    public VariantsClient variants() {
        return this.variantsClient.get();
    }

    public static FliptApiClientBuilder builder() {
        return new FliptApiClientBuilder();
    }
}
