package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.Order;

import java.util.List;
import java.util.Optional;

public class JpaOrderRepository implements OrderRepository {
    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> findByMemberId(Long memberId) {
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }
}
