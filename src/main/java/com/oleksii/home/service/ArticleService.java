package com.oleksii.home.service;

import com.oleksii.home.entity.Article;
import com.oleksii.home.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

/**
 * Created by Admin on 28.04.2017.
 */
public interface ArticleService {

    public void add(String subject, String text, Date date, MultipartFile photo, User user);
    public void delete(int id);
    public void edit(int id,String subject,String text,MultipartFile photo);
    public List <Article> findAll();
    public Article findOne(int id);
}
