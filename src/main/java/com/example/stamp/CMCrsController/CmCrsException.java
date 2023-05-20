package com.example.stamp.CMCrsController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class CmCrsException extends RuntimeException{
    private HttpStatus status;
    private String message;

}
