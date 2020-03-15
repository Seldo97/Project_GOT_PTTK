package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;

import java.util.List;

public interface UzytkownikService {

  
	Uzytkownik createUzytkownik(Uzytkownik uzytkownik) ;

    List<Uzytkownik> getAllUzytkownik();
    
    Uzytkownik getOneById(Integer id);

    void removeUzytkownik(Integer id);

}
