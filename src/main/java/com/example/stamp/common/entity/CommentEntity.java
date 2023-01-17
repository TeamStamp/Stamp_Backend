package com.example.stamp.common.entity;



import com.example.stamp.TeamPocket.entity.Article;
import com.example.stamp.common.dto.CommentDto;
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
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String Comment;

    @ManyToOne
    @JoinColumn(name = "WriterId")
    private UserEntity Writer;


    @ManyToOne
    @JoinColumn(name = "CourseId")
    private CourseEntity Course;
    public void changeUserEntity(CourseEntity Course){
        this.Course = Course;
        Course.getComments().add(this);
    }



    public static CommentEntity createComment(CommentDto dto,UserEntity user, CourseEntity course) {
        //엔티티 생성 및 반환
        return new CommentEntity(
                dto.getId(),
                dto.getComment(),
                user,course);

    }


}