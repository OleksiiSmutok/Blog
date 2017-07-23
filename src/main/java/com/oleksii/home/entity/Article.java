package com.oleksii.home.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Admin on 27.04.2017.
 */
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String  subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private Date date;
    private String pathToPhoto;
    @ManyToOne
    private  User user;

    @OneToMany(mappedBy = "article",cascade = CascadeType.REMOVE)
    private List<Comments> commentsList;

    public Article(String subject, String text, Date date, User user) {
        this.subject = subject;
        this.text = text;
        this.date = date;
        this.user = user;
    }

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public String getPathToPhoto() {
        return pathToPhoto;
    }

    public void setPathToPhoto(String pathToPhoto) {
        this.pathToPhoto = pathToPhoto;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", pathToPhoto='" + pathToPhoto + '\'' +
                ", user=" + user +
                ", commentsList=" + commentsList +
                '}';
    }
}
