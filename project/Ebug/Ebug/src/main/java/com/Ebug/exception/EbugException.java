package com.Ebug.exception;

public class EbugException extends RuntimeException{
	private String msg;
	private String statusCode;
	
 public EbugException(String message) {
	 super(message);
 }

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

public String getStatusCode() {
	return statusCode;
}

public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
}

public EbugException(String msg, String statusCode) {
	super();
	this.msg = msg;
	this.statusCode = statusCode;
}
 
}