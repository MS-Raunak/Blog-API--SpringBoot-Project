package com.ms.blog.payloads;

public class ApiResponse {
	private String message;
	private boolean success;
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		return message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ApiResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	
	
}
