package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurystaOdznakaRepository extends JpaRepository<TurystaOdznaka, Integer> {
    List<TurystaOdznaka> findByTurysta_IdTurysta(int turystaid);

    TurystaOdznaka findTurystaOdznakaByOdznakaAndTurysta(Odznaka odznaka, Turysta turysta);

    TurystaOdznaka findByOdznakaNazwa(String nazwa);

    TurystaOdznaka findByOdznakaNazwaAndTurystaIdTurysta(String nazwa, int id);

    TurystaOdznaka findAllByTurystaIdTurysta(int turysta);

    TurystaOdznaka findAllByOdznakaIdOdznaka(int odznaka);

    int countAllByTurystaIdTurysta(int turysta);
    
}
