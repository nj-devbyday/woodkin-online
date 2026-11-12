package me.nolanjames.woodkin.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record ProductDto(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer popularity,
        String imageUrl,
        Instant createdAt) {
}
