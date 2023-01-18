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