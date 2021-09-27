package com.example.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
