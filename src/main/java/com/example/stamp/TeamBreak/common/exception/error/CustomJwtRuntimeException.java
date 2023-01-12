package com.example.stamp.TeamBreak.common.exception.error;

import com.example.stamp.TeamBreak.common.exception.ErrorCode;

public class CustomJwtRuntimeException extends RuntimeException{
    public CustomJwtRuntimeException(){
        super(ErrorCode.AUTHENTICATION_FAILED.getMessage());
    }
}
