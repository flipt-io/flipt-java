package com.flipt.api.core;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import okhttp3.OkHttpClient;

public final class ClientOptions {
  private final Environment environment;

  private final Map<String, String> headers;

  private final OkHttpClient httpClient;

  private ClientOptions(Environment environment, Map<String, String> headers,
      OkHttpClient httpClient) {
    this.environment = environment;
    this.headers = headers;
    this.httpClient = httpClient;
  }

  public Environment environment() {
    return this.environment;
  }

  public Map<String, String> headers() {
    return this.headers;
  }

  public OkHttpClient httpClient() {
    return this.httpClient;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Environment environment;

    private final Map<String, String> headers = new HashMap<>();

    public Builder environment(Environment environment) {
      this.environment = environment;
      return this;
    }

    public Builder addHeader(String key, String value) {
      this.headers.put(key, value);
      return this;
    }

    public ClientOptions build() {
      return new ClientOptions(environment, headers, new OkHttpClient());
    }
  }
}
