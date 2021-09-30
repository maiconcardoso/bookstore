package com.example.bookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class ValidationError extends StandardError {
	
	@Getter
	@Setter
	private List<FieldMessage> errors = new ArrayList<>();
	

	public ValidationError() {
		super();
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
}
