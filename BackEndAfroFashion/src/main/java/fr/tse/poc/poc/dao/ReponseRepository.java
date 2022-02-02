package fr.tse.poc.poc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.tse.poc.poc.domain.Reponse;

public interface ReponseRepository extends JpaRepository<Reponse, Long>{

    public static final String FIND_RESPONSES = "SELECT * FROM reponse WHERE etape_reponse_FID=?1";
    @Query(value = FIND_RESPONSES, nativeQuery = true)
    public List<Reponse> findReponseByEtape(Long id);
}
