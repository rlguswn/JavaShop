package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.Cart;

import java.util.List;
import java.util.Optional;

public class JpaCartRepository implements CartRepository {
    @Override
    public Cart save(Cart cart) {
        return null;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Cart> findByMemberId(Long memberId) {
        return Optional.empty();
    }

    @Override
    public List<Cart> findAll() {
        return List.of();
    }
}
