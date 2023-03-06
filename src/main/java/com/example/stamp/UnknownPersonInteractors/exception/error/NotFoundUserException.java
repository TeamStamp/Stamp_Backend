package com.example.stamp.UnknownPersonInteractors.exception.error;

import com.example.stamp.UnknownPersonInteractors.exception.ErrorCode;

public class NotFoundUserException extends RuntimeException{
    public NotFoundUserException(){
        super(ErrorCode.NOT_FOUND_USER.getMessage());
    }
}
