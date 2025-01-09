package rlguswn.JavaShop;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import rlguswn.JavaShop.Security.CustomUserDetailService;
import rlguswn.JavaShop.repository.*;
import rlguswn.JavaShop.service.*;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public ProductRepository productRepository() {
        return new JpaProductRepository(em);
    }

    @Bean
    public ProductImageRepository productImageRepository() {
        return new JpaProductImageRepository(em);
    }

    @Bean
    public CartRepository cartRepository() {
        return new JpaCartRepository(em);
    }

    @Bean
    public CartItemRepository cartItemRepository() {
        return new JpaCartItemRepository(em);
    }

    @Bean
    public CustomerOrderRepository customerOrderRepository() {
        return new JpaCustomerOrderRepository(em);
    }

    @Bean
    public OrderItemRepository orderItemRepository() {
        return new JpaOrderItemRepository(em);
    }

    @Bean
    public UserDetailsService userDetailsService(CustomUserDetailService customUserDetailService) {
        return customUserDetailService;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository(), passwordEncoder());
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository());
    }

    @Bean
    public ProductImageService productImageService() {
        return new ProductImageService(productImageRepository());
    }

    @Bean
    public CartService cartService() {
        return new CartService(cartRepository());
    }

    @Bean
    public CartItemService cartItemService() {
        return new CartItemService(cartItemRepository());
    }

    @Bean
    public CustomerOrderService customerOrderService() {
        return new CustomerOrderService(customerOrderRepository());
    }

    @Bean
    public OrderItemService orderItemService() {
        return new OrderItemService(orderItemRepository());
    }
}
