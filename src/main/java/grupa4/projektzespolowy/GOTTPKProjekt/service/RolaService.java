package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Rola;

import java.util.List;

public interface RolaService {

    List<Rola> getAllRola();

    Rola getOneById(Integer id);

    public Rola getOneByName(String name);


}
