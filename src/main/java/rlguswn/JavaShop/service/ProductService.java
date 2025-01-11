package rlguswn.JavaShop.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rlguswn.JavaShop.domain.Product;
import rlguswn.JavaShop.domain.ProductImage;
import rlguswn.JavaShop.dto.product.ProductRegisterForm;
import rlguswn.JavaShop.dto.product.ProductUpdateForm;
import rlguswn.JavaShop.repository.ProductRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductImageService productImageService;

    public ProductService(ProductRepository productRepository, ProductImageService productImageService) {
        this.productRepository = productRepository;
        this.productImageService = productImageService;
    }

    public Product registerProduct(ProductRegisterForm form) {
        Product product = new Product(
                form.getName(),
                form.getDescription(),
                form.getPrice(),
                form.getQuantity()
        );
        productRepository.save(product);

        MultipartFile imageFile = form.getImage();
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                ProductImage productImage = new ProductImage(
                        product,
                        imageFile.getBytes(),
                        imageFile.getContentType()
                );
                productImageService.saveProductImage(productImage);
            } catch (IOException e) {
                throw new RuntimeException("이미지 저장 중 오류가 발생했습니다.");
            }
        }
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, ProductUpdateForm form) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        product.setQuantity(form.getQuantity());

        productRepository.save(product);

        MultipartFile imageFile = form.getImage();
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                ProductImage productImage = new ProductImage(
                        product,
                        imageFile.getBytes(),
                        imageFile.getContentType()
                );
                productImageService.saveProductImage(productImage);
            } catch (IOException e) {
                throw new RuntimeException("이미지 저장 중 오류가 발생했습니다.");
            }
        }
        return product;
    }

    public boolean deleteById(Long id) {
        return productRepository.deleteById(id);
    }
}
