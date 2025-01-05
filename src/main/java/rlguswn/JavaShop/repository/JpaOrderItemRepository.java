package rlguswn.JavaShop.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import rlguswn.JavaShop.domain.OrderItem;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaOrderItemRepository implements OrderItemRepository {

    private final EntityManager em;

    public JpaOrderItemRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        em.persist(orderItem);
        return orderItem;
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        OrderItem orderItem = em.find(OrderItem.class, id);
        return Optional.ofNullable(orderItem);
    }

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {
        return em.createQuery("select o from OrderItem o where o.orderId = :orderId", OrderItem.class)
                .setParameter("orderId", orderId)
                .getResultList();
    }

    @Override
    public List<OrderItem> findAll() {
        return em.createQuery("select o from OrderItem o", OrderItem.class)
                .getResultList();
    }
}
