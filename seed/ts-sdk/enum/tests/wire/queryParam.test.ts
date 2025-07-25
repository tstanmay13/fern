/**
 * This file was auto-generated by Fern from our API Definition.
 */

import { mockServerPool } from "../mock-server/MockServerPool";
import { SeedEnumClient } from "../../src/Client";

describe("QueryParam", () => {
    test("send", async () => {
        const server = mockServerPool.createServer();
        const client = new SeedEnumClient({ environment: server.baseUrl });

        server.mockEndpoint().post("/query").respondWith().statusCode(200).build();

        const response = await client.queryParam.send({
            operand: ">",
            operandOrColor: "red",
        });
        expect(response).toEqual(undefined);
    });

    test("sendList", async () => {
        const server = mockServerPool.createServer();
        const client = new SeedEnumClient({ environment: server.baseUrl });

        server.mockEndpoint().post("/query-list").respondWith().statusCode(200).build();

        const response = await client.queryParam.sendList({
            operand: ">",
            maybeOperand: ">",
            operandOrColor: "red",
            maybeOperandOrColor: "red",
        });
        expect(response).toEqual(undefined);
    });
});
