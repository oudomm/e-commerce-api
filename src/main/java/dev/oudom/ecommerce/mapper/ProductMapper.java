package dev.oudom.ecommerce.mapper;

import dev.oudom.ecommerce.domain.Product;
import dev.oudom.ecommerce.dto.CreateProductRequest;
import dev.oudom.ecommerce.dto.PatchProductRequest;
import dev.oudom.ecommerce.dto.ProductResponse;
import dev.oudom.ecommerce.dto.UpdateProductRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "code", ignore = true)
    @Mapping(target = "isAvailable", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "orderLines", ignore = true)
    Product createProductRequestToProduct(CreateProductRequest createProductRequest);

    @Mapping(source = "category.name", target = "categoryName")
    ProductResponse productToProductResponse(Product product);

    @Mapping(target = "code", ignore = true)
    @Mapping(target = "isAvailable", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "orderLines", ignore = true)
    void fromUpdateProductRequestToProduct(UpdateProductRequest updateProductRequest, @MappingTarget Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "code", ignore = true)
    @Mapping(target = "isAvailable", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "orderLines", ignore = true)
    void fromPatchProductRequestToProduct(PatchProductRequest patchProductRequest, @MappingTarget Product product);
}
