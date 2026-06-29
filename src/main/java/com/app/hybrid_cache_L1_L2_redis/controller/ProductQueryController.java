package com.app.hybrid_cache_L1_L2_redis.controller;

import com.app.hybrid_cache_L1_L2_redis.dto.ProductDTO;
import com.app.hybrid_cache_L1_L2_redis.services.FindTopProductQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ProductQueryController {

    private FindTopProductQuery findTopProductQuery;
    private final RedisTemplate redisTemplate;

    @GetMapping(value = "greeting")
    public String greeting(){
        return "Hi";
    }

    @GetMapping(value = "/top", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTopProducts(){

        List<ProductDTO> topProdctList = this.findTopProductQuery.execute();
        if(!topProdctList.isEmpty()){
            return ResponseEntity.ok(topProdctList);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
