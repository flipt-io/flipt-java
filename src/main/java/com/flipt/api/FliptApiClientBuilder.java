package com.flipt.api;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.Environment;

public final class FliptApiClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.PRODUCTION;

    public FliptApiClientBuilder token(String token) {
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + token);
        return this;
    }

    public FliptApiClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public FliptApiClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public FliptApiClient build() {
        clientOptionsBuilder.environment(this.environment);
        return new FliptApiClient(clientOptionsBuilder.build());
    }
}
