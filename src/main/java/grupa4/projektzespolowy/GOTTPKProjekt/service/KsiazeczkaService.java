package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Ksiazeczka;

public interface KsiazeczkaService 
{
    Ksiazeczka createKsiazeczka(Ksiazeczka ksiazeczka);

    List<Ksiazeczka> getAllKsiazeczki();

    Ksiazeczka getOneById(Integer id);

    void removeKsiazeczka(Integer id);
}
