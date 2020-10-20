package grupa4.projektzespolowy.GOTTPKProjekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;

import java.util.Optional;

@Repository
public interface UzytkownikRepository  extends JpaRepository<Uzytkownik,Integer>
{
	Uzytkownik findByLogin(String userLoginName);
	Optional<Uzytkownik> findByUUID(String uuid);
}
