package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Book;
import com.example.bookstore.exceptions.EntityNotFoundException;
import com.example.bookstore.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryService categoryService;

	public Book findById(Long id) {
		Optional<Book> obj = bookRepository.findById(id);
		return obj.orElseThrow(() -> new EntityNotFoundException("Objeto não encontrado! id: " + id));
	}

	public List<Book> findAll(Long id_cat) {
		categoryService.findById(id_cat);
		return bookRepository.findByCategory(id_cat);
	}
}
