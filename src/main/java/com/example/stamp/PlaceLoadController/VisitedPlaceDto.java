package com.example.stamp.PlaceLoadController;


import com.example.stamp.DataGateway.Entitiy.VisitedPlaceEntity;
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

    public static VisitedPlaceDto createVisitedPlaceDto(VisitedPlaceEntity VisitedPlace) {
        return new VisitedPlaceDto(

                VisitedPlace.getId(),
                VisitedPlace.getVisitor().getId(),
                VisitedPlace.getVisitedPlace().getId()
        );

    }

}