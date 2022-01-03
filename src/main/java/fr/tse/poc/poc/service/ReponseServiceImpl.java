package fr.tse.poc.poc.service;

import java.util.Optional;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.tse.poc.poc.dao.ReponseRepository;
import fr.tse.poc.poc.domain.Reponse;
@Service
public class ReponseServiceImpl implements ReponseService{

    @Autowired
    private ReponseRepository reponseRepository;

    @Override
    public Boolean checkResponse(Long id) {
        return reponseRepository.findById(id).get().getIsTrue();
    }
    
}
