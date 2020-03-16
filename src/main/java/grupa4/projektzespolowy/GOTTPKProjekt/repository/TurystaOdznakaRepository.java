package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TurystaOdznakaRepository extends JpaRepository<TurystaOdznaka, Integer> {
    @Modifying
    @Query("delete from TurystaOdznaka to where to.id_turysta_odznaka = ?1")
    public void deleteTurystaOdznaka(Integer id_turysta_odznaka);
}
