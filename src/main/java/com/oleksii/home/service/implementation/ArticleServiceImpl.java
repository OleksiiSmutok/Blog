package com.oleksii.home.service.implementation;

import com.oleksii.home.repository.ArticleRepo;
import com.oleksii.home.entity.Article;
import com.oleksii.home.entity.User;
import com.oleksii.home.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * Created by Admin on 28.04.2017.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
   private ArticleRepo articleRepo;

    @Override
    public void add(String subject, String text, Date date, MultipartFile photo,User user) {
        Article article= new Article();
        article.setSubject(subject);
        article.setText(text);
        article.setDate(date);

        double random = Math.random()*5000;
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\Blog\\src\\main\\webapp\\resources\\img\\"+random+"."+photo.getContentType().split("/")[1]);
        try {
            file.createNewFile();
            photo.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        article.setPathToPhoto(random+"."+photo.getContentType().split("/")[1]);
        article.setUser(user);
      articleRepo.save(article);
    }

    @Override
    public void delete(int id) {
        articleRepo.delete(id);
    }

    @Override
    public void edit(int id, String subject, String text,MultipartFile photo) {
        Article article = articleRepo.findOne(id);
        article.setSubject(subject);
        article.setText(text);

        double random = Math.random()*5000;
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\Blog\\src\\main\\webapp\\resources\\img\\"+random+"."+photo.getContentType().split("/")[1]);
        try {
            file.createNewFile();
            photo.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        article.setPathToPhoto(random + "."+photo.getContentType().split("/")[1]);
        articleRepo.save(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepo.findAll();
    }

    @Override
    public Article findOne(int id) {
        return articleRepo.findOne(id);
    }
}
