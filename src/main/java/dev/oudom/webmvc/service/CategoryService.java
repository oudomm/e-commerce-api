package dev.oudom.webmvc.service;

import dev.oudom.webmvc.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
}
