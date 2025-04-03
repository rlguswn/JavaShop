package rlguswn.JavaShop.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rlguswn.JavaShop.domain.CustomerOrder;
import rlguswn.JavaShop.domain.OrderItem;
import rlguswn.JavaShop.domain.Product;
import rlguswn.JavaShop.dto.customerorder.OrderItemRegisterForm;
import rlguswn.JavaShop.repository.CustomerOrderRepository;
import rlguswn.JavaShop.repository.OrderItemRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;
    private final CustomerOrderRepository customerOrderRepository;

    public OrderItemService(OrderItemRepository orderItemRepository, ProductService productService, CustomerOrderRepository customerOrderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.productService = productService;
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<OrderItem> addOrderItem(CustomerOrder order, List<OrderItemRegisterForm> forms) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemRegisterForm form : forms) {
            Product product = productService.getProductById(form.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

            OrderItem orderItem = new OrderItem(
                    order,
                    product,
                    form.getQuantity(),
                    product.getPrice()
            );
            orderItemRepository.save(orderItem);
            orderItems.add(orderItem);
        }
        customerOrderRepository.save(order);

        return orderItems;
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public List<OrderItem> findOrderItemByOrderId(Long id) {
        return orderItemRepository.findByOrderId(id);
    }

    public List<OrderItem> findAllOrderItem() {
        return orderItemRepository.findAll();
    }

    public boolean deleteById(Long id) {
        return orderItemRepository.deleteById(id);
    }
}
