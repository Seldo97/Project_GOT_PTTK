package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import java.util.List;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrasaRepository extends JpaRepository<Trasa, Integer> {

    List<Trasa> getAllByWycieczka_IdWycieczka(int idWycieczka);
}
