package com.ibm.fsp.archive.dashboardbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
* Exception related to year out of range
* 
*/
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class YearOutofRangeException extends RuntimeException{
	
	public YearOutofRangeException(String message) {
		super(message);
	}

}