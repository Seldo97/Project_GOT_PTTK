package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Ksiazeczka;

@Repository
public interface KsiazeczkaRepository  extends JpaRepository<Ksiazeczka, Integer>
{

    Ksiazeczka getByTurysta(Turysta turysta);
    
    List<Ksiazeczka> getAllByZgloszona(int zgloszona);
}
