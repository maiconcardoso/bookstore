package com.example.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

	private Long id;
	private String title;
	private String authorName;
	private String text;
	
	private Category category;
}
