package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import java.util.List;


public interface TurystaService {


    Turysta createTurysta(Turysta turysta);

    List<Turysta> getAllTurysta();

    Turysta getOneById(Integer id);

    void removeTurysta(Integer id);

    }
