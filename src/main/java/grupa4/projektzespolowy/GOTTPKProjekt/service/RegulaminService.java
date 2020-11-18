package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Regulamin;

import java.util.List;

public interface RegulaminService {

    Regulamin createRegulamin(Regulamin regulamin);

    List<Regulamin> getAllRegulamin();

    Regulamin getOneById(Integer id);

    void removeRegulamin(Integer id);

}
