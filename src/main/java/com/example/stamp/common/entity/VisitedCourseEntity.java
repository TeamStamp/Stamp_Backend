package com.example.stamp.common.entity;
import com.example.stamp.common.dto.VisitedCourseDto;
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
public class VisitedCourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private Long VisitorId;

    @Column
    private Long CourseId;

    public static VisitedCourseEntity createVisitedPlace(VisitedCourseDto dto) {
        //엔티티 생성 및 반환
        return new VisitedCourseEntity(
                dto.getId(),
                dto.getVisitorId(),
                dto.getCourseId());
    }
}
