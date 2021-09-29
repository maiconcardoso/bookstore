package com.example.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.domain.Book;
import com.example.bookstore.service.BookService;


@RestController
@RequestMapping(value = "/books")
public class BookResource {
	
	@Autowired
	BookService bookService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {
		Book obj = bookService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
