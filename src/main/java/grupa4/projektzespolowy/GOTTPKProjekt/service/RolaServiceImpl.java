package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Rola;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.RolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class RolaServiceImpl implements RolaService
{
	@Autowired
    private RolaRepository rolaRepository;

	@Override
    public List<Rola> getAllRola() { return this.rolaRepository.findAll();}

    @Override
    public Rola getOneById(Integer id) { return this.rolaRepository.getOne(id); }

    @Override
    public Rola getOneByName(String name) { return this.rolaRepository.findRolaByNazwa(name); }


}
