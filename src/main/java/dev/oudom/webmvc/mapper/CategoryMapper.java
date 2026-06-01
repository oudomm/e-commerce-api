package dev.oudom.webmvc.mapper;

import dev.oudom.webmvc.domain.Category;
import dev.oudom.webmvc.dto.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse fromCategoryToCategoryResponse(Category category);

}
