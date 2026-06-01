package dev.oudom.ecommerce.exception;

public record FieldResponse(
        String field,
        String reason
) {
}
