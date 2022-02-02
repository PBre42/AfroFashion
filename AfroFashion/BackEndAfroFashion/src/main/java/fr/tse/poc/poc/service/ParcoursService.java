package fr.tse.poc.poc.service;




import fr.tse.poc.poc.domain.Parcours;
import fr.tse.poc.poc.utils.ParcoursReponse;

public interface ParcoursService {
    public ParcoursReponse GetParcoursWithReponse(Long id);
    public Parcours getParcoursByResponseID(Long responseID);
    public Parcours getNextParcoursByResponseID(Long responseID);
}
