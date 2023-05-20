package com.example.stamp.PlcInteractors;
import lombok.Data;


public class RequestDto {
    @Data
    public static class RequestPlcDto {
        private Long id; //장소의 아이디
    }
    @Data
    public static class RequestSearchDto{
        private String search;
    }


}