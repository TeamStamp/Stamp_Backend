package com.example.stamp.UnknownPersonInteractors.exception.error;

import com.example.stamp.UnknownPersonInteractors.exception.ErrorCode;

public class LoginFailedException extends RuntimeException{
    public LoginFailedException(){
        super(ErrorCode.LOGIN_FAILED.getMessage());
    }
}
