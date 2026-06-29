package com.app.hybrid_cache_L1_L2_redis.mappers;

import com.app.hybrid_cache_L1_L2_redis.documents.ProductDocument;
import com.app.hybrid_cache_L1_L2_redis.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    ProductDTO toProductDTO(ProductDocument productDocument);
}
