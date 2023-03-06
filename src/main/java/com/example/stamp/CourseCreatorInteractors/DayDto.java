package com.example.stamp.CourseCreatorInteractors;

import com.example.stamp.DataGateway.Entitiy.DayEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class DayDto {
    private Long Id;
    private Integer DayX;
    private Long CourseId;
    private Long PlaceId;


    public static DayDto createDayDto(DayEntity Day) {
        return new DayDto(

                Day.getId(),
                Day.getDayX(),
                Day.getCourse().getId(),
                Day.getPlace().getId()

        );
    }
}