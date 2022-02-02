package fr.tse.poc.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.tse.poc.poc.domain.Reponse;
import fr.tse.poc.poc.service.ArticleService;
import fr.tse.poc.poc.service.ParcoursService;
import fr.tse.poc.poc.service.ReponseService;
import fr.tse.poc.poc.utils.Constants;
import fr.tse.poc.poc.utils.ParcoursReponse;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 0, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH})
public class GameRestController {
    
    @Autowired
    ArticleService articleService;
    @Autowired
    ParcoursService parcoursService;
    @Autowired
    ReponseService reponseService;

    static Integer nv=3;
    // @GetMapping("/{id}")
    // public ResponseEntity<ParcoursReponse> settings(@PathVariable Long id){
    //     return parcoursService.GetParcoursWithReponse(id);
    // }

    @GetMapping("/")
    public ParcoursReponse startGame(){
        return parcoursService.GetParcoursWithReponse(Constants.PARCOURS_ONE_ID);
    }

    @GetMapping("/{id}")
    public ParcoursReponse CheckResponses(@PathVariable Long id){

        System.out.println(reponseService.checkResponse(id));

        ParcoursReponse parcoursReponse = parcoursService.GetParcoursWithReponse(
                                                                                parcoursService.
                                                                                getParcoursByResponseID(id).getId()
                                                                                );
        boolean exist=false;
        for (Reponse reponse : parcoursReponse.getReponses()) {
            //System.out.println("=======>"+reponse);
            if(reponse.getId()==id){
                //System.out.println("hhhh--->"+reponse.getId());
                exist=true;
                
            }
        }

        if(exist==true){
            if(reponseService.checkResponse(id)==true){
                parcoursService.getNextParcoursByResponseID(id).setNombreDeVie(nv);
                return parcoursService.GetParcoursWithReponse(parcoursService.getNextParcoursByResponseID(id).getId());

            }else{
                if(nv>1){
                    nv-=1;
                    parcoursService.getParcoursByResponseID(id).setNombreDeVie(nv);
                    return parcoursService.GetParcoursWithReponse(parcoursService.getParcoursByResponseID(id).getId());
                }else{
                    nv=3;
                    return startGame();
                }
                
                
                
            }
    }
    return null;
    }
}
