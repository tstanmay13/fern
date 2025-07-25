/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.httpHead;

import com.seed.httpHead.core.ClientOptions;
import com.seed.httpHead.core.Environment;
import okhttp3.OkHttpClient;

public class AsyncSeedHttpHeadClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment;

    public AsyncSeedHttpHeadClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public AsyncSeedHttpHeadClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public AsyncSeedHttpHeadClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public AsyncSeedHttpHeadClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public AsyncSeedHttpHeadClient build() {
        return new AsyncSeedHttpHeadClient(buildClientOptions());
    }
}
