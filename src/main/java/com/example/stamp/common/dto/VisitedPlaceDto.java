package com.example.stamp.common.dto;


import com.example.stamp.common.entity.VisitedPlaceEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class VisitedPlaceDto {
    private Long Id;
    private Long VisitorId;
    private Long PlaceId;

    public static VisitedPlaceDto createVisitedPlaceDto(VisitedPlaceEntity Visitedplace) {
        return new VisitedPlaceDto(

                Visitedplace.getId(),
                Visitedplace.getVisitorId(),
                Visitedplace.getPlaceId()
        );

    }

}