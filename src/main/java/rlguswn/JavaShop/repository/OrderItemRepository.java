package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository {
    OrderItem save(OrderItem orderItem);
    Optional<OrderItem> findById(Long id);
    Optional<OrderItem> findByMemberId(Long memberId);
    List<OrderItem> findAll();
}
