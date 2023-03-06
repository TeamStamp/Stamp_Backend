package com.example.stamp.DataGateway;


import com.example.stamp.CourseLoadController.CourseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "CourseMakerId")
    private UserEntity CourseMaker;
    public void changeUserEntity(UserEntity CourseMaker){
        this.CourseMaker = CourseMaker;
        CourseMaker.getCourses().add(this);
    }


    @OneToMany(mappedBy = "Course",orphanRemoval = true)
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(mappedBy = "Visitor",orphanRemoval = true)
    private List<VisitedCourseEntity> visiteduser = new ArrayList<>();

    @OneToMany(mappedBy = "Place",orphanRemoval = true)
    private List<DayEntity> visitedday = new ArrayList<>();

    public static CourseEntity createCourse(CourseDto dto,List<CommentEntity> comments,UserEntity user, List<VisitedCourseEntity> visiteduser, List<DayEntity> visitedday) {
        //엔티티 생성 및 반환
        return new CourseEntity(
                dto.getId(),
                dto.getCourseName()
                ,user,comments,visiteduser,visitedday);

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