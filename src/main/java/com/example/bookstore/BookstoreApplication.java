package com.example.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.repositories.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática", "Livros de Ciência da Computação");
		Category cat2 = new Category(null, "Filosofia", "Livros sobre as coisas do alto");
		
		Book book1 = new Book(null, "Clean Code", "Robert C. Martin", "Lorem ipsum", cat1);
		Book book2 = new Book(null, "A Caverna", "Platão", "Lorem ipsum", cat2);
		Book book3 = new Book(null, "O Jardim das Aflições", "Olavo de Carvalho", "Lorem ipsum", cat2);
		Book book4 = new Book(null, "Conceitos de Linguagem de Programação", "Robert Sebestta", "Lorem ipsum", cat1);
		
		cat1.getBookList().addAll(Arrays.asList(book1, book2, book3, book4));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4));
	}

}
