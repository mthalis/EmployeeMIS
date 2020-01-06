package com.mthalis.noetic.employeemis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DepartmentNotFoundException(String exception) {
		super(exception);
	}

}