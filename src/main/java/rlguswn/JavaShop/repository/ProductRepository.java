package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    boolean deleteById(Long id);
}
