package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.OrderItem;

import java.util.List;
import java.util.Optional;

public class JpaOrderItemRepository implements OrderItemRepository {
    @Override
    public OrderItem save(OrderItem orderItem) {
        return null;
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<OrderItem> findByMemberId(Long memberId) {
        return Optional.empty();
    }

    @Override
    public List<OrderItem> findAll() {
        return List.of();
    }
}
