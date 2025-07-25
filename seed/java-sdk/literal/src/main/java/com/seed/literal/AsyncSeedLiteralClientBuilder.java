/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.literal;

import com.seed.literal.core.ClientOptions;
import com.seed.literal.core.Environment;
import okhttp3.OkHttpClient;

public class AsyncSeedLiteralClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String version = "02-02-2024";

    private String auditLogging = "true";

    private Environment environment;

    /**
     * Sets version
     */
    public AsyncSeedLiteralClientBuilder version(String version) {
        this.version = version;
        return this;
    }

    /**
     * Sets auditLogging
     */
    public AsyncSeedLiteralClientBuilder auditLogging(String auditLogging) {
        this.auditLogging = auditLogging;
        return this;
    }

    public AsyncSeedLiteralClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public AsyncSeedLiteralClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public AsyncSeedLiteralClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public AsyncSeedLiteralClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public AsyncSeedLiteralClient build() {
        this.clientOptionsBuilder.addHeader("X-API-Version", this.version);
        this.clientOptionsBuilder.addHeader("X-API-Enable-Audit-Logging", this.auditLogging);
        return new AsyncSeedLiteralClient(buildClientOptions());
    }
}
