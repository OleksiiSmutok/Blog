package com.oleksii.home.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Admin on 27.04.2017.
 */
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(columnDefinition = "TEXT")
    private  String text;
    private  String mark;
    private Date date;
    @ManyToOne
    private  User user;
    @ManyToOne
    private Article article;

    public Comments(String text, String mark, Date date, User user, Article article) {
        this.text = text;
        this.mark = mark;
        this.date = date;
        this.user = user;
        this.article = article;
    }

    public Comments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "CommentsRepo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", mark='" + mark + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", article=" + article +
                '}';
    }
}
