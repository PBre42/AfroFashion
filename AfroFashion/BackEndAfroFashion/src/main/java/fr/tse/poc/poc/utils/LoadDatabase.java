package fr.tse.poc.poc.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import fr.tse.poc.poc.dao.ArticleRepository;
import fr.tse.poc.poc.dao.EtapeRepository;
import fr.tse.poc.poc.dao.ParcoursRepository;
import fr.tse.poc.poc.dao.ReponseRepository;
import fr.tse.poc.poc.domain.Article;
import fr.tse.poc.poc.domain.Etape;
import fr.tse.poc.poc.domain.Parcours;
import fr.tse.poc.poc.domain.Reponse;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
	@Profile("!test")
	CommandLineRunner initDatabase(ArticleRepository articleRepository,
                                   EtapeRepository etapeRepository,
                                   ReponseRepository reponseRepository,
                                   ParcoursRepository parcoursRepository) {
		
		return args -> {	
            initSteps(etapeRepository,reponseRepository,parcoursRepository);					
			initArticles(articleRepository);					
		};
	}

    private void initArticles(ArticleRepository articleRepository){

        Article article1 = new Article();
        article1.setId(1L);
        article1.setLibelle("libelle1");
        article1.setDescription("description1");
        article1.setImage("image1");
        article1.setPrix(1111.0d);
        articleRepository.save(article1);
        log.info(article1 + " saved to database.");

        Article article2 = new Article();
        article2.setId(2L);
        article2.setLibelle("libelle2");
        article2.setDescription("description2");
        article2.setImage("image2");
        article2.setPrix(1111.0d);
        articleRepository.save(article2);
        log.info(article2 + " saved to database.");
    }

    private void initSteps(EtapeRepository etapeRepository, ReponseRepository reponseRepository, ParcoursRepository parcoursRepository){

        Etape etape1 = new Etape(Constants.STEP_ONE_ID,Constants.STEP_ONE_VIDEO);
        etapeRepository.save(etape1);
        log.info(etape1 + " saved to database.");
        
        Etape etape2 = new Etape(Constants.STEP_TWO_ID,Constants.STEP_TWO_VIDEO);
        etapeRepository.save(etape2);
        log.info(etape2 + " saved to database.");

        Etape etape3 = new Etape(Constants.STEP_THREE_ID,Constants.STEP_THREE_VIDEO);
        etapeRepository.save(etape3);
        log.info(etape3 + " saved to database.");

        Etape etape4 = new Etape(Constants.STEP_FOUR_ID,Constants.STEP_FOUR_VIDEO);
        etapeRepository.save(etape4);
        log.info(etape4 + " saved to database.");

        Parcours parcours1 = new Parcours(Constants.PARCOURS_ONE_ID,3,etape1);
        parcoursRepository.save(parcours1);
        log.info(parcours1 + " saved to database.");

        Parcours parcours2 = new Parcours(Constants.PARCOURS_TWO_ID,3,etape2);
        parcoursRepository.save(parcours2);
        log.info(parcours2 + " saved to database.");

        Parcours parcours3 = new Parcours(Constants.PARCOURS_THREE_ID,3,etape3);
        parcoursRepository.save(parcours3);
        log.info(parcours3 + " saved to database.");

        Parcours parcours4 = new Parcours(Constants.PARCOURS_FOUR_ID,3,etape4);
        parcoursRepository.save(parcours4);
        log.info(parcours4 + " saved to database.");

        Reponse reponse1 = new Reponse(Constants.RESPONSE_ONE_TRUE_ID, 
                                       Constants.RESPONSE_ONE_TRUE_ISTRUE, 
                                       Constants.RESPONSE_ONE_TRUE_VIDEO_REPONSE,
                                       etape1);
        reponseRepository.save(reponse1);
        log.info(reponse1 + " saved to database.");
        
        Reponse reponse2 = new Reponse(Constants.RESPONSE_TWO_TRUE_ID, 
                                       Constants.RESPONSE_TWO_TRUE_ISTRUE, 
                                       Constants.RESPONSE_TWO_TRUE_VIDEO_REPONSE,
                                       etape2);
        reponseRepository.save(reponse2);
        log.info(reponse2 + " saved to database.");   

        Reponse reponse3 = new Reponse(Constants.RESPONSE_THREE_TRUE_ID, 
                                       Constants.RESPONSE_THREE_TRUE_ISTRUE, 
                                       Constants.RESPONSE_THREE_TRUE_VIDEO_REPONSE,
                                       etape3);
        reponseRepository.save(reponse3);
        log.info(reponse3 + " saved to database.");

        Reponse reponse4 = new Reponse(Constants.RESPONSE_FOUR_TRUE_ID, 
                                       Constants.RESPONSE_FOUR_TRUE_ISTRUE, 
                                       Constants.RESPONSE_FOUR_TRUE_VIDEO_REPONSE,
                                       etape4);
        reponseRepository.save(reponse4);
        log.info(reponse4 + " saved to database.");

        Reponse reponse5 = new Reponse(Constants.RESPONSE_ONE_FALSE_ID, 
                                       Constants.RESPONSE_ONE_FALSE_ISTRUE, 
                                       Constants.RESPONSE_ONE_FALSE_VIDEO_REPONSE,
                                       etape1);
        reponseRepository.save(reponse5);
        log.info(reponse5 + " saved to database.");

        Reponse reponse6 = new Reponse(Constants.RESPONSE_TWO_FALSE_ID, 
                                       Constants.RESPONSE_TWO_FALSE_ISTRUE, 
                                       Constants.RESPONSE_TWO_FALSE_VIDEO_REPONSE,
                                       etape2);
        reponseRepository.save(reponse6);
        log.info(reponse6 + " saved to database."); 

        Reponse reponse7 = new Reponse(Constants.RESPONSE_THREE_FALSE_ID, 
                                       Constants.RESPONSE_THREE_FALSE_ISTRUE, 
                                       Constants.RESPONSE_THREE_FALSE_VIDEO_REPONSE,
                                       etape3);
        reponseRepository.save(reponse7);
        log.info(reponse7 + " saved to database."); 

        Reponse reponse8 = new Reponse(Constants.RESPONSE_FOUR_FALSE_ID, 
                                       Constants.RESPONSE_FOUR_FALSE_ISTRUE, 
                                       Constants.RESPONSE_FOUR_FALSE_VIDEO_REPONSE,
                                       etape4);
        reponseRepository.save(reponse8);
        log.info(reponse8 + " saved to database."); 

      

    }

    @Bean
	@Profile("test")
	CommandLineRunner initTestDatabase(ArticleRepository articleRepository,
                                        EtapeRepository etapeRepository,
                                        ReponseRepository reponseRepository,
                                        ParcoursRepository parcoursRepository) {
		
		return args -> {			
			initSteps(etapeRepository,reponseRepository,parcoursRepository);					
			initArticles(articleRepository);					
		};
	
    
}

}
