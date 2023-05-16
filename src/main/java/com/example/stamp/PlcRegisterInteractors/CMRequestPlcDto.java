package com.example.stamp.PlcRegisterInteractors;

import com.example.stamp.Entities.Plc;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CMRequestPlcDto {
    @Data
    @Builder
    public static class createPlcDto {

        private String plcName;
        private String lat;
        private String lng;
        private String imgUrl;
        private String category;
        private Long cost;


        public static Plc toEntity(createPlcDto createPlcDto) {
            return Plc.builder()
                    .plcName(createPlcDto.getPlcName())
                    .lat(createPlcDto.getLat())
                    .lng(createPlcDto.getLng())
                    .imgUrl(createPlcDto.getImgUrl())
                    .category(createPlcDto.getCategory())
                    .cost(createPlcDto.getCost())
                    .build();
        }
    }


}
