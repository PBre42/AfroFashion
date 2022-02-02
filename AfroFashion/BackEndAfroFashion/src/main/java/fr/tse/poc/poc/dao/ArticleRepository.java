package fr.tse.poc.poc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.tse.poc.poc.domain.Article;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
}
