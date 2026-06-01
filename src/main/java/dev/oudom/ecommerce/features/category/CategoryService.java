package dev.oudom.ecommerce.features.category;

import dev.oudom.ecommerce.features.category.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
}
