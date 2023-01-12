package com.example.ReactSpringChatBackEnd.common.exception.error;

import com.example.ReactSpringChatBackEnd.common.exception.ErrorCode;

public class LoginFailedException extends RuntimeException{
    public LoginFailedException(){
        super(ErrorCode.LOGIN_FAILED.getMessage());
    }
}
