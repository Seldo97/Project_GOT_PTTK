package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // interfejs który zawiera wszystkie podstawowe funkcje typu findAll, delete itp... zapraszam do dokumentacji
public interface PrzodownikRepository extends JpaRepository<Przodownik, Integer> {

    @Modifying
    @Query("delete from Przodownik p where p.idPrzodownik = ?1")
    public void deletePrzodownik(Integer idPrzodownik);

}
