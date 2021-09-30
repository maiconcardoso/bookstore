package com.example.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.domain.Book;
import com.example.bookstore.dtos.BookDTO;
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
	
	@GetMapping
	public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Long id_cat) {
		List<Book> bookList = bookService.findAll(id_cat);
		List<BookDTO> bookListDTO = bookList.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(bookListDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book obj) {
		Book newObj = bookService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Book> updatePatch(@PathVariable Long id, @RequestBody Book obj) {
		Book newObj = bookService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
}
