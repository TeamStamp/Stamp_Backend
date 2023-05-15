package com.example.stamp.MngPlcInteractors;

import lombok.Data;

public class RequestDto {
    @Data
    public static class RequestAcceptDto{
        private Long id;

    }
    @Data
    public static class RequestSearchDto{
        private String search;
    }
}
