package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.PodPunkt;

@Repository 
public interface PodPunktRepository  extends JpaRepository<PodPunkt, Integer>{

}
