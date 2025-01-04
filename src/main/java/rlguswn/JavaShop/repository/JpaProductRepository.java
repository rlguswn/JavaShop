package rlguswn.JavaShop.repository;

import jakarta.persistence.EntityManager;
import rlguswn.JavaShop.domain.Product;

import java.util.List;
import java.util.Optional;

public class JpaProductRepository implements ProductRepository {

    private final EntityManager em;

    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = em.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }
}
