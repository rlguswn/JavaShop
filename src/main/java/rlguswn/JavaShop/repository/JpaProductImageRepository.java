package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.ProductImage;

import java.util.List;
import java.util.Optional;

public class JpaProductImageRepository implements ProductImageRepository {
    @Override
    public ProductImage save(ProductImage productImage) {
        return null;
    }

    @Override
    public Optional<ProductImage> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductImage> findByProductId(Long productId) {
        return Optional.empty();
    }

    @Override
    public List<ProductImage> findAll() {
        return List.of();
    }
}
