package fr.tse.poc.poc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.poc.poc.dao.ArticleRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")

public class PocApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(articleRepository).isNotNull();
	}


}
