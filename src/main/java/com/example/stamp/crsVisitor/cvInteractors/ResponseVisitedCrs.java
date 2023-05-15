package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.Entities.VisitedCrs;
import com.example.stamp.Entities.VisitedPlc;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class ResponseVisitedCrs {

    @Data
    @Builder
    public static class RpGetVCrsDto{

        private Long usrId;
        private Long crsId;
        private List<VisitedPlc> vPlcList;

        public static RpGetVCrsDto toDto(VisitedCrs visitedCrs, List<VisitedPlc> visitedPlcList){
            return RpGetVCrsDto.builder()
                    .usrId(visitedCrs.getUsrId())
                    .crsId(visitedCrs.getCrsId())
                    .vPlcList(visitedPlcList)
                    .build();
        }
    }

    @Builder
    @Data
    public static class VPlcListDto{
        private Long plcId;
        private boolean visited;

        public static VPlcListDto toDto(VisitedPlc vPlc){
            return VPlcListDto.builder()
                    .plcId(vPlc.getPlcId())
                    .visited(vPlc.isVisited())
                    .build();
        }
    }

}
