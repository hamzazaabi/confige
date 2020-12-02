package com.example.demo.Excpetion;

import java.util.Date;

public class APIerror {
	private Date timestamp;
	private String message;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public APIerror(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}
	public APIerror() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
