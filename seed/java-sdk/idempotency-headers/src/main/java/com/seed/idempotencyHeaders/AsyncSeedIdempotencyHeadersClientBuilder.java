/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.idempotencyHeaders;

import com.seed.idempotencyHeaders.core.ClientOptions;
import com.seed.idempotencyHeaders.core.Environment;
import okhttp3.OkHttpClient;

public class AsyncSeedIdempotencyHeadersClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String token = null;

    private Environment environment;

    /**
     * Sets token
     */
    public AsyncSeedIdempotencyHeadersClientBuilder token(String token) {
        this.token = token;
        return this;
    }

    public AsyncSeedIdempotencyHeadersClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public AsyncSeedIdempotencyHeadersClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public AsyncSeedIdempotencyHeadersClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public AsyncSeedIdempotencyHeadersClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public AsyncSeedIdempotencyHeadersClient build() {
        if (token == null) {
            throw new RuntimeException("Please provide token");
        }
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + this.token);
        return new AsyncSeedIdempotencyHeadersClient(buildClientOptions());
    }
}
