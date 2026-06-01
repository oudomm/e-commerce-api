package dev.oudom.ecommerce.service;

import dev.oudom.ecommerce.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
}
