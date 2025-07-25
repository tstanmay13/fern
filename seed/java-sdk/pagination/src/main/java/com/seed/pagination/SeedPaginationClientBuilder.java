/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.pagination;

import com.seed.pagination.core.ClientOptions;
import com.seed.pagination.core.Environment;
import okhttp3.OkHttpClient;

public class SeedPaginationClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String token = null;

    private Environment environment;

    /**
     * Sets token
     */
    public SeedPaginationClientBuilder token(String token) {
        this.token = token;
        return this;
    }

    public SeedPaginationClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public SeedPaginationClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public SeedPaginationClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public SeedPaginationClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public SeedPaginationClient build() {
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + this.token);
        return new SeedPaginationClient(buildClientOptions());
    }
}
