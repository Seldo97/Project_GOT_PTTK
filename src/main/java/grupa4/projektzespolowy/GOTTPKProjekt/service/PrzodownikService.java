package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.dto.PrzodownikDTO;

import java.util.List;

public interface PrzodownikService {

    PrzodownikDTO createPrzodownik(PrzodownikDTO dto);

    List<PrzodownikDTO> getAllPrzodownik();

    PrzodownikDTO getOneById(Integer id);

    void removePrzodownik(Integer id);

    void deletePrzodownikQuery(Integer id);

    //List<Przodownik> getPrzodownikUser();

}
