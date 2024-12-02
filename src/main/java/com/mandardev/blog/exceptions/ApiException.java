package com.mandardev.blog.exceptions;

public class ApiException extends RuntimeException {
	
	 private String errorCode;

	    // Constructor with message and error code
	    public ApiException(String message, String errorCode) {
	        super(message);
	        this.errorCode = errorCode;
	    }

	    // Constructor with only a message
	    public ApiException(String message) {
	        super(message);
	    }

	    // Default constructor
	    public ApiException() {
	        super("An unexpected error occurred.");
	    }

	    public String getErrorCode() {
	        return errorCode;
	    }

	    public void setErrorCode(String errorCode) {
	        this.errorCode = errorCode;
	    }

}
