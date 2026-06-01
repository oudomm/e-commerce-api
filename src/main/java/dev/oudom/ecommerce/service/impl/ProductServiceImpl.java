package dev.oudom.ecommerce.service.impl;

import dev.oudom.ecommerce.domain.Category;
import dev.oudom.ecommerce.domain.Product;
import dev.oudom.ecommerce.dto.CreateProductRequest;
import dev.oudom.ecommerce.dto.PatchProductRequest;
import dev.oudom.ecommerce.dto.ProductResponse;
import dev.oudom.ecommerce.dto.UpdateProductRequest;
import dev.oudom.ecommerce.mapper.ProductMapper;
import dev.oudom.ecommerce.repository.CategoryRepository;
import dev.oudom.ecommerce.repository.ProductRepository;
import dev.oudom.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {

        Category category = categoryRepository.findById(createProductRequest.categoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        Product product = productMapper.createProductRequestToProduct(createProductRequest);
        product.setCode(generateProductCode());
        product.setIsAvailable(true);
        product.setCategory(category);
        productRepository.save(product);

        return productMapper.productToProductResponse(product);
    }

    @Override
    public Page<ProductResponse> getProducts(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return productRepository.findAll(pageable).map(productMapper::productToProductResponse);
    }

    @Override
    public ProductResponse getProductByCode(String code) {
        Product product = productRepository.findProductByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product code not found"));
        return productMapper.productToProductResponse(product);
    }

    @Override
    public void deleteProductByCode(String code) {
        Product product = productRepository.findProductByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Code not found"));
        productRepository.delete(product);
    }

    @Override
    public ProductResponse updateByCode(UpdateProductRequest updateProductRequest, String code) {
        Product product = productRepository.findById(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product code not found"));
        productMapper.fromUpdateProductRequestToProduct(updateProductRequest, product);
        productRepository.save(product);
        return productMapper.productToProductResponse(product);
    }

    @Override
    public ProductResponse patchByCode(String code, PatchProductRequest patchProductRequest) {
        Product product = productRepository.findById(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product code not found"));
        productMapper.fromPatchProductRequestToProduct(patchProductRequest, product);
        productRepository.save(product);
        return productMapper.productToProductResponse(product);
    }


    private String generateProductCode() {
        final String prefix = "ITP-PRO-";

        int nextSequence = productRepository.findTopByOrderByCodeDesc()
                .map(Product::getCode)
                .filter(code -> code.startsWith(prefix))
                .map(code -> code.substring(prefix.length()))
                .map(Integer::parseInt)
                .map(sequence -> sequence + 1)
                .orElse(1);

        return "%s%03d".formatted(prefix, nextSequence);
    }
}
