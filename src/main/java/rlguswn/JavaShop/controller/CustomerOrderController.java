package rlguswn.JavaShop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rlguswn.JavaShop.domain.CustomerOrder;
import rlguswn.JavaShop.domain.Member;
import rlguswn.JavaShop.domain.OrderItem;
import rlguswn.JavaShop.dto.customerorder.OrderItemRegisterForm;
import rlguswn.JavaShop.service.CustomerOrderService;
import rlguswn.JavaShop.service.MemberService;
import rlguswn.JavaShop.service.OrderItemService;

import java.util.List;

@Controller
@RequestMapping("/order")
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;
    private final OrderItemService orderItemService;
    private final MemberService memberService;

    public CustomerOrderController(CustomerOrderService customerOrderService, OrderItemService orderItemService, MemberService memberService) {
        this.customerOrderService = customerOrderService;
        this.orderItemService = orderItemService;
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerOrder>> getOrderItem() {
        Long memberId = memberService.getLoginMember().getId();
        List<CustomerOrder> orders = customerOrderService.getOrderByMemberId(memberId);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerOrder> registerOrder(@RequestBody List<OrderItemRegisterForm> forms) {
        Member member = memberService.getLoginMember();
        CustomerOrder order = customerOrderService.createOrder(member);
        orderItemService.addOrderItem(order, forms);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{id}/cancel")
    public ResponseEntity<CustomerOrder> cancelOrder(@PathVariable Long id) {
        CustomerOrder order = customerOrderService.cancelOrderById(id);
        return ResponseEntity.ok(order);
    }
}
