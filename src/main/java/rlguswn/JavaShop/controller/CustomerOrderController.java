package rlguswn.JavaShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rlguswn.JavaShop.domain.CustomerOrder;
import rlguswn.JavaShop.domain.Member;
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
    public String getOrderItem(Model model) {
        Long memberId = memberService.getLoginMember().getId();
        List<CustomerOrder> orders = customerOrderService.getOrderByMemberId(memberId);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    @PostMapping("/register")
    public String registerOrder(Model model, @RequestBody List<OrderItemRegisterForm> forms) {
        Member member = memberService.getLoginMember();
        CustomerOrder order = customerOrderService.createOrder(member);
        orderItemService.addOrderItem(order, forms);
        model.addAttribute("order", order);
        return "order/orderDetail";
    }

    @GetMapping("/{id}/cancel")
    public String cancelOrder(@PathVariable Long id) {
        customerOrderService.cancelOrderById(id);
        return "redirect:/order";
    }
}
