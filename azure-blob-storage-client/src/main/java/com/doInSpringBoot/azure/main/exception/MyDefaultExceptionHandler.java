package com.doInSpringBoot.azure.main.exception;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microsoft.azure.storage.StorageException;

@ControllerAdvice
@RestController
public class MyDefaultExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	public MyDefaultExceptionHandler() {}
	
	@ExceptionHandler(InvalidKeyException.class)
	public final ResponseEntity<Object> handleInvalidKeyException(InvalidKeyException ex, WebRequest request) throws Exception {
		DefaultExceptionResponse response = 
				new DefaultExceptionResponse(ex.getMessage(), ex.getCause().toString(), Instant.now(), request.getDescription(false));
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(URISyntaxException.class)
	public final ResponseEntity<Object> handleURISyntaxException(URISyntaxException ex, WebRequest request) throws Exception {
		DefaultExceptionResponse response = 
				new DefaultExceptionResponse(ex.getMessage(), ex.getReason(), Instant.now(),  request.getDescription(false));
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		DefaultExceptionResponse response = new DefaultExceptionResponse(
				messageSource.getMessage("validation.status", null, LocaleContextHolder.getLocale()),ex.getBindingResult().toString(),Instant.now(),  request.getDescription(false));
		
		return new ResponseEntity<>(response,HttpStatus.PRECONDITION_FAILED);
	}
	
	/*
	 *  ERROR CODE : BAD_REQUEST
		ERROR LOCALOZED MESSAGE : The specifed resource name contains invalid characters.
		ERROR HTTP STATUS CODE : 400
		ERROR MESSAGE : The specifed resource name contains invalid characters.
		ERROR CAUSE : null
		ERROR EXTENDED INFORMATION : null
	 */
	
	@ExceptionHandler(StorageException.class)
	public final ResponseEntity<Object> handleStorageException(StorageException ex, WebRequest request) throws Exception {
		DefaultExceptionResponse response = 
				new DefaultExceptionResponse(ex.getMessage(), ex.getErrorCode() , Instant.now(),  request.getDescription(false));
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		DefaultExceptionResponse response = 
				new DefaultExceptionResponse(ex.getMessage(), ex.getCause().toString(), Instant.now(), request.getDescription(false));
		return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
	}
	
}
