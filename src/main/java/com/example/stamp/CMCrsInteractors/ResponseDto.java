package com.example.stamp.CMCrsInteractors;

import com.example.stamp.Entities.aDay;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

public class ResponseDto {
    @Builder
    @Data
    public static class CrsCreateDto{
        private Long crs;
        private Long[] days;

        private Date firstDay;
        private Date lastDay;
        private Long period;

    }

    @Builder
    @Data
    public static class matchDayPlcDto{
        private Long aDay;
        private Long plc;
        private Date dateTime;

    }
}
