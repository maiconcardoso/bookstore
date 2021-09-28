package com.example.bookstore.dtos;

import com.example.bookstore.domain.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryDTO {

	private Long id;
	private String name;
	private String description;
	
	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.description = category.getDescription();
	}
	
}
