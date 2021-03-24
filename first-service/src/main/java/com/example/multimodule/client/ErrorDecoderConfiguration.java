package com.example.multimodule.client;

import feign.Response;

public class ErrorDecoderConfiguration implements feign.codec.ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        return new Exception(response.reason());
    }
}
