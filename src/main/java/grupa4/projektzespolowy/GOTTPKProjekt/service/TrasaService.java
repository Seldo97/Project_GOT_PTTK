package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;

import java.util.*;

public interface TrasaService {

    List<Trasa> getAllByIdWycieczka(int idWycieczka);

    Trasa getOneById(int idTrasa);

    void createTrasa(Trasa trasa);

    void removeTrasa(int idTrasa);

}
