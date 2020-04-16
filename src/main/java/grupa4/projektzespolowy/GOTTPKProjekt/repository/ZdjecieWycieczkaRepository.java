package grupa4.projektzespolowy.GOTTPKProjekt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.ZdjecieWycieczka;

@Repository
public interface ZdjecieWycieczkaRepository extends JpaRepository<ZdjecieWycieczka, Integer> {
    
	List<ZdjecieWycieczka> getAllByWycieczka_IdWycieczka(int idWycieczka);

}
