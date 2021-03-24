package com.example.multimodule.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FeignExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ResponseStatusException.class, Exception.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException exception, WebRequest request) {
        String response = "Exception by path: " + request.getDescription(false);
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
