package grupa4.projektzespolowy.GOTTPKProjekt.service;

<<<<<<< HEAD
=======
import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
>>>>>>> 67e40d8ba9eb8684e193b02f30a77419907a610d
import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;

import java.util.List;

public interface TurystaOdznakaService {
    TurystaOdznaka createTurystaOdznaka(TurystaOdznaka turystaOdznaka);

    List<TurystaOdznaka> getAllTurystaOdznaka();

    TurystaOdznaka getOneById(Integer id);

    void removeTurystaOdznaka(Integer id);

    List<TurystaOdznaka> findByIdTurysta(int turysta);

    TurystaOdznaka checkOfUnique(Odznaka odznaka, Turysta turysta);
}
