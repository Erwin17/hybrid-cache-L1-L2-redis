package com.app.hybrid_cache_L1_L2_redis.repository;

import com.app.hybrid_cache_L1_L2_redis.documents.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductQueryRepository extends MongoRepository<ProductDocument, String> {

}
