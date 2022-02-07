package fr.tse.poc.poc;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.poc.poc.domain.Article;
import fr.tse.poc.poc.service.ArticleService;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
public class ArticleTest {

	@Autowired
    private ArticleService articleService;
	
	@Test
	public void testFindAllArticles() {
		
		Collection<Article> articles = this.articleService.findAllArticles();
		
		Assert.assertEquals(4, articles.size());
	}
}