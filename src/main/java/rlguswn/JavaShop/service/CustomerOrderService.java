package rlguswn.JavaShop.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rlguswn.JavaShop.domain.Cart;
import rlguswn.JavaShop.domain.CustomerOrder;
import rlguswn.JavaShop.domain.Member;
import rlguswn.JavaShop.domain.OrderItem;
import rlguswn.JavaShop.dto.customerorder.OrderItemRegisterForm;
import rlguswn.JavaShop.enums.OrderStatus;
import rlguswn.JavaShop.repository.CustomerOrderRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CartService cartService;
    private final CartItemService cartItemService;
    private final OrderItemService orderItemService;

    public CustomerOrderService(CustomerOrderRepository customerOrderRepository, CartService cartService, CartItemService cartItemService, OrderItemService orderItemService) {
        this.customerOrderRepository = customerOrderRepository;
        this.cartService = cartService;
        this.cartItemService = cartItemService;
        this.orderItemService = orderItemService;
    }

    public CustomerOrder createOrder(Member member, List<OrderItemRegisterForm> forms) {
        Cart cart = cartService.getCartByMemberId(member.getId()).get();
        CustomerOrder order = new CustomerOrder(
                member,
                OrderStatus.PENDING
        );
        customerOrderRepository.save(order);
        cartItemService.deleteByCartId(cart.getId());

        List<OrderItem> orderItems =  orderItemService.addOrderItem(order, forms);

        BigDecimal totalPrice = orderItems.stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotalPrice(totalPrice);
        customerOrderRepository.save(order);

        return order;
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

    public CustomerOrder completeOrderById(Long id) {
        CustomerOrder order = customerOrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("주문을 찾을 수 없습니다."));
        order.completeOrder();
        return customerOrderRepository.save(order);
    }
}
