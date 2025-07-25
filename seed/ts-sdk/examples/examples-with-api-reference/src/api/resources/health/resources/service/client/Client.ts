/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as environments from "../../../../../../environments.js";
import * as core from "../../../../../../core/index.js";
import { mergeHeaders, mergeOnlyDefinedHeaders } from "../../../../../../core/headers.js";
import * as errors from "../../../../../../errors/index.js";

export declare namespace Service {
    export interface Options {
        environment: core.Supplier<environments.SeedExamplesEnvironment | string>;
        /** Specify a custom URL to connect the client to. */
        baseUrl?: core.Supplier<string>;
        token?: core.Supplier<core.BearerToken | undefined>;
        /** Additional headers to include in requests. */
        headers?: Record<string, string | core.Supplier<string | undefined> | undefined>;
    }

    export interface RequestOptions {
        /** The maximum time to wait for a response in seconds. */
        timeoutInSeconds?: number;
        /** The number of times to retry the request. Defaults to 2. */
        maxRetries?: number;
        /** A hook to abort the request. */
        abortSignal?: AbortSignal;
        /** Additional query string parameters to include in the request. */
        queryParams?: Record<string, unknown>;
        /** Additional headers to include in the request. */
        headers?: Record<string, string | core.Supplier<string | undefined> | undefined>;
    }
}

export class Service {
    protected readonly _options: Service.Options;

    constructor(_options: Service.Options) {
        this._options = _options;
    }

    /**
     * This endpoint checks the health of a resource.
     *
     * @param {string} id - The id to check
     * @param {Service.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @example
     *     await client.health.service.check("id-2sdx82h")
     *
     * @example
     *     await client.health.service.check("id-3tey93i")
     */
    public check(id: string, requestOptions?: Service.RequestOptions): core.HttpResponsePromise<void> {
        return core.HttpResponsePromise.fromPromise(this.__check(id, requestOptions));
    }

    private async __check(id: string, requestOptions?: Service.RequestOptions): Promise<core.WithRawResponse<void>> {
        const _response = await core.fetcher({
            url: core.url.join(
                (await core.Supplier.get(this._options.baseUrl)) ??
                    (await core.Supplier.get(this._options.environment)),
                `/check/${encodeURIComponent(id)}`,
            ),
            method: "GET",
            headers: mergeHeaders(
                this._options?.headers,
                mergeOnlyDefinedHeaders({ Authorization: await this._getAuthorizationHeader() }),
                requestOptions?.headers,
            ),
            queryParameters: requestOptions?.queryParams,
            timeoutMs: requestOptions?.timeoutInSeconds != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
            maxRetries: requestOptions?.maxRetries,
            abortSignal: requestOptions?.abortSignal,
        });
        if (_response.ok) {
            return { data: undefined, rawResponse: _response.rawResponse };
        }

        if (_response.error.reason === "status-code") {
            throw new errors.SeedExamplesError({
                statusCode: _response.error.statusCode,
                body: _response.error.body,
                rawResponse: _response.rawResponse,
            });
        }

        switch (_response.error.reason) {
            case "non-json":
                throw new errors.SeedExamplesError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.rawBody,
                    rawResponse: _response.rawResponse,
                });
            case "timeout":
                throw new errors.SeedExamplesTimeoutError("Timeout exceeded when calling GET /check/{id}.");
            case "unknown":
                throw new errors.SeedExamplesError({
                    message: _response.error.errorMessage,
                    rawResponse: _response.rawResponse,
                });
        }
    }

    /**
     * This endpoint checks the health of the service.
     *
     * @param {Service.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @example
     *     await client.health.service.ping()
     */
    public ping(requestOptions?: Service.RequestOptions): core.HttpResponsePromise<boolean> {
        return core.HttpResponsePromise.fromPromise(this.__ping(requestOptions));
    }

    private async __ping(requestOptions?: Service.RequestOptions): Promise<core.WithRawResponse<boolean>> {
        const _response = await core.fetcher({
            url: core.url.join(
                (await core.Supplier.get(this._options.baseUrl)) ??
                    (await core.Supplier.get(this._options.environment)),
                "/ping",
            ),
            method: "GET",
            headers: mergeHeaders(
                this._options?.headers,
                mergeOnlyDefinedHeaders({ Authorization: await this._getAuthorizationHeader() }),
                requestOptions?.headers,
            ),
            queryParameters: requestOptions?.queryParams,
            timeoutMs: requestOptions?.timeoutInSeconds != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
            maxRetries: requestOptions?.maxRetries,
            abortSignal: requestOptions?.abortSignal,
        });
        if (_response.ok) {
            return { data: _response.body as boolean, rawResponse: _response.rawResponse };
        }

        if (_response.error.reason === "status-code") {
            throw new errors.SeedExamplesError({
                statusCode: _response.error.statusCode,
                body: _response.error.body,
                rawResponse: _response.rawResponse,
            });
        }

        switch (_response.error.reason) {
            case "non-json":
                throw new errors.SeedExamplesError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.rawBody,
                    rawResponse: _response.rawResponse,
                });
            case "timeout":
                throw new errors.SeedExamplesTimeoutError("Timeout exceeded when calling GET /ping.");
            case "unknown":
                throw new errors.SeedExamplesError({
                    message: _response.error.errorMessage,
                    rawResponse: _response.rawResponse,
                });
        }
    }

    protected async _getAuthorizationHeader(): Promise<string | undefined> {
        const bearer = await core.Supplier.get(this._options.token);
        if (bearer != null) {
            return `Bearer ${bearer}`;
        }

        return undefined;
    }
}
