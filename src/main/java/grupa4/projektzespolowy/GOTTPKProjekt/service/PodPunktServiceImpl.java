package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.PodPunkt;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.PodPunktRepository;

@Service
@Transactional
public class PodPunktServiceImpl implements PodPunktService  {
	 
	@Autowired
	 private PodPunktRepository podPunktRepository;
	   
	@Override
	public PodPunkt createPodPunkt(PodPunkt podpunkt) {return this.podPunktRepository.save(podpunkt);}

	@Override
	public List<PodPunkt> getAllPodPunkt() {return this.podPunktRepository.findAll();}

	@Override
	public PodPunkt getOneById(Integer id) {return this.podPunktRepository.getOne(id);}

	@Override
	public void removePodPunkt(Integer id) {this.podPunktRepository.deleteById(id);}

}
