package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import java.util.List;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Ksiazeczka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;

@Repository
public interface  WycieczkaRepository  extends JpaRepository<Wycieczka, Integer>{
	List<Wycieczka> getAllWycieczkiByZgloszona(Integer zgloszona);

	List<Wycieczka> getAllWycieczkiByZatwierdzonaAndKsiazeczka(Integer zatwierdzona, Ksiazeczka ksiazeczka);

}
