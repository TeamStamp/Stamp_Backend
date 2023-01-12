package com.example.stamp.TeamBreak.common.exception.error;

import com.example.stamp.TeamBreak.common.exception.ErrorCode;

public class LoginFailedException extends RuntimeException{
    public LoginFailedException(){
        super(ErrorCode.LOGIN_FAILED.getMessage());
    }
}
