package com.example.stamp.TeamBreak.common.exception.error;

import com.example.stamp.TeamBreak.common.exception.ErrorCode;

public class NotFoundUserException extends RuntimeException{
    public NotFoundUserException(){
        super(ErrorCode.NOT_FOUND_USER.getMessage());
    }
}
