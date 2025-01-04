package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findByMemberId(Long memberId);
    List<Order> findAll();
}
