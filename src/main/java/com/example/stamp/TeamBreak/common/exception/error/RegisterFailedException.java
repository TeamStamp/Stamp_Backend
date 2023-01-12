package com.example.stamp.TeamBreak.common.exception.error;

import com.example.stamp.TeamBreak.common.exception.ErrorCode;

public class RegisterFailedException extends RuntimeException{
    public RegisterFailedException(){
        super(ErrorCode.AUTHENTICATION_CONFLICT.getMessage());
    }
}