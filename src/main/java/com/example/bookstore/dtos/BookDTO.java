package com.example.bookstore.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.bookstore.domain.Book;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookDTO{

	private Long id;

	@NotEmpty(message = "Title field is required")
	@Length(min = 3, max = 100, message = "The title must have more than three characters.")
	private String title;
	
	public BookDTO(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
	}
}
