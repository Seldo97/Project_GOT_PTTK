package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;
import grupa4.projektzespolowy.GOTTPKProjekt.model.TrasaOdcinek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface TrasaOdcinekRepository extends JpaRepository<TrasaOdcinek, Integer> {
    List<TrasaOdcinek> findAllByOdcinek(Odcinek odcinek);
    List<TrasaOdcinek> findAllByOdcinek_IdOdcinek(int idOdcinek);

    List<TrasaOdcinek> findAllByTrasa(Trasa trasa);
    List<TrasaOdcinek> findAllByTrasa_IdTrasa(int idTrasa);
}
