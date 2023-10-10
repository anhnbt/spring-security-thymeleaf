package com.anhnbt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan({"com.anhnbt.controller", "com.anhnbt.service", "com.anhnbt.security"})
@EntityScan("com.anhnbt.entity")
@EnableJpaRepositories("com.anhnbt.repository")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StudentappApplication {

	public static void main(String[] args) {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		String password1 = bCryptPasswordEncoder.encode("john123");
//		String password2 = bCryptPasswordEncoder.encode("sachin123");
		SpringApplication.run(StudentappApplication.class, args);
	}

}
