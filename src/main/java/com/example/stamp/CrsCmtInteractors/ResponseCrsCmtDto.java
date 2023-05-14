package com.example.stamp.CrsCmtInteractors;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseCrsCmtDto {
    private Long id;
    private String writer;
    private String content;
}
