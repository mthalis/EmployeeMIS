package com.mthalis.noetic.employeemis.exception;

import java.util.Date;

public class ExceptionResponse {

	private int status;
	private Date timestamp;
	private String message;
	private String details;

	public ExceptionResponse(int status, Date timestamp, String message, String details) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public int getStatus() {
		return status;
	}
}
