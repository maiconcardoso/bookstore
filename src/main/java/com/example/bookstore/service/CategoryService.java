package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Category;
import com.example.bookstore.dtos.CategoryDTO;
import com.example.bookstore.exceptions.EntityNotFoundException;
import com.example.bookstore.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category findById(Long id) {
		Optional<Category> result = categoryRepository.findById(id);
		return result.orElseThrow(() -> new EntityNotFoundException("Entity not found, id: " + id));
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category create(Category obj) {
		obj.setId(null);
		return categoryRepository.save(obj);
	}

	public Category update(CategoryDTO objDTO, Long id) {
		Category obj = findById(id);
		obj.setName(objDTO.getName());
		obj.setDescription(objDTO.getDescription());
		return categoryRepository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			categoryRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.example.bookstore.exceptions.DataIntegrityViolationException(
					"Não pode ser deletado! Possui Objetos Relacionados");
		}
	}
}
