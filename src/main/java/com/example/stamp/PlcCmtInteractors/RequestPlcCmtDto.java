package com.example.stamp.PlcCmtInteractors;
import lombok.Builder;
import lombok.Data;


public class RequestPlcCmtDto {

    @Data
    public static class RequestLoadPlcCmtDto {

        private Long PlcId;

    }

    @Builder
    @Data
    public static class RequestSetPlcCmtDto {

        private Long UserId;
        private Long PlcId;
        private String Content;

    }

    @Builder
    @Data
    public static class RequestUpdatePlcCmtDto {


        private Long Id;
        private String Content;

    }


    @Data
    public static class RequestDeletePlcCmtDto {

        private Long Id;

    }


}
