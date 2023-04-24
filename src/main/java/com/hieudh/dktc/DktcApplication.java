package com.hieudh.dktc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = { "com.hieudh.dktc.repository" })
public class DktcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DktcApplication.class, args);
	}

}
