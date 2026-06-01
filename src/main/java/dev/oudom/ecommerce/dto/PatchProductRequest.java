package dev.oudom.ecommerce.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record PatchProductRequest(
        @Size(min = 1, max = 100)
        String name,

        @Positive
        BigDecimal price,

        @Positive
        Integer qty,

        String description
) {
}
