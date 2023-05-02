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


        protected CrsCmt of() {
            return CrsCmt.builder()
                    .Content(this.Content)
                    .build();
        }
    }

    @Builder
    @Data
    public static class RequestSetCrsCmtDto {

            private Long UserId;
            private Long CrsId;
            private String Content;


            protected CrsCmt of() {
                return CrsCmt.builder()
                        .UserId(UserEntity.builder().id(this.UserId).build())
                        .CrsId(CrsEntity.builder().id(this.CrsId).build())
                        .Content(this.Content)
                        .build();
            }
        }


    @Data
    public static class RequestDeleteCrsCmtDto {
        private Long Id;

    }

}
