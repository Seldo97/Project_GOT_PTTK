package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.GrupaPrzodownik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupaPrzodownikRepository extends JpaRepository<GrupaPrzodownik, Integer> {

    List<GrupaPrzodownik> findByGrupa_IdGrupa(Integer idGrupa);
    List<GrupaPrzodownik> findByPrzodownik_IdPrzodownik(Integer idPrzodownik);
}
