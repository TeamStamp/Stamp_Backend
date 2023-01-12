package com.example.stamp.ReactSpringChatBackEnd.common.exception.error;

import com.example.stamp.ReactSpringChatBackEnd.common.exception.ErrorCode;

public class CustomJwtRuntimeException extends RuntimeException{
    public CustomJwtRuntimeException(){
        super(ErrorCode.AUTHENTICATION_FAILED.getMessage());
    }
}
