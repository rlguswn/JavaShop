package rlguswn.JavaShop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<CartItem>> getCartItem() {
        Member member = memberService.getLoginMember();
        Cart cart = cartService.getCartByMemberId(member.getId())
                .orElseThrow(() -> new IllegalArgumentException("장바구니가 존재하지 않습니다."));
        List<CartItem> cartItems = cartItemService.getCartItemByCartId(cart.getId());
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/add")
    public ResponseEntity<CartItem> addCartItem(@RequestBody CartItemRegisterForm form) {
        Cart cart = cartService.getCartByMemberId(memberService.getLoginMember().getId())
                .orElseThrow(() -> new IllegalArgumentException("장바구니가 존재하지 않습니다."));
        Product product = productService.getProductById(form.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        CartItem cartItem = cartItemService.addCartItem(form, product, cart);

        return ResponseEntity.ok(cartItem);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<String> deleteCartItem(@PathVariable Long id) {
        boolean isDeleted = cartItemService.deleteById(id);
        String message = isDeleted ? "장바구니에서 상품을 제거했습니다.":"장바구니에서 상품을 제거하지 못했습니다.";
        return ResponseEntity.ok(message);
    }
}
