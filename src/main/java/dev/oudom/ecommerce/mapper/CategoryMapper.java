package dev.oudom.ecommerce.mapper;

import dev.oudom.ecommerce.domain.Category;
import dev.oudom.ecommerce.dto.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse fromCategoryToCategoryResponse(Category category);

}
