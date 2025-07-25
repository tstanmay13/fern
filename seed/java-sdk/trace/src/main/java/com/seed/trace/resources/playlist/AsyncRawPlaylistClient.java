/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.resources.playlist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.seed.trace.core.ClientOptions;
import com.seed.trace.core.MediaTypes;
import com.seed.trace.core.ObjectMappers;
import com.seed.trace.core.QueryStringMapper;
import com.seed.trace.core.RequestOptions;
import com.seed.trace.core.SeedTraceApiException;
import com.seed.trace.core.SeedTraceException;
import com.seed.trace.core.SeedTraceHttpResponse;
import com.seed.trace.resources.playlist.requests.CreatePlaylistRequest;
import com.seed.trace.resources.playlist.requests.GetPlaylistsRequest;
import com.seed.trace.resources.playlist.types.Playlist;
import com.seed.trace.resources.playlist.types.UpdatePlaylistRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public class AsyncRawPlaylistClient {
    protected final ClientOptions clientOptions;

    public AsyncRawPlaylistClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Create a new playlist
     */
    public CompletableFuture<SeedTraceHttpResponse<Playlist>> createPlaylist(
            int serviceParam, CreatePlaylistRequest request) {
        return createPlaylist(serviceParam, request, null);
    }

    /**
     * Create a new playlist
     */
    public CompletableFuture<SeedTraceHttpResponse<Playlist>> createPlaylist(
            int serviceParam, CreatePlaylistRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/playlist")
                .addPathSegment(Integer.toString(serviceParam))
                .addPathSegments("create");
        QueryStringMapper.addQueryParameter(httpUrl, "datetime", request.getDatetime(), false);
        if (request.getOptionalDatetime().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "optionalDatetime", request.getOptionalDatetime().get(), false);
        }
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request.getBody()), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SeedTraceHttpResponse<Playlist>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SeedTraceHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Playlist.class), response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SeedTraceApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SeedTraceException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SeedTraceException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Returns the user's playlists
     */
    public CompletableFuture<SeedTraceHttpResponse<List<Playlist>>> getPlaylists(
            int serviceParam, GetPlaylistsRequest request) {
        return getPlaylists(serviceParam, request, null);
    }

    /**
     * Returns the user's playlists
     */
    public CompletableFuture<SeedTraceHttpResponse<List<Playlist>>> getPlaylists(
            int serviceParam, GetPlaylistsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/playlist")
                .addPathSegment(Integer.toString(serviceParam))
                .addPathSegments("all");
        if (request.getLimit().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "limit", request.getLimit().get(), false);
        }
        QueryStringMapper.addQueryParameter(httpUrl, "otherField", request.getOtherField(), false);
        QueryStringMapper.addQueryParameter(httpUrl, "multiLineDocs", request.getMultiLineDocs(), false);
        if (request.getOptionalMultipleField().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "optionalMultipleField",
                    request.getOptionalMultipleField().get(),
                    true);
        }
        QueryStringMapper.addQueryParameter(httpUrl, "multipleField", request.getMultipleField(), true);
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SeedTraceHttpResponse<List<Playlist>>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SeedTraceHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(
                                        responseBody.string(), new TypeReference<List<Playlist>>() {}),
                                response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SeedTraceApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SeedTraceException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SeedTraceException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Returns a playlist
     */
    public CompletableFuture<SeedTraceHttpResponse<Playlist>> getPlaylist(int serviceParam, String playlistId) {
        return getPlaylist(serviceParam, playlistId, null);
    }

    /**
     * Returns a playlist
     */
    public CompletableFuture<SeedTraceHttpResponse<Playlist>> getPlaylist(
            int serviceParam, String playlistId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/playlist")
                .addPathSegment(Integer.toString(serviceParam))
                .addPathSegment(playlistId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SeedTraceHttpResponse<Playlist>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SeedTraceHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Playlist.class), response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SeedTraceApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SeedTraceException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SeedTraceException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Updates a playlist
     */
    public CompletableFuture<SeedTraceHttpResponse<Optional<Playlist>>> updatePlaylist(
            int serviceParam, String playlistId) {
        return updatePlaylist(serviceParam, playlistId, Optional.empty());
    }

    /**
     * Updates a playlist
     */
    public CompletableFuture<SeedTraceHttpResponse<Optional<Playlist>>> updatePlaylist(
            int serviceParam, String playlistId, Optional<UpdatePlaylistRequest> request) {
        return updatePlaylist(serviceParam, playlistId, request, null);
    }

    /**
     * Updates a playlist
     */
    public CompletableFuture<SeedTraceHttpResponse<Optional<Playlist>>> updatePlaylist(
            int serviceParam,
            String playlistId,
            Optional<UpdatePlaylistRequest> request,
            RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/playlist")
                .addPathSegment(Integer.toString(serviceParam))
                .addPathSegment(playlistId)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create("", null);
            if (request.isPresent()) {
                body = RequestBody.create(
                        ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
            }
        } catch (JsonProcessingException e) {
            throw new SeedTraceException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SeedTraceHttpResponse<Optional<Playlist>>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SeedTraceHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(
                                        responseBody.string(), new TypeReference<Optional<Playlist>>() {}),
                                response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SeedTraceApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SeedTraceException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SeedTraceException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Deletes a playlist
     */
    public CompletableFuture<SeedTraceHttpResponse<Void>> deletePlaylist(int serviceParam, String playlistId) {
        return deletePlaylist(serviceParam, playlistId, null);
    }

    /**
     * Deletes a playlist
     */
    public CompletableFuture<SeedTraceHttpResponse<Void>> deletePlaylist(
            int serviceParam, String playlistId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/playlist")
                .addPathSegment(Integer.toString(serviceParam))
                .addPathSegment(playlistId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SeedTraceHttpResponse<Void>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SeedTraceHttpResponse<>(null, response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SeedTraceApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SeedTraceException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SeedTraceException("Network error executing HTTP request", e));
            }
        });
        return future;
    }
}
