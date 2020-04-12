package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.TrasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TrasaServiceImpl implements TrasaService {

    @Autowired
    TrasaRepository trasaRepository;

    @Override
    public List<Trasa> getAllByIdWycieczka(int idWycieczka) {
        return trasaRepository.getAllByWycieczka_IdWycieczka(idWycieczka);
    }

    @Override
    public Trasa getOneById(int idTrasa) {
        return trasaRepository.getOne(idTrasa);
    }

    @Override
    public void createTrasa(Trasa trasa) {
        trasaRepository.save(trasa);
    }

    @Override
    public void removeTrasa(int idTrasa) {
        trasaRepository.deleteById(idTrasa);
    }
}
