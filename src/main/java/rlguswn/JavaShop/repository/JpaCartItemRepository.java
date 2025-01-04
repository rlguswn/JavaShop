package rlguswn.JavaShop.repository;

import jakarta.persistence.EntityManager;
import rlguswn.JavaShop.domain.CartItem;

import java.util.List;
import java.util.Optional;

public class JpaCartItemRepository implements CartItemRepository {

    private final EntityManager em;

    public JpaCartItemRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public CartItem save(CartItem cartItem) {
        em.persist(cartItem);
        return cartItem;
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        CartItem cartItem = em.find(CartItem.class, id);
        return Optional.ofNullable(cartItem);
    }

    @Override
    public List<CartItem> findByCartId(Long cartId) {
         return em.createQuery("select c from CartItem c where c.cartId = :cartId", CartItem.class)
                .setParameter("cartId", cartId)
                .getResultList();
    }

    @Override
    public List<CartItem> findAll() {
        return em.createQuery("select c from CartItem c", CartItem.class)
                .getResultList();
    }
}
