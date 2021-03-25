package com.example.multimodule.controlleradvice;

import feign.FeignException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ControllerAdvice
public class FeignExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ResponseStatusException.class, Exception.class, FeignException.class})
    protected String handleException(FeignException e, HttpResponse response) {
        HttpRequest request = response.request();
        URI uri = request.uri();

        return String.format("Problem to load page %s", uri);
    }
}
