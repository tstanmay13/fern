/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.unknownAsAny;

import com.seed.unknownAsAny.core.ClientOptions;
import com.seed.unknownAsAny.core.Environment;
import okhttp3.OkHttpClient;

public class SeedUnknownAsAnyClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment;

    public SeedUnknownAsAnyClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public SeedUnknownAsAnyClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public SeedUnknownAsAnyClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public SeedUnknownAsAnyClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public SeedUnknownAsAnyClient build() {
        return new SeedUnknownAsAnyClient(buildClientOptions());
    }
}
