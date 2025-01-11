package rlguswn.JavaShop.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rlguswn.JavaShop.domain.ProductImage;
import rlguswn.JavaShop.repository.ProductImageRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    public ProductImageService(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    public ProductImage saveProductImage(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    public Optional<ProductImage> getProductImageById(Long id) {
        return productImageRepository.findById(id);
    }

    public List<ProductImage> getProductImageByProductId(Long id) {
        return productImageRepository.findByProductId(id);
    }

    public List<ProductImage> getAllProductImage() {
        return productImageRepository.findAll();
    }

    public boolean deleteById(Long id) {
        return productImageRepository.deleteById(id);
    }
}
