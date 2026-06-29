package com.app.hybrid_cache_L1_L2_redis.mappers;

import com.app.hybrid_cache_L1_L2_redis.documents.ProductDocument;
import com.app.hybrid_cache_L1_L2_redis.dto.ProductDTO;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-29T17:04:27-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-java-compiler-worker-9.5.1.jar, environment: Java 25.0.2 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toProductDTO(ProductDocument productDocument) {
        if ( productDocument == null ) {
            return null;
        }

        String id = null;
        String name = null;
        BigDecimal price = null;
        String description = null;

        id = productDocument.getId();
        name = productDocument.getName();
        price = productDocument.getPrice();
        description = productDocument.getDescription();

        ProductDTO productDTO = new ProductDTO( id, name, price, description );

        return productDTO;
    }
}
