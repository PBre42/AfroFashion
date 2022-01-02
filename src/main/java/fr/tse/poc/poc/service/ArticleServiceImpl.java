package fr.tse.poc.poc.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.tse.poc.poc.domain.Article;

@Service
public class ArticleServiceImpl implements ArticleService{

    //@Autowired
    //private ArticleRepository articleRepository;
    
    @Override
    @Transactional(readOnly=true)
    public ResponseEntity<Article> findAllArticles() {
        return null;
       // return articleRepository.findAll();
    }
    
}
