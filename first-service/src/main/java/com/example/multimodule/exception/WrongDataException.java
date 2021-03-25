package com.example.multimodule.exception;

import feign.FeignException;

public class WrongDataException extends FeignException {
    public WrongDataException(int status, String message) {
        super(status, message);
    }
}
