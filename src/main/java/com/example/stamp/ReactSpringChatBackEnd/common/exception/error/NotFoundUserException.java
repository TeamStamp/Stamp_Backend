package com.example.stamp.ReactSpringChatBackEnd.common.exception.error;

import com.example.stamp.ReactSpringChatBackEnd.common.exception.ErrorCode;

public class NotFoundUserException extends RuntimeException{
    public NotFoundUserException(){
        super(ErrorCode.NOT_FOUND_USER.getMessage());
    }
}
