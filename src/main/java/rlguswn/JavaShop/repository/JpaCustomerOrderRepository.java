package rlguswn.JavaShop.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import rlguswn.JavaShop.domain.CustomerOrder;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCustomerOrderRepository implements CustomerOrderRepository {

    private final EntityManager em;

    public JpaCustomerOrderRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public CustomerOrder save(CustomerOrder order) {
        em.persist(order);
        return order;
    }

    @Override
    public Optional<CustomerOrder> findById(Long id) {
        CustomerOrder order = em.find(CustomerOrder.class, id);
        return Optional.ofNullable(order);
    }

    @Override
    public List<CustomerOrder> findByMemberId(Long memberId) {
        return em.createQuery("select o from CustomerOrder o where o.memberId = :memberId", CustomerOrder.class)
                .setParameter("memderId", memberId)
                .getResultList();
    }

    @Override
    public List<CustomerOrder> findAll() {
        return em.createQuery("select o from Order o", CustomerOrder.class)
                .getResultList();
    }

    @Override
    public boolean deleteById(Long id) {
        CustomerOrder customerOrder = em.find(CustomerOrder.class, id);
        if (customerOrder != null) {
            em.remove(customerOrder);
            return true;
        }
        return false;
    }
}
