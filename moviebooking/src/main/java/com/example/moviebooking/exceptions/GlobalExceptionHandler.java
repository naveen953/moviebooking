package com.example.moviebooking.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

	@ControllerAdvice
	public class GlobalExceptionHandler {

	    @ExceptionHandler(InsufficientSeatCountException.class)
	    public ResponseEntity<String> handle(InsufficientSeatCountException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    
	    @ExceptionHandler(BookingNotFoundException.class)
	    public ResponseEntity<String> handle(BookingNotFoundException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }


	    
	}



