/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.objectsWithImports;

import com.seed.objectsWithImports.core.ClientOptions;
import com.seed.objectsWithImports.core.Environment;
import okhttp3.OkHttpClient;

public class AsyncSeedObjectsWithImportsClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment;

    public AsyncSeedObjectsWithImportsClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public AsyncSeedObjectsWithImportsClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public AsyncSeedObjectsWithImportsClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public AsyncSeedObjectsWithImportsClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public AsyncSeedObjectsWithImportsClient build() {
        return new AsyncSeedObjectsWithImportsClient(buildClientOptions());
    }
}
