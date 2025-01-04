package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.Cart;

import java.util.List;
import java.util.Optional;

public interface CartRepository {
    Cart save(Cart cart);
    Optional<Cart> findById(Long id);
    Optional<Cart> findByMemberId(Long memberId);
    List<Cart> findAll();
}
