package com.example.stamp.common.dto;

import com.example.stamp.common.entity.DayEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Long CourseId;
    private Long PlaceId;
    private Integer DayX;


    public static DayDto createDayDto(DayEntity Day) {
        return new DayDto(

                Day.getId(),
                Day.getCourseId(),
                Day.getPlaceId(),
                Day.getDayX()
        );
    }
}