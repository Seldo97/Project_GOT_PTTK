package grupa4.projektzespolowy.GOTTPKProjekt.service;


import grupa4.projektzespolowy.GOTTPKProjekt.model.Pasmo;

import java.util.List;

public interface PasmoService {
    Pasmo createPasmo(Pasmo pasmo);

    List<Pasmo> getAllPasmo();

    Pasmo getOneById(Integer id);

    void removePasmo(Integer id);

    List<Pasmo> getAllPasmoByIdGrupa(int idGrupa);
}
