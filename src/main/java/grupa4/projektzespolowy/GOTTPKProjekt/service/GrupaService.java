package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Grupa;

import java.util.List;

public interface GrupaService {

    List<Grupa> getAllGrupa();

    Grupa getOneById(Integer id);

    Grupa getOneByName(String name);
    
    Grupa createGrupa(Grupa grupa);
    
    void deleteGrupa(Integer id);

}
