package com.ibm.fsp.archive.dashboardbackend.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

 

/**
 * Handle exceptions of the project
 * 
 */
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	/**
	 * Handle exception of years out of expected range
	 * @param ex is the exception
	 * @param WebRequest is the web request
	 * @return the exception with error and status
	 * 
	 */
	@ExceptionHandler(YearOutofRangeException.class)
	public final ResponseEntity<ErrorDetails> handleYearOutofRangeException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
}
