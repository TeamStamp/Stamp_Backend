package com.example.stamp.DataGateway;
import com.example.stamp.CourseVisitorInteractors.VisitedCourseDto;
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


    @ManyToOne
    @JoinColumn(name = "VisitorId")
    private UserEntity Visitor;
    public void changeUserEntity(UserEntity Visitor){
        this.Visitor = Visitor;
        Visitor.getVisitedcourses().add(this);
    }
    @ManyToOne
    @JoinColumn(name = "CourseId")
    private CourseEntity VisitedCourse;
    public void changeCourseEntity(CourseEntity VisitedCourse){
        this.VisitedCourse = VisitedCourse;
        VisitedCourse.getVisiteduser().add(this);
    }

    public static VisitedCourseEntity createVisitedPlace(VisitedCourseDto dto,UserEntity user, CourseEntity course) {
        //엔티티 생성 및 반환
        return new VisitedCourseEntity(
                dto.getId(),
                user,course);
    }
}
