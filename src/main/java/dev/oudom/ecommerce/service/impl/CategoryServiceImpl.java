package dev.oudom.ecommerce.service.impl;

import dev.oudom.ecommerce.domain.Category;
import dev.oudom.ecommerce.dto.CategoryResponse;
import dev.oudom.ecommerce.mapper.CategoryMapper;
import dev.oudom.ecommerce.repository.CategoryRepository;
import dev.oudom.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::fromCategoryToCategoryResponse).toList();
    }

}
