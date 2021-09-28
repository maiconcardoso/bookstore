package com.example.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Category;
import com.example.bookstore.exceptions.EntityNotFoundException;
import com.example.bookstore.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category findById(Long id) {
		Optional<Category> result = categoryRepository.findById(id);
		return result.orElseThrow(
				() -> new EntityNotFoundException(
						"Entity not found, id: " + id + ", type: " + Category.class.getName()
						)
				);
	}
}
