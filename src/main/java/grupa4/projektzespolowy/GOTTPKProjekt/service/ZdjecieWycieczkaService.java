package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import grupa4.projektzespolowy.GOTTPKProjekt.model.ZdjecieWycieczka;

public interface ZdjecieWycieczkaService {
	
	 ZdjecieWycieczka createZdjecie(ZdjecieWycieczka zdjecie);

	    List<ZdjecieWycieczka> getAllZdjecia();

	    ZdjecieWycieczka getOneById(Integer id);
	    
	    List<ZdjecieWycieczka> getAllZdjeciaByIdWycieczka(Integer id);
	    
	    void removeZdjecie(Integer id);
}
