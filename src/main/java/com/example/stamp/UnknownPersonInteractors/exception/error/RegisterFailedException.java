package com.example.stamp.UnknownPersonInteractors.exception.error;

import com.example.stamp.UnknownPersonInteractors.exception.ErrorCode;

public class RegisterFailedException extends RuntimeException{
    public RegisterFailedException(){
        super(ErrorCode.AUTHENTICATION_CONFLICT.getMessage());
    }
}