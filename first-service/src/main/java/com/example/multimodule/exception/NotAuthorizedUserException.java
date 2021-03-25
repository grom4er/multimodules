package com.example.multimodule.exception;

import feign.FeignException;

public class NotAuthorizedUserException extends FeignException {
    public NotAuthorizedUserException(int status, String message) {
        super(status, message);
    }
}
