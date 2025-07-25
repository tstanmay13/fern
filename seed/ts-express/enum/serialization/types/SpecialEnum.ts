/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../index";
import * as SeedEnum from "../../api/index";
import * as core from "../../core";

export const SpecialEnum: core.serialization.Schema<serializers.SpecialEnum.Raw, SeedEnum.SpecialEnum> =
    core.serialization.enum_([
        "",
        'Hello \\"World\\"',
        "Hello 'World'",
        "Hello\\\\World",
        "Hello\\nWorld",
        "Hello\\rWorld",
        "Hello\\tWorld",
        "Hello\\fWorld",
        "Hello\\u0008World",
        "Hello\\vWorld",
        "Hello\\x00World",
        "Hello\\u0007World",
        "Hello\\u0001World",
        "Hello\\u0002World",
        "Hello\\u001FWorld",
        "Hello\\u007FWorld",
        "Hello\\u009FWorld",
        'Line 1\\n"Quote"\\tTab\\\\Backslash\\r\\nLine 2\\0Null',
        "\\n\\r\\t\\x00\\u0008\\f\\v\\u0007",
        "Hello \u4E16\u754C",
        "caf\u00E9",
        "\uD83D\uDE80",
        "\\\\n",
        "\\\\",
        '{"name": "John", "age": 30, "city": "New York"}',
        "SELECT * FROM users WHERE name = 'John O\\\\'Reilly'",
        "C:\\\\Users\\\\John\\\\Documents\\\\file.txt",
        "/usr/local/bin/app",
        "\\\\d{3}-\\\\d{2}-\\\\d{4}",
        "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}",
        'transcript[transcriptType="final"]',
        "transcript[transcriptType='final']",
    ]);

export declare namespace SpecialEnum {
    export type Raw =
        | ""
        | 'Hello \\"World\\"'
        | "Hello 'World'"
        | "Hello\\\\World"
        | "Hello\\nWorld"
        | "Hello\\rWorld"
        | "Hello\\tWorld"
        | "Hello\\fWorld"
        | "Hello\\u0008World"
        | "Hello\\vWorld"
        | "Hello\\x00World"
        | "Hello\\u0007World"
        | "Hello\\u0001World"
        | "Hello\\u0002World"
        | "Hello\\u001FWorld"
        | "Hello\\u007FWorld"
        | "Hello\\u009FWorld"
        | 'Line 1\\n"Quote"\\tTab\\\\Backslash\\r\\nLine 2\\0Null'
        | "\\n\\r\\t\\x00\\u0008\\f\\v\\u0007"
        | "Hello \u4E16\u754C"
        | "caf\u00E9"
        | "\uD83D\uDE80"
        | "\\\\n"
        | "\\\\"
        | '{"name": "John", "age": 30, "city": "New York"}'
        | "SELECT * FROM users WHERE name = 'John O\\\\'Reilly'"
        | "C:\\\\Users\\\\John\\\\Documents\\\\file.txt"
        | "/usr/local/bin/app"
        | "\\\\d{3}-\\\\d{2}-\\\\d{4}"
        | "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}"
        | 'transcript[transcriptType="final"]'
        | "transcript[transcriptType='final']";
}
