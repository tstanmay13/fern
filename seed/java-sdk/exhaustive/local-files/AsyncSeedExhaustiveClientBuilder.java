/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.fern.sdk;

import com.fern.sdk.core.ClientOptions;
import com.fern.sdk.core.Environment;
import java.lang.String;
import okhttp3.OkHttpClient;

public class AsyncSeedExhaustiveClientBuilder {
  private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

  private String token = null;

  private Environment environment;

  /**
   * Sets token
   */
  public AsyncSeedExhaustiveClientBuilder token(String token) {
    this.token = token;
    return this;
  }

  public AsyncSeedExhaustiveClientBuilder url(String url) {
    this.environment = Environment.custom(url);
    return this;
  }

  /**
   * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
   */
  public AsyncSeedExhaustiveClientBuilder timeout(int timeout) {
    this.clientOptionsBuilder.timeout(timeout);
    return this;
  }

  /**
   * Sets the maximum number of retries for the client. Defaults to 2 retries.
   */
  public AsyncSeedExhaustiveClientBuilder maxRetries(int maxRetries) {
    this.clientOptionsBuilder.maxRetries(maxRetries);
    return this;
  }

  /**
   * Sets the underlying OkHttp client
   */
  public AsyncSeedExhaustiveClientBuilder httpClient(OkHttpClient httpClient) {
    this.clientOptionsBuilder.httpClient(httpClient);
    return this;
  }

  protected ClientOptions buildClientOptions() {
    clientOptionsBuilder.environment(this.environment);
    return clientOptionsBuilder.build();
  }

  public AsyncSeedExhaustiveClient build() {
    this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + this.token);
    return new AsyncSeedExhaustiveClient(buildClientOptions());
  }
}
