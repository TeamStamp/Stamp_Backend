package com.example.stamp.PlcInteractors;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponsePlcDto {
    private Long id;
    private String PlcName;
    private String Lat;
    private String Lng;
    private String ImgUrl;
    private String Category;
    private Long UserId;
    private Long Cost;
}