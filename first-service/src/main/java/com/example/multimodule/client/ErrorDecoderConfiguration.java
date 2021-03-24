package com.example.multimodule.client;

import com.example.multimodule.exception.FeignErrorDecoder;
import feign.Response;

public class ErrorDecoderConfiguration implements feign.codec.ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        return new FeignErrorDecoder(response.reason());
    }
}
