package com.example.multimodule.exception;

import feign.FeignException;

public class NotAuthorizedUser extends Exception {

    public NotAuthorizedUser(String message) {
        super(message);
    }
}
