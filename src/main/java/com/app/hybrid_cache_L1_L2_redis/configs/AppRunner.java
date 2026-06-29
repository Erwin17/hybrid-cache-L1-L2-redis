package com.app.hybrid_cache_L1_L2_redis.configs;

import com.app.hybrid_cache_L1_L2_redis.dto.ProductDTO;
import com.app.hybrid_cache_L1_L2_redis.mappers.ProductMapper;
import com.app.hybrid_cache_L1_L2_redis.repository.ProductQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

import static com.app.hybrid_cache_L1_L2_redis.utils.CacheConstants.TOP_PRODUCTS;


@Configuration
@AllArgsConstructor
public class AppRunner implements ApplicationRunner {

    private final ProductQueryRepository productQueryRepository;
    private final ProductMapper productMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<ProductDTO> productList =
                this.productQueryRepository.findAll()
                        .stream()
                        .map(productMapper::toProductDTO)
                        .limit(1000000)
                        .toList();

        this.redisTemplate.opsForValue().set(TOP_PRODUCTS,  productList);
    }
}
