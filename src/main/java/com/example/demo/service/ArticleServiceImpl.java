package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
  
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article setCreateDateArticle(Article article, LocalDateTime createDate) {
        article.setCreateDate(createDate);  // Assuming Article has a setCreateDate method
        return articleRepository.save(article);
    }

    @Override
    public Article setUpdateArticle(Article article, LocalDateTime updateDate) {
        article.setCreateDate(updateDate);  // Assuming Article has a setUpdateDate method
        return articleRepository.save(article);
    }
}
