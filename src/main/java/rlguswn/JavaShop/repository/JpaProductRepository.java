package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.Product;

import java.util.List;
import java.util.Optional;

public class JpaProductRepository implements ProductRepository {
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }
}
