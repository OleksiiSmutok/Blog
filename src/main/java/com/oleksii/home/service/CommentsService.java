package com.oleksii.home.service;

import com.oleksii.home.entity.Article;
import com.oleksii.home.entity.Comments;
import com.oleksii.home.entity.User;

import java.sql.Date;
import java.util.List;

/**
 * Created by Admin on 28.04.2017.
 */
public interface CommentsService {
    public void add(String text, String mark, Date date, User user, Article article);
    public void delete(int id);
    public List<Comments> findAll();
    public Comments findOne(int id);
    public List<Comments>findCommentsByArticle(Article article);
}
