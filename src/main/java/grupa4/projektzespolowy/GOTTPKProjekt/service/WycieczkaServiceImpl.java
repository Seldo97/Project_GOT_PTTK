package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.WycieczkaRepository;

@Service
@Transactional
public class WycieczkaServiceImpl implements WycieczkaService {

	
	@Autowired 
	private WycieczkaRepository wycieczkaRepository;
	
	@Override
	public Wycieczka createWycieczka(Wycieczka wycieczka) {return this.wycieczkaRepository.save(wycieczka);}

	@Override
	public List<Wycieczka> getAllWycieczki() {return this.wycieczkaRepository.findAll();}

	@Override
	public Wycieczka getOneById(Integer id) {return this.wycieczkaRepository.getOne(id);}

	@Override
	public void removeWycieczka(Integer id) {this.wycieczkaRepository.deleteById(id);}

}
