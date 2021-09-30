package com.example.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Name field is required")
	@Length(min = 3, max = 100, message = "The name must have more than three characters.")
	private String name;
	
	@NotEmpty(message = "Description field is required")
	@Length(min = 3, max = 200, message = "The description must have more than three characters.")
	private String description;
	
	public Category(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}



	@OneToMany(mappedBy = "category")
	private List<Book> bookList = new ArrayList<>();
}
