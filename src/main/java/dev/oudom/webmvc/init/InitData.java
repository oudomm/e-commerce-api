package dev.oudom.webmvc.init;

import dev.oudom.webmvc.domain.Category;
import dev.oudom.webmvc.repository.CategoryRepository;
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
