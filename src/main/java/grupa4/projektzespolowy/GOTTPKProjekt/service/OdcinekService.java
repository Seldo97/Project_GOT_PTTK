package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Punkt;

import java.util.List;

public interface OdcinekService {

    Odcinek createOdcinek(Odcinek odcinek);

    List<Odcinek> getAllOdcinki();

    Odcinek getOneById(Integer id);

    void removeOdcinek(Integer id);

    List<Odcinek> getAllByOtwartyAndIdPasmo(int otwarty, int idPasmo);

    List<Odcinek> getAllByIdPunktPoczatkowyOrIdPunktKoncowyAndOtwarty(int idPunktPocz, int idPunktKon, int otwarty);

    List<Odcinek> getAllByPunktPoczatkowyOrPunktKoncowyAndOtwarty(Punkt punktPocz, Punkt punktKon, int otwarty);

    List<Odcinek> getAllByIdPunktKoncowyAndPunktyDo(Punkt punktKon, int punktyDo);



}
