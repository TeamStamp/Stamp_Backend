package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.Entities.VisitedCrs;
import lombok.Builder;
import lombok.Data;

public class RequestCrs {

    @Data
    @Builder
    public static class VisitPlcDto{

        private Long crsId;
        private Long plcId;
        private boolean visited;
    }

    public static VisitedCrs toFirstEntity(String usrEmail, Long crsId){
        return VisitedCrs.builder()
                .usrEmail(usrEmail)
                .crsId(crsId)
                .crtStamp(1L)
                .build();
    }
}
