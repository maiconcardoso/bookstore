package com.example.bookstore.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.bookstore.domain.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryDTO {

	private Long id;

	@NotEmpty(message = "Name field is required")
	@Length(min = 3, max = 100, message = "The name must have more than three characters.")
	private String name;
	
	@NotEmpty(message = "Description field is required")
	@Length(min = 3, max = 200, message = "The description must have more than three characters.")
	private String description;
	
	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.description = category.getDescription();
	}
	
}
