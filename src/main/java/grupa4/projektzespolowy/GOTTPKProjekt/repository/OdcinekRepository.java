package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Punkt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OdcinekRepository extends JpaRepository<Odcinek, Integer> {

    List<Odcinek> getAllByPasmo_Grupa_IdGrupa(int idGrupa);

    List<Odcinek> getAllByOtwartyAndPasmo_IdPasmo(int otwarty, int idPasmo);
    List<Odcinek> findAllByPunktKoncowyAndPunktyDo(Punkt punktKon, int punktyDo);

    List<Odcinek> findAllByPasmo_IdPasmo(int idPasmo);
   // List<Odcinek> findAllByGrupa_IdGrupa(int idGrupa);

    List<Odcinek> findAllByPasmo_Grupa_IdGrupa(int idGrupa);


    List<Odcinek> getAllByPunktPoczatkowyOrPunktKoncowyAndOtwarty(Punkt punktPocz, Punkt punktKon, int otwarty);
    List<Odcinek> getAllByPunktPoczatkowyIdpunktOrPunktKoncowyIdpunktAndOtwarty(int idPunktPocz, int idPunktKon, int otwarty);
}
