package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			Category cat1 = new Category("Horror");
			Category cat2 = new Category("Scifi");
			Category cat3 = new Category("History");
            crepository.save(cat1);
            crepository.save(cat2);
            crepository.save(cat3);
            
			Book b1 = new Book("Kirja1", "John Johnson", 2001, 123, 19, cat1);
			Book b2 = new Book("Kirja2", "Matt Mattson", 2002, 124, 20, cat2);
			Book b3 = new Book("Kirja3", "Kate Kateson", 2003, 125, 21, cat3);

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);

		};

	}

}
