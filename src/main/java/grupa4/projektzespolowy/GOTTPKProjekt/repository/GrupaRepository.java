package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupaRepository extends JpaRepository<Grupa, Integer> {
    Grupa findGrupaByNazwa(String grupaNazwa);

    List<Grupa> findGrupaByNazwaIsLike(String grupaNazwa);
}
