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
    private Long CourseId;

    @Column
    private Long PlaceId;

    @Column
    private Integer DayX;

    public static DayEntity createDay(DayDto dto) {
        //엔티티 생성 및 반환
        return new DayEntity(
                dto.getId(),
                dto.getCourseId(),
                dto.getPlaceId(),
                dto.getDayX());
    }
}
