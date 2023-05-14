package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.CrsInteractors.ResponseCrsDto;
import com.example.stamp.Entities.Crs;
import com.example.stamp.Entities.Plc;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class cvResponseCrsDto extends ResponseCrsDto {

    @Builder
    @Data
    public static class cvGetCrsDto{

        private Long id;
        private String crsName;
        private String imgUrl;
        private String maker;
        private List<CrsPlcDto> plcList;

        public static cvGetCrsDto toDto(Crs crs, List<CrsPlcDto> plcList){
            return cvGetCrsDto.builder()
                    .id(crs.getId())
                    .crsName(crs.getCrsName())
                    .imgUrl(crs.getImgUrl())
                    .maker(crs.getUsr().getNickname())
                    .plcList(plcList)
                    .build();
        }
    }

    @Builder
    @Data
    public static class CrsPlcDto{

        private Long id;
        private String plcName;
        private String lat;
        private String lng;
        private String imgUrl;

        public static CrsPlcDto toDto(Plc plc){
            return CrsPlcDto.builder()
                    .id(plc.getId())
                    .plcName(plc.getPlcName())
                    .lat(plc.getLat())
                    .lng(plc.getLng())
                    .imgUrl(plc.getImgUrl())
                    .build();
        }
    }
}
