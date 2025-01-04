package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository {
    CartItem save(CartItem cartItem);
    Optional<CartItem> findById(Long id);
    List<CartItem> findByCartId(Long cartId);
    List<CartItem> findAll();
}
