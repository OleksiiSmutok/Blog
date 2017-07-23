package com.oleksii.home.repository;

import com.oleksii.home.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Admin on 27.04.2017.
 */
public interface ArticleRepo extends JpaRepository <Article,Integer> {
}
