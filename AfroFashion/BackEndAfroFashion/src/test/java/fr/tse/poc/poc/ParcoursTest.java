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
import fr.tse.poc.poc.domain.Parcours;
import fr.tse.poc.poc.service.ArticleService;
import fr.tse.poc.poc.service.ParcoursService;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
public class ParcoursTest {

	@Autowired
    private ParcoursService parcoursService;
	
	@Test
	public void testFindParcoursByResponseID() {
		
		Parcours parcours = this.parcoursService.getParcoursByResponseID((long) 1);
		
		Assert.assertNotNull(parcours);
	}
}