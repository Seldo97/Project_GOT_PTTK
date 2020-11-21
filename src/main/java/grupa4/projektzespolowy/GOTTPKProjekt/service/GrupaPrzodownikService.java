package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.GrupaPrzodownik;
import java.util.*;

public interface GrupaPrzodownikService {

    List<GrupaPrzodownik> getPrzodownicyGrupy(Integer idGrupa);

    List<GrupaPrzodownik> getGrupyPrzodownika(Integer idPrzodownik);

    void saveGrupaPrzodownik(GrupaPrzodownik grupaPrzodownik);

    void removeGrupaPrzodownik(Integer idGrupaPrzodownik);
}
