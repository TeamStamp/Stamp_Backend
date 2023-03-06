package com.example.stamp.UnknownPersonInteractors.exception.error;

import com.example.stamp.UnknownPersonInteractors.exception.ErrorCode;

public class CustomJwtRuntimeException extends RuntimeException{
    public CustomJwtRuntimeException(){
        super(ErrorCode.AUTHENTICATION_FAILED.getMessage());
    }
}
