package dev.oudom.ecommerce.service;

import dev.oudom.ecommerce.dto.CreateProductRequest;
import dev.oudom.ecommerce.dto.PatchProductRequest;
import dev.oudom.ecommerce.dto.ProductResponse;
import dev.oudom.ecommerce.dto.UpdateProductRequest;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest createProductRequest);
    Page<ProductResponse> getProducts(int pageNumber, int pageSize);
    ProductResponse getProductByCode(String code);
    void deleteProductByCode(String code);
    ProductResponse updateByCode(UpdateProductRequest updateProductRequest, String code);
    ProductResponse patchByCode(String code, PatchProductRequest patchProductRequest);
}
