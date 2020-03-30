package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;

import java.util.List;

public interface OdcinekService {

    Odcinek createOdcinek(Odcinek odcinek);

    List<Odcinek> getAllOdcinki();

    Odcinek getOneById(Integer id);

    void removeOdcinek(Integer id);

}
