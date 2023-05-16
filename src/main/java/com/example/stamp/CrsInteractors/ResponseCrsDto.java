package com.example.stamp.CrsInteractors;
import lombok.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


public  class ResponseCrsDto {
    @Builder
    @Data
    public static class ResponseAllCrsDto {
        private Long id;
        private String crsName;
        private String imgUrl;
        private String maker;
    }
    @Builder
    @Data
    public static class ResponseOneCrsDto {
        private Long id;
        private String crsName;
        private String imgUrl;
        private String maker;
        private List<LinkedDayDto> days;

    }
    @Builder
    @Data
    public static class LinkedDayDto {
        private Long id;
        private Integer dayx;
        private List<LinkedPlcDto> plc;
    }
    @Builder
    @Data
    public static class LinkedPlcDto {
        private Long id;
        private Date dateTime;
        private String plcName;
        private String imgUrl;
        private Long cost;
    }
}