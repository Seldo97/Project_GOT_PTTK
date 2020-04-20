package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import java.util.List;

public interface OdznakaService {

    Odznaka createOdznaka(Odznaka odznaka);

    List<Odznaka> getAllOdznaka();

    Odznaka getOneById(Integer id);

    Odznaka getOneByNazwa(String nazwa);

    Odznaka getTopByNazwa(String nazwa);

    void removeOdznaka(Integer id);

}
