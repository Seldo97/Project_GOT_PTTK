package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.ZdjecieWycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.ZdjecieWycieczkaRepository;


@Service
@Transactional
public class ZdjecieWycieczkaServiceImpl implements ZdjecieWycieczkaService   {

	
	@Autowired
	ZdjecieWycieczkaRepository zdjecieWycieczkaRepository;
	
	@Override
	public ZdjecieWycieczka createZdjecie(ZdjecieWycieczka zdjecie) {return this.zdjecieWycieczkaRepository.save(zdjecie);}

	@Override
	public List<ZdjecieWycieczka> getAllZdjecia(){return this.zdjecieWycieczkaRepository.findAll();}

	@Override
	public ZdjecieWycieczka getOneById(Integer id) {return this.zdjecieWycieczkaRepository.getOne(id);}

	@Override
	public void removeZdjecie(Integer id) {this.zdjecieWycieczkaRepository.deleteById(id);}

	@Override
	public List<ZdjecieWycieczka> getAllZdjeciaByIdWycieczka(Integer id) 
	{
		return zdjecieWycieczkaRepository.getAllByWycieczka_IdWycieczka(id);
	}

	@Override
	public void deleteAllByWycieczka(Wycieczka wycieczka) {
		
		zdjecieWycieczkaRepository.deleteAllByWycieczka(wycieczka);
		
	}

}

