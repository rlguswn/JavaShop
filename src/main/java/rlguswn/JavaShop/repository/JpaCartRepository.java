package rlguswn.JavaShop.repository;

import jakarta.persistence.EntityManager;
import rlguswn.JavaShop.domain.Cart;

import java.util.List;
import java.util.Optional;

public class JpaCartRepository implements CartRepository {

    private final EntityManager em;

    public JpaCartRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Cart save(Cart cart) {
        em.persist(cart);
        return cart;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        Cart cart = em.find(Cart.class, id);
        return Optional.ofNullable(cart);
    }

    @Override
    public Optional<Cart> findByMemberId(Long memberId) {
        List<Cart> result = em.createQuery("select c from Cart c where c.memberId = :memberId", Cart.class)
                .setParameter("memberId", memberId)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Cart> findAll() {
        return em.createQuery("select c from Cart c", Cart.class)
                .getResultList();
    }
}
