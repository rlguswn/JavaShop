package rlguswn.JavaShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rlguswn.JavaShop.domain.Cart;
import rlguswn.JavaShop.domain.CustomerOrder;
import rlguswn.JavaShop.domain.Member;
import rlguswn.JavaShop.dto.customerorder.OrderItemRegisterForm;
import rlguswn.JavaShop.service.CartService;
import rlguswn.JavaShop.service.CustomerOrderService;
import rlguswn.JavaShop.service.MemberService;
import rlguswn.JavaShop.service.OrderItemService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;
    private final MemberService memberService;

    public CustomerOrderController(CustomerOrderService customerOrderService, MemberService memberService) {
        this.customerOrderService = customerOrderService;
        this.memberService = memberService;
    }

    @GetMapping
    public String getOrderItem(Model model) {
        Long memberId = memberService.getLoginMember().getId();
        List<CustomerOrder> orders = customerOrderService.getOrderByMemberId(memberId);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    @GetMapping("/{id}")
    public String getOrderById(Model model, @PathVariable Long id) {
        Member member = memberService.getLoginMember();
        Optional<CustomerOrder> order = customerOrderService.getOrderById(id);
        if (order.isPresent() && member.equals(order.get().getMember())) {
            model.addAttribute("order", order.get());
        }
        return "order/orderDetail";
    }

    @PostMapping("/register")
    public String registerOrder(Model model, @RequestBody List<OrderItemRegisterForm> forms) {
        Member member = memberService.getLoginMember();
        CustomerOrder order = customerOrderService.createOrder(member, forms);
        model.addAttribute("order", order);
        return "order/orderDetail";
    }

    @GetMapping("/{id}/register")
    public String registerOrderByCartId(Model model, @PathVariable Long id, @ModelAttribute List<OrderItemRegisterForm> forms) {
        Member member = memberService.getLoginMember();

        CustomerOrder order = customerOrderService.createOrder(member, forms);

        List<CustomerOrder> orders = customerOrderService.getOrderByMemberId(member.getId());
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    @GetMapping("/{id}/cancel")
    public String cancelOrder(@PathVariable Long id) {
        customerOrderService.cancelOrderById(id);
        return "redirect:/order";
    }

    @GetMapping("/{id}/complete")
    public String completeOrder(@PathVariable Long id) {
        customerOrderService.completeOrderById(id);
        return "redirect:/order/" + id;
    }
}
