package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.exception.UserDoesNotExistException;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface UzytkownikService {


    Uzytkownik createUzytkownik(Uzytkownik uzytkownik);

    List<Uzytkownik> getAllUzytkownik();

    Uzytkownik getOneById(Integer id);

    void removeUzytkownik(Integer id);

    Uzytkownik getLoggedUserDetails(Authentication authentication);

    void enableUser(String uuid) throws UserDoesNotExistException;

    void enableUser(Long id) throws UserDoesNotExistException;

}
