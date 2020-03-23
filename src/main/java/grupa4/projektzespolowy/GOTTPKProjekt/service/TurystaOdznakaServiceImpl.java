package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.TurystaOdznakaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TurystaOdznakaServiceImpl implements TurystaOdznakaService{

    @Autowired
    private TurystaOdznakaRepository turystaOdznakaRepository;

    @Override
    public TurystaOdznaka createTurystaOdznaka(TurystaOdznaka turystaOdznaka) { return turystaOdznakaRepository.save(turystaOdznaka);}

    @Override
    public List<TurystaOdznaka> getAllTurystaOdznaka() {return this.turystaOdznakaRepository.findAll(); }

    @Override
    public TurystaOdznaka getOneById(Integer id) { return this.turystaOdznakaRepository.getOne(id); }

    @Override
    public void removeTurystaOdznaka(Integer id) { this.turystaOdznakaRepository.deleteById(id); }

}
