package com.example.multimodule.controller.advice;

import com.example.multimodule.exception.NotAuthorizedUserException;
import com.example.multimodule.exception.WrongDataException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class FeignExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NotAuthorizedUserException.class})
    protected ResponseEntity<Object> handleAuthorizedException(RuntimeException exception, WebRequest request) {
        String response = "Authorized problem. Please check you data and try again";
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(value = {WrongDataException.class})
    protected ResponseEntity<Object> handleWrongDataException(RuntimeException exception, WebRequest request) {
        String response = "Server take wrong data. Please, check data.";
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


}
