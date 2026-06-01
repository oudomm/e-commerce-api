package dev.oudom.webmvc.service;

import dev.oudom.webmvc.dto.CreateProductRequest;
import dev.oudom.webmvc.dto.PatchProductRequest;
import dev.oudom.webmvc.dto.ProductResponse;
import dev.oudom.webmvc.dto.UpdateProductRequest;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest createProductRequest);
    Page<ProductResponse> getProducts(int pageNumber, int pageSize);
    ProductResponse getProductByCode(String code);
    void deleteProductByCode(String code);
    ProductResponse updateByCode(UpdateProductRequest updateProductRequest, String code);
    ProductResponse patchByCode(String code, PatchProductRequest patchProductRequest);
}
