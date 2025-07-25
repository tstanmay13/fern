/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.noEnvironment;

import com.seed.noEnvironment.core.ClientOptions;
import com.seed.noEnvironment.core.Environment;
import okhttp3.OkHttpClient;

public class SeedNoEnvironmentClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String token = null;

    private Environment environment;

    /**
     * Sets token
     */
    public SeedNoEnvironmentClientBuilder token(String token) {
        this.token = token;
        return this;
    }

    public SeedNoEnvironmentClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public SeedNoEnvironmentClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public SeedNoEnvironmentClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public SeedNoEnvironmentClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public SeedNoEnvironmentClient build() {
        if (token == null) {
            throw new RuntimeException("Please provide token");
        }
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + this.token);
        return new SeedNoEnvironmentClient(buildClientOptions());
    }
}
