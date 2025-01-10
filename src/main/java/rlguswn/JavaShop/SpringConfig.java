package rlguswn.JavaShop;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }
}
