/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.basicAuth;

import com.seed.basicAuth.core.ClientOptions;
import com.seed.basicAuth.core.Environment;
import java.util.Base64;
import okhttp3.OkHttpClient;

public class SeedBasicAuthClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String username = null;

    private String password = null;

    private Environment environment;

    public SeedBasicAuthClientBuilder credentials(String username, String password) {
        this.username = username;
        this.password = password;
        return this;
    }

    public SeedBasicAuthClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public SeedBasicAuthClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public SeedBasicAuthClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public SeedBasicAuthClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public SeedBasicAuthClient build() {
        if (this.username == null) {
            throw new RuntimeException("Please provide username");
        }
        if (this.password == null) {
            throw new RuntimeException("Please provide password");
        }
        String unencodedToken = username + ":" + password;
        String encodedToken = Base64.getEncoder().encodeToString(unencodedToken.getBytes());
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + encodedToken);
        return new SeedBasicAuthClient(buildClientOptions());
    }
}
