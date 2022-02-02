package fr.tse.poc.poc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.tse.poc.poc.domain.Parcours;

public interface ParcoursRepository extends JpaRepository<Parcours, Long>{

    public static final String FIND_PARCOUR = "SELECT * FROM parcours WHERE etape_depart_fid=?1";
    @Query(value = FIND_PARCOUR, nativeQuery = true)
    public Parcours findParcourByEtape(Long id);
}