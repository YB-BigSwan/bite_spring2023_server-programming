package com.example.bookstore_swanson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore_swanson.domain.Book;
import com.example.bookstore_swanson.domain.BookstoreRepository;
import com.example.bookstore_swanson.domain.Category;
import com.example.bookstore_swanson.domain.CategoryRepository;

import com.example.bookstore_swanson.domain.User;
import com.example.bookstore_swanson.domain.UserRepository;

@SpringBootApplication
public class BookstoreSwansonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreSwansonApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookstoreRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			crepository.save(new Category("Biography"));
			crepository.save(new Category("Thriller"));
			crepository.save(new Category("Self-help"));
			
			Book one = new Book("Spare", "Prince Harry", "2023", "9781039003750", 20.50, crepository.findByName("Biography").get(0));
			Book two = new Book("The House In The Pines", "Ana Reyes", "2023", "9780593186718", 17.80, crepository.findByName("Thriller").get(0));
			Book three = new Book("Atomic Habits", "James Clear", "2018", "9780735211292", 26.00, crepository.findByName("Self-help").get(0));
			
			brepository.save(one);
			brepository.save(two);
			brepository.save(three);
			
			urepository.save(new User("user","$2a$12$K7SUnwVdX.n3.mmiIoSewePhC2w4dv15gLuMR9sFbNeicQ7BgYecK","email@gmail.com" ,"USER"));
			urepository.save(new User("ADMIN", "$2a$12$K7SUnwVdX.n3.mmiIoSewePhC2w4dv15gLuMR9sFbNeicQ7BgYecK", "email@yahoo.com" ,"ADMIN"));
			
		};
	}
}
