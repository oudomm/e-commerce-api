package dev.oudom.webmvc.exception;

public record FieldResponse(
        String field,
        String reason
) {
}
