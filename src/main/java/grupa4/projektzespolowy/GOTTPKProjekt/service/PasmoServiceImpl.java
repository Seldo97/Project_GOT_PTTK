package grupa4.projektzespolowy.GOTTPKProjekt.service;


import grupa4.projektzespolowy.GOTTPKProjekt.model.Pasmo;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.PasmoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PasmoServiceImpl  implements PasmoService{
    @Autowired
    private PasmoRepository pasmoRepository;

    @Override
    public Pasmo createPasmo(Pasmo pasmo) { return pasmoRepository.save(pasmo);}

    @Override
    public List<Pasmo> getAllPasmo() {return this.pasmoRepository.findAll(); }

    @Override
    public Pasmo getOneById(Integer id) { return this.pasmoRepository.getOne(id); }

    @Override
    public void removePasmo(Integer id) { this.pasmoRepository.deleteById(id); }

    @Override
    public List<Pasmo> getAllPasmoByIdGrupa(int idGrupa){
        List<Pasmo> pasmo = this.pasmoRepository.findAllByGrupa_IdGrupa(idGrupa);
        return pasmo;
    }
}
