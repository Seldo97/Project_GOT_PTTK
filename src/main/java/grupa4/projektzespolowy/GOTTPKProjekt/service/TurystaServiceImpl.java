package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.TurystaRepository;

@Service
@Transactional
public class TurystaServiceImpl implements TurystaService
{
	@Autowired
    private TurystaRepository turystaRepository;

    @Override
	public Turysta createTurysta(Turysta turysta) {
        return turystaRepository.save(turysta);
    }

    @Override
    public List<Turysta> getAllTurysta() {
        return this.turystaRepository.findAll();
    }

	@Override
	public Turysta getOneById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
