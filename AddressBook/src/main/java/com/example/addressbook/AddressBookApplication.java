package com.example.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({"com.example.*"})
@EnableTransactionManagement
@EnableJpaRepositories({"com.example.*"})
@EnableJpaAuditing
@EntityScan({"com.example.*"})
public class AddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

}
