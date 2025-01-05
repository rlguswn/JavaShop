package rlguswn.JavaShop.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import rlguswn.JavaShop.domain.ProductImage;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaProductImageRepository implements ProductImageRepository {

    private final EntityManager em;

    public JpaProductImageRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public ProductImage save(ProductImage productImage) {
        em.persist(productImage);
        return productImage;
    }

    @Override
    public Optional<ProductImage> findById(Long id) {
        ProductImage productImage = em.find(ProductImage.class, id);
        return Optional.ofNullable(productImage);
    }

    @Override
    public List<ProductImage> findByProductId(Long productId) {
        return em.createQuery("select p from ProductImage p where p.productId = :productId", ProductImage.class)
                .setParameter("productId", productId)
                .getResultList();
    }

    @Override
    public List<ProductImage> findAll() {
        return em.createQuery("select p from ProductImage p", ProductImage.class)
                .getResultList();
    }
}
