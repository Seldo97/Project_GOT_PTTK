package grupa4.projektzespolowy.GOTTPKProjekt.service;


import grupa4.projektzespolowy.GOTTPKProjekt.model.Punkt;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.PunktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PunktServiceImpl  implements PunktService {
    @Autowired
    private PunktRepository punktRepository;

    @Override
    public Punkt createPunkt(Punkt punkt) {
        return punktRepository.save(punkt);
    }

    @Override
    public List<Punkt> getAllPunkt() {
        return this.punktRepository.findAll();
    }

    @Override
    public Punkt getOneById(Integer id) {
        return this.punktRepository.getOne(id);
    }

    @Override
    public void removePunkt(Integer id) {
        this.punktRepository.deleteById(id);
    }

}
