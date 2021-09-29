package com.example.bookstore.dtos;

import com.example.bookstore.domain.Book;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookDTO{

	private Long id;
	private String title;
	
	public BookDTO(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
	}
}
