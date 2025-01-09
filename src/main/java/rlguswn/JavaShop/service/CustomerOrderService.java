package rlguswn.JavaShop.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rlguswn.JavaShop.domain.CustomerOrder;
import rlguswn.JavaShop.repository.CustomerOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public CustomerOrder createOrder(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    public Optional<CustomerOrder> getOrderById(Long id) {
        return customerOrderRepository.findById(id);
    }

    public List<CustomerOrder> getOrderByMemberId(Long id) {
        return customerOrderRepository.findByMemberId(id);
    }

    public List<CustomerOrder> getAllOrder() {
        return customerOrderRepository.findAll();
    }
}
