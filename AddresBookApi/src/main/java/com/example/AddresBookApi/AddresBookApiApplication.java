package com.example.AddresBookApi;

import com.example.AddresBookApi.entity.Contact;
import com.example.AddresBookApi.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AddresBookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddresBookApiApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(ContactRepository contactRepository){
		return args ->{
			List<Contact> contacts = Arrays.asList(
					new Contact("Dudi","dudi@rc.com",LocalDateTime.now()),
					new Contact("Churri","chu@rc.com",LocalDateTime.now()),
					new Contact("Fede","fede@rc.com",LocalDateTime.now()),
					new Contact("Fer","fer@rc.com",LocalDateTime.now()),
					new Contact("Sere","borrado@rc.com",LocalDateTime.now())
			);
			contactRepository.saveAll(contacts);
		};
	}
}
