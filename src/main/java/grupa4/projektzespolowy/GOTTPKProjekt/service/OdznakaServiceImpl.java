package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.OdznakaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OdznakaServiceImpl implements OdznakaService{

    @Autowired
    private OdznakaRepository odznakaRepository;

    @Override
    public Odznaka createOdznaka(Odznaka odznaka) { return odznakaRepository.save(odznaka);}

    @Override
    public List<Odznaka> getAllOdznaka() {return this.odznakaRepository.findAll(); }

    @Override
    public Odznaka getOneById(Integer id) { return this.odznakaRepository.getOne(id); }

    @Override
    public Odznaka getOneByNazwa(String nazwa){ return this.odznakaRepository.getOdznakaByNazwaEquals(nazwa);}

    @Override
    public Odznaka getTopByNazwa(String nazwa){ return this.odznakaRepository.getTopByNazwa(nazwa);}

    @Override
    public void removeOdznaka(Integer id) { this.odznakaRepository.deleteById(id); }

}
