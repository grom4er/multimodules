package com.example.multimodule.client;

import com.example.multimodule.exception.NotAuthorizedUser;
import com.example.multimodule.exception.UnexpectedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ErrorDecoderConfiguration implements ErrorDecoder {
    @Override
    public Exception decode(String information, Response response) {
        if(response.status() == 401){
            throw new NotAuthorizedUser("Data " +  response.request().toString();)
        }
        throw new UnexpectedException()

    }
}
