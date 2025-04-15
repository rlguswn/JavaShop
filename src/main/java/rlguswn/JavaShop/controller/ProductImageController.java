package rlguswn.JavaShop.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rlguswn.JavaShop.domain.ProductImage;
import rlguswn.JavaShop.service.ProductImageService;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/product/image")
public class ProductImageController {

    private final ProductImageService productImageService;

    public ProductImageController(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getProductImageByProductId(@PathVariable Long id) throws IOException {
        Optional<ProductImage> productImage = productImageService.getProductImageByProductId(id);
        if (productImage.isPresent()) {
            byte[] imageData = productImage.get().getImageData();
            return ResponseEntity.ok()
                    .header("Content-Type", productImage.get().getContentType())
                    .body(imageData);
        } else {
            ClassPathResource defaultImage = new ClassPathResource("static/images/default.jpg");
            byte[] imageData = defaultImage.getInputStream().readAllBytes();

            return ResponseEntity.ok()
                    .header("Content-Type", "image/jpeg")
                    .body(imageData);
        }
    }
}
