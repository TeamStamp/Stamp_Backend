package com.example.ReactSpringChatBackEnd.common.exception.error;

import com.example.ReactSpringChatBackEnd.common.exception.ErrorCode;

public class RegisterFailedException extends RuntimeException{
    public RegisterFailedException(){
        super(ErrorCode.AUTHENTICATION_CONFLICT.getMessage());
    }
}