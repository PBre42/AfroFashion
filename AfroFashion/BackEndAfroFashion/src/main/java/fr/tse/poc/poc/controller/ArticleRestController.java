package fr.tse.poc.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.tse.poc.poc.domain.Article;
import fr.tse.poc.poc.service.ArticleService;

@RestController
@RequestMapping("/articles")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 0, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH})
public class ArticleRestController {
    
    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public ResponseEntity<Article> findAllArticles(){
        return this.articleService.findAllArticles();
    }
}
