package com.example.stamp.common.entity;


import com.example.stamp.common.dto.DayDto;
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
public class DayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private Integer DayX;

    @ManyToOne
    @JoinColumn(name = "CourseId")
    private CourseEntity Course;
    public void changeCourseEntity(CourseEntity DayCourse){
        this.Course = Course;
        Course.getVisitedday().add(this);
    }

    @ManyToOne
    @JoinColumn(name = "PlaceId")
    private PlaceEntity Place;
    public void changePlaceEntity(PlaceEntity DayPlace){
        this.Place = Place;
        Place.getVisitedday().add(this);
    }

    public static DayEntity createDay(DayDto dto, CourseEntity course,PlaceEntity place) {
        //엔티티 생성 및 반환
        return new DayEntity(
                dto.getId(),
                dto.getDayX(),
                course, place
                );
    }
}
