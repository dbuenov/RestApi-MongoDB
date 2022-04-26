package cat.dbuenov.app.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class HandlerErrors {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseException> handlerUserNotFound(UserNotFoundException ex, WebRequest request) {
		ResponseException response = new ResponseException(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
		return new ResponseEntity<ResponseException> (response, HttpStatus.NOT_FOUND);
	}	
	
	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<ResponseException> handlerUserExist(UserExistException ex, WebRequest request) {
		ResponseException response = new ResponseException(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.CONFLICT.getReasonPhrase());
		return new ResponseEntity<ResponseException> (response, HttpStatus.CONFLICT);
	}	
}


