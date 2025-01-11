package rlguswn.JavaShop.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rlguswn.JavaShop.domain.Product;
import rlguswn.JavaShop.dto.product.ProductRegisterForm;
import rlguswn.JavaShop.dto.product.ProductUpdateForm;
import rlguswn.JavaShop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product registerProduct(ProductRegisterForm form) {
        Product product = new Product(
                form.getName(),
                form.getDescription(),
                form.getPrice(),
                form.getQuantity()
        );
        return productRepository.save(product);
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

        return productRepository.save(product);
    }

    public boolean deleteById(Long id) {
        return productRepository.deleteById(id);
    }
}
