package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.GrupaPrzodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.GrupaPrzodownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GrupaPrzodownikServiceImpl implements GrupaPrzodownikService {

    @Autowired
    GrupaPrzodownikRepository grupaPrzodownikRepository;

    @Override
    public List<GrupaPrzodownik> getPrzodownicyGrupy(Integer idGrupa) {
        return grupaPrzodownikRepository.findByGrupa_IdGrupa(idGrupa);
    }

    @Override
    public List<GrupaPrzodownik> getGrupyPrzodownika(Integer idPrzodownik) {
        return grupaPrzodownikRepository.findByPrzodownik_IdPrzodownik(idPrzodownik);
    }

    @Override
    public void saveGrupaPrzodownik(GrupaPrzodownik grupaPrzodownik) {
        grupaPrzodownikRepository.save(grupaPrzodownik);
    }

    @Override
    public void removeGrupaPrzodownik(Integer idGrupaPrzodownik) {
        grupaPrzodownikRepository.deleteById(idGrupaPrzodownik);
    }
}
