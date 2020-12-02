package com.example.demo.Excpetion;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandller extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { Exception.class ,NullPointerException.class,NotFoundUserException.class})
	public ResponseEntity<Object> apierror(Exception ex, WebRequest request) {
		String errorMessage = ex.getLocalizedMessage();
		if (errorMessage == null)
			errorMessage = ex.toString();
//		APIerror error = new APIerror(request.s, message, errors)
		APIerror error = new APIerror(new Date(), errorMessage);
		return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.OK );

	}

}
