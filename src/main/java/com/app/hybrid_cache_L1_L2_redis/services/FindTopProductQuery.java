package com.app.hybrid_cache_L1_L2_redis.services;

import com.app.hybrid_cache_L1_L2_redis.documents.ProductDocument;
import com.app.hybrid_cache_L1_L2_redis.dto.ProductDTO;
import com.app.hybrid_cache_L1_L2_redis.mappers.ProductMapper;
import com.app.hybrid_cache_L1_L2_redis.repository.ProductQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.app.hybrid_cache_L1_L2_redis.utils.CacheConstants.TOP_PRODUCTS;

@Service
@AllArgsConstructor
public class FindTopProductQuery {

    private final ProductQueryRepository productQueryRepository;
    private final RedisTemplate<String, Object> redisTemplate;
    private final ProductMapper productMapper;

    @Cacheable("topProduct")
    public List<ProductDTO> execute(){

        List<ProductDTO> productRedisList = (List<ProductDTO>) this.redisTemplate.opsForValue().get(TOP_PRODUCTS);

        if(productRedisList != null && !productRedisList.isEmpty()){
            return productRedisList;
        }

        List<ProductDocument> result = this.productQueryRepository.findAll();
        if(result.isEmpty()){
            return new ArrayList<>();
        }
        return result.stream()
                .map(this.productMapper::toProductDTO)
                .limit(100000)
                .toList();
    }

}
