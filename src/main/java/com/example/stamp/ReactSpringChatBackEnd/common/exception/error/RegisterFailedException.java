package com.example.stamp.ReactSpringChatBackEnd.common.exception.error;

import com.example.stamp.ReactSpringChatBackEnd.common.exception.ErrorCode;

public class RegisterFailedException extends RuntimeException{
    public RegisterFailedException(){
        super(ErrorCode.AUTHENTICATION_CONFLICT.getMessage());
    }
}