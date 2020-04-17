package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.ZdjecieWycieczka;
import java.util.*;

@Repository
public interface ZdjecieWycieczkaRepository extends JpaRepository<ZdjecieWycieczka, Integer> {

    List<ZdjecieWycieczka> getAllByWycieczka(Wycieczka wycieczka);

    List<ZdjecieWycieczka> getAllByWycieczka_IdWycieczka(int idWycieczka);

}
