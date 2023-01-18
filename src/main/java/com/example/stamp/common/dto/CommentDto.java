package com.example.stamp.common.dto;


import com.example.stamp.common.entity.CommentEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {
    private Long Id;
    private String Comment;
    private Long WriterId;
    private Long CourseId;

    public static CommentDto createCommentDto(CommentEntity comment) {
        return new CommentDto(

                comment.getId(),
                comment.getComment(),
                comment.getWriter().getId(),
                comment.getCourse().getId()
        );
    }
}