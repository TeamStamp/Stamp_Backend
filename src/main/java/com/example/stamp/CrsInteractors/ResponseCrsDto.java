package com.example.stamp.CrsInteractors;
import lombok.*;
import java.util.Date;
import java.util.Set;


public  class ResponseCrsDto {
    @Builder
    @Data
    public static class ResponseAllCrsCmtDto {
        private Long id;
        private String CrsName;
        private String ImgUrl;
        private Long UserId;
    }
    @Builder
    @Data
    public static class ResponseOneCrsDto {
        private Long id;
        private String CrsName;
        private String ImgUrl;
        private Long UserId;
        private Set<LinkedDayDto> Dayx;

    }
    @Builder
    @Data
    public static class LinkedDayDto {
        private Long id;
        private Integer Dayx;
        private Set<LinkedPlcDto> Plc;
    }
    @Builder
    @Data
    public static class LinkedPlcDto {
        private Long id;
        private Date DateTime;
        private String PlcName;
        private String ImgUrl;
        private Long Cost;
    }
}