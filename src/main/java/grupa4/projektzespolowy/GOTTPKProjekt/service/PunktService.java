package grupa4.projektzespolowy.GOTTPKProjekt.service;


import grupa4.projektzespolowy.GOTTPKProjekt.model.Punkt;

import java.util.List;

public interface PunktService {
    Punkt createPunkt(Punkt punkt);

    List<Punkt> getAllPunkt();

    Punkt getOneById(Integer id);

    void removePunkt(Integer id);

}
