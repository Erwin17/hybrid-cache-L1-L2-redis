package com.app.hybrid_cache_L1_L2_redis.dto;

import java.math.BigDecimal;

public record ProductDTO(
        String id,
        String name,
        BigDecimal price,
        String description
) {}
