package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrzodownikRepository extends JpaRepository<Przodownik, Integer> {

//    @Query("SELECT p.imie as imie, p.nazwisko as nazwisko, u.email as email FROM Przodownik p INNER JOIN p.Uzytkownik u")
//    List<Przodownik> findAllPrzodownikUser();
}
