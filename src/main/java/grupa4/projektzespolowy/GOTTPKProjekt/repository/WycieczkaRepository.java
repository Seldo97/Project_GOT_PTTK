package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.TrasaOdcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;

@Repository
public interface  WycieczkaRepository  extends JpaRepository<Wycieczka, Integer>{
	List<Wycieczka> getAllWycieczkiByZgloszona(Integer zgloszona);
}
