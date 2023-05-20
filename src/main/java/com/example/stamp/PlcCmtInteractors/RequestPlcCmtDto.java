package com.example.stamp.PlcCmtInteractors;
import lombok.Builder;
import lombok.Data;


public class RequestPlcCmtDto {

    @Data
    public static class RequestLoadPlcCmtDto {

        private Long plc;

    }

    @Builder
    @Data
    public static class RequestSetPlcCmtDto {


        private Long plc;
        private String content;

    }

    @Builder
    @Data
    public static class RequestUpdatePlcCmtDto {


        private Long plc;
        private String content;

    }


    @Data
    public static class RequestDeletePlcCmtDto {

        private Long id;

    }


}
