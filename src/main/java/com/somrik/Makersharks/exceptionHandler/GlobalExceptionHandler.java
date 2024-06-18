
package com.somrik.Makersharks.exceptionHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentHandler(MethodArgumentNotValidException ex)
	{

			Map<String, String> errors = new HashMap<>();

			ex.getFieldErrors().forEach((e) -> {
				String field = e.getField();
				String msg = e.getDefaultMessage();
				errors.put(field, msg);
			});

			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
