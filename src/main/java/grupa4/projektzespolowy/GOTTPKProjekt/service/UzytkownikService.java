package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;

import java.util.List;

public interface UzytkownikService {

  
	public Uzytkownik createUzytkownik(Uzytkownik uzytkownik) ;
	
	public void removeUzytkownik(Integer id); 

    public List<Uzytkownik> getAllUzytkownik();
    
    public Uzytkownik getOneById(Integer id);
   


}
