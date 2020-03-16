package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OdznakaRepository extends JpaRepository<Odznaka, Integer> {

    @Modifying
    @Query("delete from Odznaka o where o.idOdznaka = ?1")
    public void deleteOdznaka(Integer id_odznaka);

}