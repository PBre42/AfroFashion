package fr.tse.poc.poc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
public class ArticleControllerTest extends ControllerTest {
	
	@Test
	public void testGetArticles() throws Exception {
		
		mvc.perform(get("/article/")
				.contentType(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("$[0].libelle", is("Jupe portefeuille")))
			    .andExpect(jsonPath("$[0].description", is("Jupe portefeuille/cape bleue marine")))
			    .andExpect(jsonPath("$[0].image", is("../assets/img/article1.jpg")))
			    .andExpect(jsonPath("$[0].prix", is(489.0d)))
			    ;
	}
}
