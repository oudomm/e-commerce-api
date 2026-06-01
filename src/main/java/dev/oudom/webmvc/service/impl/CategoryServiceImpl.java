package dev.oudom.webmvc.service.impl;

import dev.oudom.webmvc.domain.Category;
import dev.oudom.webmvc.dto.CategoryResponse;
import dev.oudom.webmvc.mapper.CategoryMapper;
import dev.oudom.webmvc.repository.CategoryRepository;
import dev.oudom.webmvc.service.CategoryService;
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
