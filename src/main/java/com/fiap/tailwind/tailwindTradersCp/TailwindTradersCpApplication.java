package com.fiap.tailwind.tailwindTradersCp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.fiap.tailwind.tailwindTradersCp.model")
@ComponentScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = {"com.fiap.tailwind.tailwindTradersCp.repository"})
@EnableTransactionManagement
public class TailwindTradersCpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TailwindTradersCpApplication.class, args);
	}


}
