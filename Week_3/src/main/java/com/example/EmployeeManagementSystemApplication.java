package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}
	@Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

}
