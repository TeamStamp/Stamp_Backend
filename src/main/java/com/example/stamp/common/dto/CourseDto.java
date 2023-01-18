package com.example.stamp.common.dto;

import com.example.stamp.common.entity.CourseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CourseDto {
    private Long Id;
    private String CourseName;
    private Long CourseMakerId;


    public static CourseDto createCourseDto(CourseEntity Course) {
        return new CourseDto(

                Course.getId(),
                Course.getCourseName(),
                Course.getCourseMaker().getId()

        );

    }

}