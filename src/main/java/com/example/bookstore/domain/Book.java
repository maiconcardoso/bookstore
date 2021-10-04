 package com.example.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_book")
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Title field is required")
	@Length(min = 3, max = 100, message = "The title must have more than three characters.")
	private String title;
	
	@NotEmpty(message = "Author field is required")
	@Length(min = 3, max = 100, message = "The Author must have more than three characters.")
	private String authorName;
	
	@NotEmpty(message = "Text field is required")
	@Length(min = 3, max = 2000000, message = "The Text must have more than three characters.")
	private String text;
	
	
	public Book(Long id, String title, String authorName, String text) {
		this.id = id;
		this.title = title;
		this.authorName = authorName;
		this.text = text;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

}
