package fr.tse.poc.poc.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.tse.poc.poc.dao.EtapeRepository;
import fr.tse.poc.poc.dao.ParcoursRepository;
import fr.tse.poc.poc.dao.ReponseRepository;
import fr.tse.poc.poc.domain.Etape;
import fr.tse.poc.poc.domain.Parcours;
import fr.tse.poc.poc.domain.Reponse;
import fr.tse.poc.poc.utils.ParcoursReponse;

@Service
public class ParcoursServiceImpl implements ParcoursService{

    @Autowired
    private ParcoursRepository parcoursRepository;

    @Autowired
    private ReponseRepository reponseRepository;

    @Autowired
    private EtapeRepository etapeRepository;

    @Override
    public ParcoursReponse GetParcoursWithReponse(Long id) {
       
        Parcours parcours = parcoursRepository.findById(id).get();
        Etape etape = parcours.getEtapeDepart();
        List<Reponse> reponses = reponseRepository.findReponseByEtape(etape.getId());
        return new ParcoursReponse(parcours,reponses);
      
    }

    @Override
    @Transactional(readOnly=true)
    public Parcours getParcoursByResponseID(Long responseID) {
        Etape etape=reponseRepository.findById(responseID).get().getEtape();
        return parcoursRepository.findParcourByEtape(etape.getId());
       
    }

    @Override
    public Parcours getNextParcoursByResponseID(Long responseID) {
        Etape etape=reponseRepository.findById(responseID).get().getEtape();
        if(etape.getId()<4){
            Etape nextEtape= etapeRepository.findById(etape.getId()+1).get();
            etape=nextEtape;
        }
        return parcoursRepository.findParcourByEtape(etape.getId());
       
    }
    
}
