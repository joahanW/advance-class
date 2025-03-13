package com.metrodata.advance_class;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(
	info = @Info(
			title = "Advance Class REST API Documentation",
			description = "JMarket E-Commerce simple API for Advance Class",
			version = "1.0.0",
			contact = @Contact(
					name = "Johan",
					email = "Johan.work@example.com",
					url = "https://johan.work"
			),
			license = @License(
					name = "Apache 2.0",
					url = "https://www.apache.org/licenses/LICENSE-2.0"
			)
	)
)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@SpringBootApplication
public class AdvanceClassApplication {

    public static void main(String[] args) {
		SpringApplication.run(AdvanceClassApplication.class, args);
	}

}
