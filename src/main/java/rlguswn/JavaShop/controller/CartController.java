package rlguswn.JavaShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rlguswn.JavaShop.domain.Cart;
import rlguswn.JavaShop.domain.CartItem;
import rlguswn.JavaShop.domain.Member;
import rlguswn.JavaShop.domain.Product;
import rlguswn.JavaShop.dto.cart.CartItemRegisterForm;
import rlguswn.JavaShop.service.CartItemService;
import rlguswn.JavaShop.service.CartService;
import rlguswn.JavaShop.service.MemberService;
import rlguswn.JavaShop.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final CartItemService cartItemService;
    private final MemberService memberService;
    private final ProductService productService;

    public CartController(CartService cartService, CartItemService cartItemService, MemberService memberService, ProductService productService) {
        this.cartService = cartService;
        this.cartItemService = cartItemService;
        this.memberService = memberService;
        this.productService = productService;
    }

    @GetMapping
    public String getCartItem(Model model) {
        Member member = memberService.getLoginMember();
        Cart cart = cartService.getCartByMemberId(member.getId())
                .orElseThrow(() -> new IllegalArgumentException("장바구니가 존재하지 않습니다."));
        List<CartItem> cartItems = cartItemService.getCartItemByCartId(cart.getId());
        model.addAttribute("cartItems", cartItems);
        return "cart/cartDetail";
    }

    @PostMapping("/add")
    public String addCartItem(@ModelAttribute CartItemRegisterForm form, RedirectAttributes redirectAttributes) {
        Cart cart = cartService.getCartByMemberId(memberService.getLoginMember().getId())
                .orElseThrow(() -> new IllegalArgumentException("장바구니가 존재하지 않습니다."));
        Product product = productService.getProductById(form.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        Long productId = product.getId();

        boolean updated = cartItemService.addCartItem(form, product, cart);

        if (updated) {
            redirectAttributes.addFlashAttribute("message", "장바구니에 이미 있는 상품입니다. 수량을 추가했습니다.");
        }
        return "redirect:/product/" + productId;
    }

    @GetMapping("/{id}/delete")
    public String deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteById(id);
        return "redirect:/cart";
    }
}
