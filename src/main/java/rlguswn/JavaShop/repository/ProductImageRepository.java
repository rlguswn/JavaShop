package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageRepository {
    ProductImage save(ProductImage productImage);
    Optional<ProductImage> findById(Long id);
    Optional<ProductImage> findByProductId(Long productId);
    List<ProductImage> findAll();
}
