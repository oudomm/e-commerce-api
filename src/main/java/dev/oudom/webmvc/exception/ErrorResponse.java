package dev.oudom.webmvc.exception;

import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record ErrorResponse(
        String status,
        Integer code,
        String message,
        Instant timestamp,
        List<FieldResponse> errorDetails
) {
}
