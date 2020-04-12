package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Punkt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OdcinekRepository extends JpaRepository<Odcinek, Integer> {
    List<Odcinek> getAllByOtwarty (int otwarty);

    List<Odcinek> getAllByPunktPoczatkowyAndPunktKoncowyAndOtwarty(Punkt punktPocz, Punkt punktKon, int otwarty);
    List<Odcinek> getAllByPunktPoczatkowyIdpunktAndPunktKoncowyIdpunktAndOtwarty(int idPunktPocz, int idPunktKon, int otwarty);
}
