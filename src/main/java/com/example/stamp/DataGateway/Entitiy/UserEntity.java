package com.example.stamp.DataGateway.Entitiy;




import com.example.stamp.UnknownPersonInteractors.dto.UserDto;
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
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private  String Username;
    @Column
    private String UserId;
    @Column
    private String Password;
    //NumberOfStamps(스탬프 수)
    @Column
    private Integer NOS;

    @OneToMany(mappedBy = "Writer",orphanRemoval = true)
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(mappedBy = "CourseMaker",orphanRemoval = true)
    private List<CourseEntity> courses = new ArrayList<>();

    @OneToMany(mappedBy = "Visitor",orphanRemoval = true)
    private List<VisitedCourseEntity> visitedcourses = new ArrayList<>();

    @OneToMany(mappedBy = "Visitor",orphanRemoval = true)
    private List<VisitedPlaceEntity> visitedcpalces = new ArrayList<>();

    public static UserEntity createUser(UserDto dto,List<CommentEntity> comments,List<CourseEntity> courses,
                                        List<VisitedCourseEntity> visitedcourses,List<VisitedPlaceEntity> visitedcpalces) {
        //엔티티 생성 및 반환
        return new UserEntity(
                dto.getId(),
                dto.getUsername(),
                dto.getUserId(),
                dto.getPassword(),
                dto.getNOS(),
                comments,courses,visitedcourses,visitedcpalces);

    }
    public void patch(UserEntity user){
        if(user.Username != null)
            this.Username = user.Username;
       if(user.UserId != null)
            this.UserId = user.UserId;
       if(user.Password != null)
            this.Password = user.Password;
       if(user.NOS != null)
            this.NOS = user.NOS;
    }

}
