package com.example.stamp.PlcCmtInteractors;


import com.example.stamp.Entities.PlcCmt;
import com.example.stamp.Entities.PlcEntity;
import com.example.stamp.Entities.UserEntity;

import lombok.Builder;
import lombok.Data;


public class RequestPlcCmtDto {

    @Data
    public static class RequestLoadPlcCmtDto {

        private Long PlcId;


    }

    @Builder
    @Data
    public static class RequestPostPlcCmtDto {

        private Long UserId;
        private Long PlcId;
        private String Content;


        protected PlcCmt of() {
            return PlcCmt.builder()
                    .UserId(UserEntity.builder().id(this.UserId).build())
                    .PlcId(PlcEntity.builder().id(this.PlcId).build())
                    .Content(this.Content)
                    .build();
        }
    }

    @Builder
    @Data
    public static class RequestUpdatePlcCmtDto {


        private Long Id;
        private String Content;


        protected PlcCmt of() {
            return PlcCmt.builder()
                    .Content(this.Content)
                    .build();
        }

    }


    @Data
    public static class RequestDeletePlcCmtDto {


        private Long Id;


    }


}
