package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Rola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolaRepository extends JpaRepository<Rola, Integer>
{
	Rola findRolaByNazwa(String rolename);

	List<Rola> findRolaByNazwaIsLike(String nazwa);

}
