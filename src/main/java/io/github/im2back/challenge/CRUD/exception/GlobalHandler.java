package io.github.im2back.challenge.CRUD.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.im2back.challenge.CRUD.service.exeptions.ClientNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<StandardError> clientNotFoundException(ClientNotFoundException ex, HttpServletRequest request){
		
		StandardError standardError = new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		standardError.setStatus(status.value());
		standardError.setError("Not Found");
		standardError.setMessage(ex.getMessage());
		standardError.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErrorBeanValidation> methodArgumentNotValidException(
			MethodArgumentNotValidException ex, HttpServletRequest request) {

		StandardErrorBeanValidation standardError = new StandardErrorBeanValidation();
		List<String> messages = new ArrayList<>();

		ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
			messages.add(fieldError.getField() + " : " + fieldError.getDefaultMessage());
		});

		standardError.setError("UNPROCESSABLE ENTITY");
		standardError.setPath(request.getRequestURI());
		standardError.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		standardError.setMessage(messages);

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(standardError);

	}
	
	
}
