package fr.tse.poc.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tse.poc.poc.dao.ReponseRepository;
@Service
public class ReponseServiceImpl implements ReponseService{

    @Autowired
    private ReponseRepository reponseRepository;

    @Override
    public Boolean checkResponse(Long id) {
        return reponseRepository.findById(id).get().getIsTrue();
    }
    
}
