package com.example.stamp.MngPlcInteractors;


import lombok.Builder;
import lombok.Data;

public class ResponseDto {
    @Builder
    @Data
    public static class plcSearchDto{
        private Long id;

        private  String plcName;

        private String lat;

        private String lng;

        private String imgUrl;

        private String category;

        private Long cost;

        private String maker;
    }
}
