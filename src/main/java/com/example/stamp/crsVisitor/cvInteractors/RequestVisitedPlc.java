package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.Entities.VisitedPlc;
import lombok.Builder;
import lombok.Data;

public class RequestVisitedPlc {

    @Builder
    @Data
    public static class VPlcRq{
        private String usrEmail;
        private Long plcId;

        public static VisitedPlc toEntity(String usrEmail, Long plcId){
            return VisitedPlc.builder()
                    .usrEmail(usrEmail)
                    .plcId(plcId)
                    .build();
        }
    }
}
