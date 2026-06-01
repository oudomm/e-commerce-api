package dev.oudom.ecommerce.features.product;

import dev.oudom.ecommerce.features.product.dto.CreateProductRequest;
import dev.oudom.ecommerce.features.product.dto.PatchProductRequest;
import dev.oudom.ecommerce.features.product.dto.ProductResponse;
import dev.oudom.ecommerce.features.product.dto.UpdateProductRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductResponse> getProducts(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        log.info("getProducts");
        return productService.getProducts(pageNumber, pageSize);
    }

    @GetMapping("/{code}")
    public ProductResponse getByCode(@PathVariable String code) {
        log.info("getByCode");
        return productService.getProductByCode(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createNew(@Valid @RequestBody CreateProductRequest createProductRequest) {
        log.info("createProductRequest: {}", createProductRequest);
        return productService.createProduct(createProductRequest);
    }

    @PutMapping("/{code}")
    public ProductResponse updateByCode(
            @Valid @RequestBody UpdateProductRequest updateProductRequest,
            @PathVariable String code) {
        log.info("updateByCode: {} and code: {}", updateProductRequest, code);
        return productService.updateByCode(updateProductRequest, code);
    }

    @PatchMapping("/{code}")
    public ProductResponse patchByCode(
            @PathVariable String code,
            @RequestBody PatchProductRequest patchProductRequest) {
        log.info("patchByCode: {} and code: {}", patchProductRequest, code);
        return productService.patchByCode(code, patchProductRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void deleteByCode(@PathVariable String code) {
        log.info("deleteByCode: {}", code);
        productService.deleteProductByCode(code);
    }

}
