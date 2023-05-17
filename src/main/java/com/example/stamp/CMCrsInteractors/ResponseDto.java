package com.example.stamp.CMCrsInteractors;

import com.example.stamp.Entities.aDay;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class ResponseDto {
    @Builder
    @Data
    public static class CrsCreateDto{
        private Long crs;
        private List<aDayDto> days;
    }

    @Builder
    @Data
    public static class aDayDto{
        private Integer dayx;

    }
}
