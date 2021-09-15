package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Kirja1", "John Johnson", 2001, 123, 19);
			Book b2 = new Book("Kirja2", "Matt Mattson", 2002, 124, 20);
			Book b3 = new Book("Kirja3", "Kate Kateson", 2003, 125, 21);

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);

		};

	}

}
