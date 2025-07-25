/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.bearerTokenEnvironmentVariable;

import com.seed.bearerTokenEnvironmentVariable.core.ClientOptions;
import com.seed.bearerTokenEnvironmentVariable.core.Environment;
import okhttp3.OkHttpClient;

public class SeedBearerTokenEnvironmentVariableClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String apiKey = System.getenv("COURIER_API_KEY");

    private String version = "1.0.0";

    private Environment environment;

    /**
     * Sets apiKey.
     * Defaults to the COURIER_API_KEY environment variable.
     */
    public SeedBearerTokenEnvironmentVariableClientBuilder apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * Sets version
     */
    public SeedBearerTokenEnvironmentVariableClientBuilder version(String version) {
        this.version = version;
        return this;
    }

    public SeedBearerTokenEnvironmentVariableClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public SeedBearerTokenEnvironmentVariableClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public SeedBearerTokenEnvironmentVariableClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public SeedBearerTokenEnvironmentVariableClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public SeedBearerTokenEnvironmentVariableClient build() {
        if (apiKey == null) {
            throw new RuntimeException("Please provide apiKey or set the COURIER_API_KEY environment variable.");
        }
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + this.apiKey);
        this.clientOptionsBuilder.addHeader("X-API-Version", this.version);
        return new SeedBearerTokenEnvironmentVariableClient(buildClientOptions());
    }
}
