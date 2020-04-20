package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Punkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PunktRepository extends JpaRepository<Punkt, Integer> {

}
