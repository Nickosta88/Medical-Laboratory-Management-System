package com.medical.management.medlab_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.medical.management.medlab_system.repository")
public class MedlabSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedlabSystemApplication.class, args);
	}

}
