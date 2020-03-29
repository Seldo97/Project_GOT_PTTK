package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
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
