package com.example.stamp.common.entity;



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
    private  Long CourseId;
    @Column
    private Long WriterId;
    @Column
    private String Comment;


    public static CommentEntity createComment(CommentDto dto) {
        //엔티티 생성 및 반환
        return new CommentEntity(
                dto.getId(),
                dto.getCourseId(),
                dto.getWriterId(),
                dto.getComment());

    }


}