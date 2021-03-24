package com.example.multimodule.exception;

public class FeignErrorDecoder extends Exception{
    public FeignErrorDecoder(String message) {
        super(message);
    }
}
