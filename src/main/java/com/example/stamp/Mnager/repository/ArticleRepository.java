package com.example.stamp.Mnager.repository;

import com.example.stamp.Mnager.entity.Article;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface ArticleRepository extends CrudRepository<Article,Long> {
    ArrayList<Article> findAll(Sort id);

    @Query(value = "SELECT USERNAME FROM article WHERE ID= :articleId",nativeQuery = true)
    String findUsernameByArticleId(Long articleId);

}
