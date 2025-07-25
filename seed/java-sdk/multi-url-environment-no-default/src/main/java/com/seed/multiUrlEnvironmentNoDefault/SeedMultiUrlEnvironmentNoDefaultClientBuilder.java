/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.multiUrlEnvironmentNoDefault;

import com.seed.multiUrlEnvironmentNoDefault.core.ClientOptions;
import com.seed.multiUrlEnvironmentNoDefault.core.Environment;
import okhttp3.OkHttpClient;

public class SeedMultiUrlEnvironmentNoDefaultClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String token = null;

    private Environment environment;

    /**
     * Sets token
     */
    public SeedMultiUrlEnvironmentNoDefaultClientBuilder token(String token) {
        this.token = token;
        return this;
    }

    public SeedMultiUrlEnvironmentNoDefaultClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public SeedMultiUrlEnvironmentNoDefaultClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public SeedMultiUrlEnvironmentNoDefaultClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public SeedMultiUrlEnvironmentNoDefaultClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public SeedMultiUrlEnvironmentNoDefaultClient build() {
        if (token == null) {
            throw new RuntimeException("Please provide token");
        }
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + this.token);
        return new SeedMultiUrlEnvironmentNoDefaultClient(buildClientOptions());
    }
}
