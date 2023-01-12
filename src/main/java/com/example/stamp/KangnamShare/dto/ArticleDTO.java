package com.example.stamp.KangnamShare.dto;

import com.example.stamp.KangnamShare.entity.Article;
import lombok.*;

@AllArgsConstructor
@ToString
@Setter

public class ArticleDTO {
    private Long id;
    private String title;
    private String content;
    private String username;

    private String categories;

    private Long price;
    public Article toEntity() {
        return new Article(id,title,content,username,categories,price);
    }



}
