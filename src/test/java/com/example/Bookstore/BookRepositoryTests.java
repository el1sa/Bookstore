package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTests {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByTitleShouldReturnAuthor() {
		List<Book> books = repository.findByTitle("Kirja1");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("John Johnson");
	}
	
	@Test
	public void createNewBook() {
		
		Book book = new Book("The Sun", "Heather Heather", 2017, 666, 27, 
				crepository.findByName("Horror").get(0));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	
	}
	
	


