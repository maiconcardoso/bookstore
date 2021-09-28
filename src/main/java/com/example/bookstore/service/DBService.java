package com.example.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.repositories.CategoryRepository;

@Service
public class DBService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	BookRepository bookRepository;

	public void instanceDataBase() {
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
