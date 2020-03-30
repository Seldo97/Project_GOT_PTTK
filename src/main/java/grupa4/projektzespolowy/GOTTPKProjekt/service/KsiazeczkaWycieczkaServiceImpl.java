package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.KsiazeczkaWycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.KsiazeczkaWycieczkaRepository;

@Service
@Transactional
public class KsiazeczkaWycieczkaServiceImpl implements KsiazeczkaWycieczkaService {

	@Autowired
	KsiazeczkaWycieczkaRepository ksiazeczkaWycieczkaRepository;
	@Override
	public KsiazeczkaWycieczka createKsiazeczkaWycieczka(KsiazeczkaWycieczka ksiazeczkaWycieczka) {return this.ksiazeczkaWycieczkaRepository.save(ksiazeczkaWycieczka);}

	@Override
	public List<KsiazeczkaWycieczka> getAllKsiazeczkiWycieczki() {return this.ksiazeczkaWycieczkaRepository.findAll();}

	@Override
	public KsiazeczkaWycieczka getOneById(Integer id) {return this.ksiazeczkaWycieczkaRepository.getOne(id);}

	@Override
	public void removeKsiazeczkaWycieczka(Integer id) {this.ksiazeczkaWycieczkaRepository.deleteById(id);}

}
