package com.example.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Book;
import com.example.bookstore.exceptions.EntityNotFoundException;
import com.example.bookstore.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public Book findById(Long id) {
		Optional<Book> obj = bookRepository.findById(id);
		return obj.orElseThrow(() -> new EntityNotFoundException("Objeto não encontrado! id: " + id));
	}
}
