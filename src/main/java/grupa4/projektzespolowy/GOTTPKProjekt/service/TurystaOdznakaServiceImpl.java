package grupa4.projektzespolowy.GOTTPKProjekt.service;


import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.TurystaOdznakaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TurystaOdznakaServiceImpl implements TurystaOdznakaService{

    @Autowired
    private TurystaOdznakaRepository turystaOdznakaRepository;
    @Autowired
    private EmailService emailService;

    @Override
    public TurystaOdznaka createTurystaOdznaka(TurystaOdznaka turystaOdznaka) {
        return turystaOdznakaRepository.save(turystaOdznaka);
    }

    @Override
    public List<TurystaOdznaka> getAllTurystaOdznaka() {return this.turystaOdznakaRepository.findAll(); }

    @Override
    public TurystaOdznaka getOneById(Integer id) { return this.turystaOdznakaRepository.getOne(id); }

    @Override
    public void removeTurystaOdznaka(Integer id) { this.turystaOdznakaRepository.deleteById(id); }

    @Override
    public List<TurystaOdznaka> findByIdTurysta(int idTurysta) {
        return (List<TurystaOdznaka>) this.turystaOdznakaRepository.findByTurysta_IdTurysta(idTurysta);
    }

    @Override
    public TurystaOdznaka findOdznaka(String nazwa, int id) {
        return  this.turystaOdznakaRepository.findByOdznakaNazwaAndTurystaIdTurysta(nazwa, id);
    }


    @Override
    public TurystaOdznaka checkOfUnique(Odznaka odznaka, Turysta turysta) {
        return this.turystaOdznakaRepository.findTurystaOdznakaByOdznakaAndTurysta(odznaka, turysta);
    }

    @Override
    public int ileOdznak(int turysta) {
       int odznaki = turystaOdznakaRepository.countAllByTurystaIdTurysta(turysta);
        return odznaki;
    }

    @Override
    public List<TurystaOdznaka> findAllByOdznakaIdOdznaka(int odznaka) {
        return (List<TurystaOdznaka>) this.turystaOdznakaRepository.findAllByOdznakaIdOdznaka(odznaka);
    }
    
	
}
