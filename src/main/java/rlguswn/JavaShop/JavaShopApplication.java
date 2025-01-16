package rlguswn.JavaShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "rlguswn.JavaShop.repository")
public class JavaShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaShopApplication.class, args);
	}

}
