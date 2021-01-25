package com.Ebug.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) 
public class TicketNotFoundException extends RuntimeException {
	private String msg;
	private String statusCode;
	
	public TicketNotFoundException(String msg, String statusCode) {
		super();
		this.msg = msg;
		this.statusCode = statusCode;
	}

	TicketNotFoundException() {
		super();
	}
}
