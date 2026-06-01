package dev.oudom.ecommerce.features.category;

import dev.oudom.ecommerce.features.category.dto.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse fromCategoryToCategoryResponse(Category category);

}
