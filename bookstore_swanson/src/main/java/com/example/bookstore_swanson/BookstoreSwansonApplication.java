package com.example.bookstore_swanson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore_swanson.domain.Book;
import com.example.bookstore_swanson.domain.BookstoreRepository;

@SpringBootApplication
public class BookstoreSwansonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreSwansonApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookstoreRepository repository) {
		return (args) -> {
			Book one = new Book("Spare", "Prince Harry", "2023", "9781039003750", 20.50);
			Book two = new Book("The House In The Pines", "Ana Reyes", "2023", "9780593186718", 17.80);
			Book three = new Book("Atomic Habits", "James Clear", "2018", "9780735211292", 26.00);
			
			repository.save(one);
			repository.save(two);
			repository.save(three);
			
		};
	}
}
