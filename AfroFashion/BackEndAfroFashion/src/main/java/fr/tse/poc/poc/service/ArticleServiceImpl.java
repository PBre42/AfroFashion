package fr.tse.poc.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.tse.poc.poc.dao.ArticleRepository;
import fr.tse.poc.poc.domain.Article;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;
    
    @Override
    @Transactional(readOnly=true)
    public List<Article> findAllArticles() {
        //return null;
        return articleRepository.findAll();
    }
    
}
