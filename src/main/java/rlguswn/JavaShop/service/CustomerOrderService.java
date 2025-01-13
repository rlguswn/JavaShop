package rlguswn.JavaShop.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rlguswn.JavaShop.domain.CustomerOrder;
import rlguswn.JavaShop.domain.Member;
import rlguswn.JavaShop.enums.OrderStatus;
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

    public CustomerOrder createOrder(Member member) {
        CustomerOrder order = new CustomerOrder(
                member,
                OrderStatus.PENDING
        );
        return customerOrderRepository.save(order);
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

    public boolean deleteById(Long id) {
        return customerOrderRepository.deleteById(id);
    }

    public CustomerOrder cancelOrderById(Long id) {
        CustomerOrder order = customerOrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("주문을 찾을 수 없습니다."));
        order.setStatus(OrderStatus.CANCELED);
        return customerOrderRepository.save(order);
    }
}
