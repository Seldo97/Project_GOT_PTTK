package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TurystaOdznakaRepository extends JpaRepository<TurystaOdznaka, Integer> {

}
