package rlguswn.JavaShop.repository;

import jakarta.persistence.EntityManager;
import rlguswn.JavaShop.domain.Order;

import java.util.List;
import java.util.Optional;

public class JpaOrderRepository implements OrderRepository {

    private final EntityManager em;

    public JpaOrderRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Order save(Order order) {
        em.persist(order);
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        Order order = em.find(Order.class, id);
        return Optional.ofNullable(order);
    }

    @Override
    public List<Order> findByMemberId(Long memberId) {
        return em.createQuery("select o from Order o where o.memberId = :memberId", Order.class)
                .setParameter("memderId", memberId)
                .getResultList();
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("select o from Order o", Order.class)
                .getResultList();
    }
}
