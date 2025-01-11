package rlguswn.JavaShop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rlguswn.JavaShop.domain.Product;
import rlguswn.JavaShop.dto.product.ProductRegisterForm;
import rlguswn.JavaShop.dto.product.ProductUpdateForm;
import rlguswn.JavaShop.service.ProductImageService;
import rlguswn.JavaShop.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductImageService productImageService;

    public ProductController(ProductService productService, ProductImageService productImageService) {
        this.productService = productService;
        this.productImageService = productImageService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/register")
    public ResponseEntity<String> registerPage() {
        String message = "상품 등록 페이지";
        return ResponseEntity.ok(message);
    }

    @PostMapping(value = "/register", consumes = "multipart/form-data")
    public ResponseEntity<Product> registerProduct(@ModelAttribute ProductRegisterForm form) {
        Product product = productService.registerProduct(form);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/update")
    public ResponseEntity<String> updatePage(@PathVariable Long id) {
        String message = "상품 수정 페이지";
        return ResponseEntity.ok(message);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateForm form) {
        Product product = productService.updateProduct(id, form);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.deleteById(id);
        String message = isDeleted ? "상품을 제거했습니다.":"상품을 제거하지 못했습니다.";
        return ResponseEntity.ok(message);
    }
}
