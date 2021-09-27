package com.example.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

	private Long id;
	private String name;
	private String description;
	
	private List<Book> bookList = new ArrayList<>();
}
