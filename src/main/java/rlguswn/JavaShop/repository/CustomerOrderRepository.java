package rlguswn.JavaShop.repository;

import rlguswn.JavaShop.domain.CustomerOrder;

import java.util.List;
import java.util.Optional;

public interface CustomerOrderRepository {
    CustomerOrder save(CustomerOrder order);
    Optional<CustomerOrder> findById(Long id);
    List<CustomerOrder> findByMemberId(Long memberId);
    List<CustomerOrder> findAll();
    boolean deleteById(Long id);
}
