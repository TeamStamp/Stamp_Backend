package com.example.stamp.common.entity;


import com.example.stamp.common.dto.CourseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private  String CourseName;
    @Column
    private Long CourseMakerId;


    public static CourseEntity createCourse(CourseDto dto) {
        //엔티티 생성 및 반환
        return new CourseEntity(
                dto.getId(),
                dto.getCourseName(),
                dto.getCourseMakerId());

    }

    //예외처리 하게 되면 사용
//    public void patch(CourseDto dto) {
//
//        //객체를 갱신
//        if(dto.getCourseName()!=null)
//            this.CourseName = dto.getCourseName();
//        if(dto.getCourseMakerId()!=null)
//            this.CourseMakerId = dto.getCourseMakerId();
//
//    }
}