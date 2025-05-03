package com.sveacms.controllers;

import com.azure.core.annotation.Get;
import com.sveacms.entities.Article;
import com.sveacms.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("articles")
    public String showArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "create-article";
    }

    @PostMapping("/articles/create")
    public String saveArticle(@ModelAttribute Article article) {
        articleService.postArticle(article);
        return "redirect:/article-grid-table";
    }

    @GetMapping("/articles/list")
    public String getArticlesList(Model model) {
        List<Article> allArticles = articleService.getAllArticles();
        model.addAttribute("listArticles", allArticles);
        return "article-grid-table";
    }
}
