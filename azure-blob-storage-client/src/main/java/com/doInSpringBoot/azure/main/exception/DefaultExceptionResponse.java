package com.doInSpringBoot.azure.main.exception;

import java.time.Instant;

public class DefaultExceptionResponse {
	
	private String  errorMessage;
	private String errorCode;
	private Instant timestamp;
	private String resourceUri;
	
	public DefaultExceptionResponse() {	}
	
	public DefaultExceptionResponse(String  errorMessage,String errorCode,Instant timestamp,String resourceUri ) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.timestamp = timestamp;
		this.resourceUri = resourceUri;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public String getResourceUri() {
		return resourceUri;
	}

	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}
	
}
