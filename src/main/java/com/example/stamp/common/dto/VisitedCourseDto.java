package com.example.stamp.common.dto;

import com.example.stamp.common.entity.VisitedCourseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class VisitedCourseDto {
    private Long Id;
    private Long VisitorId;
    private Long CourseId;

    public static VisitedCourseDto createVisitedCourseDto(VisitedCourseEntity VisitedCourse) {
        return new VisitedCourseDto(

                VisitedCourse.getId(),
                VisitedCourse.getVisitor().getId(),
                VisitedCourse.getVisitedCourse().getId()
        );

    }

}