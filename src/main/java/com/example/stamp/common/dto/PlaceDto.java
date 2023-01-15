package com.example.stamp.common.dto;


import com.example.stamp.common.entity.PlaceEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PlaceDto {
    private Long Id;
    private String Placename;
    //위도
    private String Lat;
    //경도
    private String Lon;

    public static PlaceDto createPlaceDto(PlaceEntity place) {
        return new PlaceDto(

                place.getId(),
                place.getPlacename(),
                place.getLat(),
                place.getLon()
        );

    }

}
