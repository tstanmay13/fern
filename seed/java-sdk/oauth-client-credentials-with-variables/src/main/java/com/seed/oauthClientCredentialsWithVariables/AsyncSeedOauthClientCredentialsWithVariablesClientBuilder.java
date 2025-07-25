/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.oauthClientCredentialsWithVariables;

import com.seed.oauthClientCredentialsWithVariables.core.ClientOptions;
import com.seed.oauthClientCredentialsWithVariables.core.Environment;
import com.seed.oauthClientCredentialsWithVariables.core.OAuthTokenSupplier;
import com.seed.oauthClientCredentialsWithVariables.resources.auth.AuthClient;
import okhttp3.OkHttpClient;

public class AsyncSeedOauthClientCredentialsWithVariablesClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String clientId = null;

    private String clientSecret = null;

    private Environment environment;

    /**
     * Sets clientId
     */
    public AsyncSeedOauthClientCredentialsWithVariablesClientBuilder clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * Sets clientSecret
     */
    public AsyncSeedOauthClientCredentialsWithVariablesClientBuilder clientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public AsyncSeedOauthClientCredentialsWithVariablesClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public AsyncSeedOauthClientCredentialsWithVariablesClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public AsyncSeedOauthClientCredentialsWithVariablesClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public AsyncSeedOauthClientCredentialsWithVariablesClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    public AsyncSeedOauthClientCredentialsWithVariablesClientBuilder rootVariable(String rootVariable) {
        clientOptionsBuilder.rootVariable(rootVariable);
        return this;
    }

    protected ClientOptions buildClientOptions() {
        clientOptionsBuilder.environment(this.environment);
        return clientOptionsBuilder.build();
    }

    public AsyncSeedOauthClientCredentialsWithVariablesClient build() {
        AuthClient authClient = new AuthClient(
                ClientOptions.builder().environment(this.environment).build());
        OAuthTokenSupplier oAuthTokenSupplier = new OAuthTokenSupplier(clientId, clientSecret, authClient);
        this.clientOptionsBuilder.addHeader("Authorization", oAuthTokenSupplier);
        return new AsyncSeedOauthClientCredentialsWithVariablesClient(buildClientOptions());
    }
}
