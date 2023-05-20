package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.Entities.VisitedCrs;
import com.example.stamp.Entities.VisitedPlc;
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

    public static VisitedCrs toFirstEntity(String usrEmail, Long crsId, String crsName){
        return VisitedCrs.builder()
                .usrEmail(usrEmail)
                .crsId(crsId)
                .crsName(crsName)
                .crtStamp(1L)
                .build();
    }

    public static VisitedPlc toVPlc(VisitPlcDto visitPlcDto, String email){
        return VisitedPlc.builder()
                .plcId(visitPlcDto.getPlcId())
                .usrEmail(email)
                .visited(visitPlcDto.isVisited())
                .build();
    }
}
