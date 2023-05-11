package com.example.stamp.CrsCmtInteractors;


import com.example.stamp.Entities.CrsCmt;
import com.example.stamp.Entities.CrsEntity;
import com.example.stamp.Entities.UserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
public class RequestCrsCmtDto {


    @Data
    public static class RequestLoadCrsCmtDto {
        private Long CrsId;
    }


    @Builder
    @Data
    public static class RequestUpdateCrsCmtDto {

        private Long Id;
        private String Content;

    }

    @Builder
    @Data
    public static class RequestSetCrsCmtDto {

            private Long UserId;
            private Long CrsId;
            private String Content;

        }


    @Data
    public static class RequestDeleteCrsCmtDto {
        private Long Id;

    }

}
