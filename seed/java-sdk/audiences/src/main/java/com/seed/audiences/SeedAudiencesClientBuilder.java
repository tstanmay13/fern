/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.audiences;

import com.seed.audiences.core.ClientOptions;
import com.seed.audiences.core.Environment;
import okhttp3.OkHttpClient;

public class SeedAudiencesClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment;

    public SeedAudiencesClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public SeedAudiencesClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public SeedAudiencesClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public SeedAudiencesClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public SeedAudiencesClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public SeedAudiencesClient build() {
        return new SeedAudiencesClient(buildClientOptions());
    }
}
