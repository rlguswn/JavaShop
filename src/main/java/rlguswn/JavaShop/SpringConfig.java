package rlguswn.JavaShop;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import rlguswn.JavaShop.repository.*;

public class SpringConfig {

    private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
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
}
