package grupa4.projektzespolowy.GOTTPKProjekt.repository;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Pasmo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasmoRepository extends JpaRepository<Pasmo, Integer> {
     List<Pasmo> findAllByGrupa_IdGrupa(int idGrupa);
}
