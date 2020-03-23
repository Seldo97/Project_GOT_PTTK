package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;

import java.util.List;

public interface OdznakaService {
    Odznaka createOdznaka(Odznaka odznaka);

    List<Odznaka> getAllOdznaka();

    Odznaka getOneById(Integer id);

    void removeOdznaka(Integer id);

}
