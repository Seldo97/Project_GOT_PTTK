package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import java.util.List;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Ksiazeczka;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;

@Repository
public interface  WycieczkaRepository  extends JpaRepository<Wycieczka, Integer>{
	List<Wycieczka> getAllWycieczkiByZgloszona(Integer zgloszona);

	List<Wycieczka> getAllWycieczkiByZatwierdzonaAndKsiazeczka(Integer zatwierdzona, Ksiazeczka ksiazeczka);
	
	@Query(value = "SELECT * FROM Wycieczka w INNER JOIN Odznaka o ON  w.id_odznaka = o.id_odznaka \r\n" + 
			"INNER JOIN zdjecie_wycieczka zw ON  w.id_wycieczka = zw.id_wycieczka WHERE o.nazwa = :badgeName", nativeQuery = true)	
	List<Wycieczka> getAllWycieczkiOnBadge(@Param("badgeName")String badgeName);
	
	@Query(value = "SELECT * FROM Wycieczka w  JOIN Odznaka o ON  w.id_odznaka = o.id_odznaka\r\n" + 
			"			 JOIN Trasa t ON w.id_wycieczka = t.id_wycieczka \r\n" + 
			"			 JOIN zdjecie_wycieczka zw ON  w.id_wycieczka = zw.id_wycieczka WHERE o.nazwa = :badgeName AND w.id_wycieczka = :idWycieczki", nativeQuery = true)	
	List<Wycieczka> getAllTrasyOnBadge(@Param("badgeName")String badgeName,@Param("idWycieczki")Integer idWycieczki);
	
	

}
