package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Article;
import com.example.demo.service.ArticleService;

@RestController
@RequestMapping("/articles")  // Adding a base path to ensure consistency
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getArticleList();
        return ResponseEntity.status(200).body(articles);
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        try {
            Article createdArticle = articleService.createArticle(article);
            return ResponseEntity.status(201).body(createdArticle);
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            // Return a more informative error response
            return ResponseEntity.status(400).body(null);
        }
    }
}
