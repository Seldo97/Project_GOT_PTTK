package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;

import java.util.List;

public interface TurystaOdznakaService {
    TurystaOdznaka createTurystaOdznaka(TurystaOdznaka turystaOdznaka);

    List<TurystaOdznaka> getAllTurystaOdznaka();

    TurystaOdznaka getOneById(Integer id);

    void removeTurystaOdznaka(Integer id);

    void deleteTurystaOdznakaQuery(Integer id);
}
