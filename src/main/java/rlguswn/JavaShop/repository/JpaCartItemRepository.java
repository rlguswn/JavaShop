package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.CartItem;

import java.util.List;
import java.util.Optional;

public class JpaCartItemRepository implements CartItemRepository {
    @Override
    public CartItem save(CartItem cartItem) {
        return null;
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CartItem> findByCartId(Long cartId) {
        return Optional.empty();
    }

    @Override
    public List<CartItem> findAll() {
        return List.of();
    }
}
