package com.example.stamp.CrsCmtInteractors;


import lombok.Builder;
import lombok.Data;

public class RequestCrsCmtDto {


    @Data
    public static class RequestLoadCrsCmtDto {
        private Long crs;
    }


    @Builder
    @Data
    public static class RequestUpdateCrsCmtDto {

        private Long id;
        private String content;

    }

    @Builder
    @Data
    public static class RequestSetCrsCmtDto {

            private Long crs;
            private String content;

        }


    @Data
    public static class RequestDeleteCrsCmtDto {
        private Long id;

    }

}
