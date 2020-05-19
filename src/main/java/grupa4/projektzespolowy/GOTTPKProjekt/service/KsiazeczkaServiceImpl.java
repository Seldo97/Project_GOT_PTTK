package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import javax.transaction.Transactional;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Ksiazeczka;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.KsiazeczkaRepository;

@Service
@Transactional
public class KsiazeczkaServiceImpl implements KsiazeczkaService
{
	@Autowired
	KsiazeczkaRepository ksiazeczkaRepository;

	@Override
	public Ksiazeczka createKsiazeczka(Ksiazeczka ksiazeczka) {return this.ksiazeczkaRepository.save(ksiazeczka);}

	@Override
	public List<Ksiazeczka> getAllKsiazeczki() {return this.ksiazeczkaRepository.findAll();}

	@Override
	public Ksiazeczka getOneById(Integer id) {return this.ksiazeczkaRepository.getOne(id);}

	@Override
	public void removeKsiazeczka(Integer id) {this.ksiazeczkaRepository.deleteById(id);}

	@Override
	public Ksiazeczka getOneByTurysta(Turysta turysta) {
		return this.ksiazeczkaRepository.getByTurysta(turysta);
	}

	@Override
	public List<Ksiazeczka> getZgloszoneWycieczki() {
		return this.ksiazeczkaRepository.getAllByZgloszona(1);
	}
}
