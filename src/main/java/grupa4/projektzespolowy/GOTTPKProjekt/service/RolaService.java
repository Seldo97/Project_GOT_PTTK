package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Rola;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.RolaRepository;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class RolaService
{
	@Autowired
    private RolaRepository rolaRepository;

    public List<Rola> getAllRola() {
        return this.rolaRepository.findAll();
    }

    public Rola getOneByName(String name) { return this.rolaRepository.findRolaByNazwa(name); }

}
