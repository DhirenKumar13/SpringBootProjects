package com.udemy.springboot.restapi.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timeOfError;
	private String errorCode;
	private String errorDescription;
	
	public ExceptionResponse(Date timeOfError, String errorCode, String errorDescription) {
		super();
		this.timeOfError = timeOfError;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public Date getTimeOfError() {
		return timeOfError;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}
}
