package com.example.stamp.CMPlcInteractors;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RequestPlcDto {
    @Data
    @Builder
    public static class createPlcDto {

        private String plcName;
        private String lat;
        private String lng;
        private String category;
        private Long cost;





    }


}
