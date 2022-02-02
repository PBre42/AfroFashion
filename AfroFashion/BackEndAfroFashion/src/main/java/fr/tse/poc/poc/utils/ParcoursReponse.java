package fr.tse.poc.poc.utils;


import java.util.List;

import fr.tse.poc.poc.domain.Parcours;
import fr.tse.poc.poc.domain.Reponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParcoursReponse {
    private Parcours parcours;
    private List<Reponse> reponses;
    
}
