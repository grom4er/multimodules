package com.example.multimodule.client;

import com.example.multimodule.exception.NotAuthorizedUserException;
import com.example.multimodule.exception.WrongDataException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ErrorDecoderConfiguration implements ErrorDecoder {
    @Override
    public Exception decode(String information, Response response) {
        if (response.status() == 401) {
            throw new NotAuthorizedUserException(response.status(), "Incorrect authorize data");
        }
        throw new WrongDataException(response.status(), "Wrong data");
    }
}
