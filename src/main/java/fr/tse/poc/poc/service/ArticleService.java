package fr.tse.poc.poc.service;


import org.springframework.http.ResponseEntity;

import fr.tse.poc.poc.domain.Article;

public interface ArticleService {
    public ResponseEntity<Article> findAllArticles();
}
