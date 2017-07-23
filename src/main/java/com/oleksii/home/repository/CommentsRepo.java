package com.oleksii.home.repository;

import com.oleksii.home.entity.Article;
import com.oleksii.home.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Admin on 27.04.2017.
 */
public interface CommentsRepo extends JpaRepository<Comments,Integer> {

    public List<Comments>findCommentsByArticle(Article article);
}
