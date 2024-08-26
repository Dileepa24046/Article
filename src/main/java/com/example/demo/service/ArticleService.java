package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Article;

@Service
public interface ArticleService {
    List<Article> getArticleList();
    Article createArticle (Article article);
    Article setCreateDateArticle(Article article, LocalDateTime createDate);
    Article setUpdateArticle(Article article, LocalDateTime updateDateTime);
    
}
