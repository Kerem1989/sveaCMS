package com.sveacms.services;

import com.sveacms.entities.Article;
import com.sveacms.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    final ArticleRepository articleRepository;


    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public void postArticle(Article article) {
        articleRepository.save(article);
    }

    public void postArticle() {
        System.out.println("Articles logged.");
    }
}
