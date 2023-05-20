package com.example.stamp.PlcInteractors;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponsePlcDto {
    private Long id;
    private String plcName;
    private String lat;
    private String lng;
    private String imgUrl;
    private String category;
    private String writer;
    private Long cost;
}