package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import grupa4.projektzespolowy.GOTTPKProjekt.model.KsiazeczkaWycieczka;


public interface KsiazeczkaWycieczkaService {
	
	KsiazeczkaWycieczka createKsiazeczkaWycieczka(KsiazeczkaWycieczka ksiazeczkaWycieczka);

    List<KsiazeczkaWycieczka> getAllKsiazeczkiWycieczki();

    KsiazeczkaWycieczka getOneById(Integer id);

    void removeKsiazeczkaWycieczka(Integer id);
}	
