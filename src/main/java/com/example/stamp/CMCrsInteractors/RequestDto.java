package com.example.stamp.CMCrsInteractors;

import com.example.stamp.Entities.Usr;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

public class RequestDto {

    @Builder
    @Data
    public static class CrsCreateDto {
        private Long usr;
       private Long countDay;
       private String crsName;
       private String imgUrl;
    }
    @Builder
    @Data
    public static class matchDayPlcDto{
        private Long aDay;
        private Long plc;
        private Date dateTime;

    }
}
