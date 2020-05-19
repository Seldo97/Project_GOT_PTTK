package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Ksiazeczka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;


public interface WycieczkaService 
{
	 Wycieczka createWycieczka(Wycieczka wycieczka);

	    List<Wycieczka> getAllWycieczki();

	    Wycieczka getOneById(Integer id);

	    void removeWycieczka(Integer id);
	    
	    List<Wycieczka> getAllWycieczkiByZgloszona(Integer id);

	    List<Wycieczka> getAllZatwierdzoneWycieczki(Ksiazeczka ksiazeczka);

	    
}
