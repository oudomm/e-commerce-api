package dev.oudom.ecommerce.init;

import dev.oudom.ecommerce.features.category.Category;
import dev.oudom.ecommerce.features.category.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final CategoryRepository categoryRepository;

    @PostConstruct
    void initCategory() {
        if (categoryRepository.count() == 0) {
            categoryRepository.saveAll(List.of(
                    new Category(null, "Electronics", new ArrayList<>()),
                    new Category(null, "Clothing", new ArrayList<>()),
                    new Category(null, "Books", new ArrayList<>()),
                    new Category(null, "Home & Kitchen", new ArrayList<>()),
                    new Category(null, "Sports", new ArrayList<>())
            ));
        }
    }

}
