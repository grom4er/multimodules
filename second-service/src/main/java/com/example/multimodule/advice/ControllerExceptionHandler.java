package com.example.multimodule.advice;

import com.example.multimodule.exception.ControllerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ControllerException.class})
    protected ResponseEntity<Object> handleControllerWithoutParamException(Exception exception, WebRequest request) {
        String response = "Request without param or with error. Try again";
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.EXPECTATION_FAILED, request);
    }
}