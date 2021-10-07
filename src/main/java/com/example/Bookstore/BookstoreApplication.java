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
import com.example.bookstore.domain.UserRepository;
import com.example.bookstore.domain.User;

@SpringBootApplication
public class BookstoreApplication {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;
	

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
			
			User user1 = new User("user", "$2a$10$MrNwbwr85OVP3DEOANer9eztRqyXbOeRxIfj3d8dS54BGL2JRpC02",
					"user1@gmail.com","USER");
			User user2 = new User("admin", "$2a$10$9rBf94.G6fktrltFZwwOAOTlaG4qDLeV4exnF7TX7Ehr4AvFUZixy",
					"user2@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};

	}

}
