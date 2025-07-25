/**
 * This file was auto-generated by Fern from our API Definition.
 */

import { mockServerPool } from "../mock-server/MockServerPool";
import { SeedTraceClient } from "../../src/Client";

describe("Homepage", () => {
    test("getHomepageProblems", async () => {
        const server = mockServerPool.createServer();
        const client = new SeedTraceClient({ token: "test", xRandomHeader: "test", environment: server.baseUrl });

        const rawResponseBody = ["string", "string"];
        server.mockEndpoint().get("/homepage-problems").respondWith().statusCode(200).jsonBody(rawResponseBody).build();

        const response = await client.homepage.getHomepageProblems();
        expect(response).toEqual(["string", "string"]);
    });

    test("setHomepageProblems", async () => {
        const server = mockServerPool.createServer();
        const client = new SeedTraceClient({ token: "test", xRandomHeader: "test", environment: server.baseUrl });
        const rawRequestBody = ["string", "string"];

        server.mockEndpoint().post("/homepage-problems").jsonBody(rawRequestBody).respondWith().statusCode(200).build();

        const response = await client.homepage.setHomepageProblems(["string", "string"]);
        expect(response).toEqual(undefined);
    });
});
