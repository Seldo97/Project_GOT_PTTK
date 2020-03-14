package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;

import java.util.List;

public interface PrzodownikService {

    Przodownik createPrzodownik(Przodownik przodownik);

    List<Przodownik> getAllPrzodownik();

    Przodownik getOneById(Integer id);

    void removePrzodownik(Integer id);

    void deletePrzodownikQuery(Integer id);

    //List<Przodownik> getPrzodownikUser();

}
