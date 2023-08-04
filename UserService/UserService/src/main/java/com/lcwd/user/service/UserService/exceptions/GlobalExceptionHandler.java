package com.lcwd.user.service.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.UserService.payload.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResoirceNotFoundException(ResourceNotFoundException ex){
		
		String message = ex.getMessage();

		ApiResponse apiResponse = new ApiResponse(message, true, HttpStatus.NOT_FOUND);
		
	 return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
		
		
	}

}
