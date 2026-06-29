package com.app.hybrid_cache_L1_L2_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HybridCacheL1L2RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(HybridCacheL1L2RedisApplication.class, args);
	}

}
