package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.PrzodownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PrzodownikServiceImpl implements PrzodownikService{ // service obsługuje nasze metody z repozytorium

    @Autowired
    private PrzodownikRepository przodownikRepository;

    @Override
    public Przodownik createPrzodownik(Przodownik przodownik) {
        return przodownikRepository.save(przodownik);
    }

    @Override
    public List<Przodownik> getAllPrzodownik() {
        return this.przodownikRepository.findAll();
    }

    @Override
    public Przodownik getOneById(Integer id) { return this.przodownikRepository.getOne(id); }

    @Override
    public void removePrzodownik(Integer id) { this.przodownikRepository.deleteById(id); }

    @Override
    public void deletePrzodownikQuery(Integer id) { this.przodownikRepository.deletePrzodownik(id); }

    //public List<Przodownik> getPrzodownikUser(){ return this.przodownikRepository.findAllPrzodownikUser(); }
}
