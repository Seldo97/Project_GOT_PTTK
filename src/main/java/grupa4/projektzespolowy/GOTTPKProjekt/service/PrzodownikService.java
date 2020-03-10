package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.PrzodownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PrzodownikService {

    @Autowired
    private PrzodownikRepository przodownikRepository;

    public Przodownik createPrzodownik(Przodownik przodownik) {
        return przodownikRepository.save(przodownik);
    }

    public List<Przodownik> getAllPrzodownik() {
        return this.przodownikRepository.findAll();
    }
}
