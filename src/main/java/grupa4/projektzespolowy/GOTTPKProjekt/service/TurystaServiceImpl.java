package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.TurystaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TurystaServiceImpl implements TurystaService
{
	@Autowired
    public TurystaRepository turystaRepository;
	@Autowired
    private EmailService emailService;

    @Override
    @Transactional
	public Turysta createTurysta(Turysta turysta) {
        return turystaRepository.save(turysta);
    }

    @Override
    public List<Turysta> getAllTurysta() {return this.turystaRepository.findAll(); }

	@Override
	public Turysta getOneById(Integer id) {return this.turystaRepository.getOne(id);}

    @Override
    public void removeTurysta(Integer id) { turystaRepository.deleteById(id); }
}
