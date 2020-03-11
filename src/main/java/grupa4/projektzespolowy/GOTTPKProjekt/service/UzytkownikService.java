package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.UzytkownikRepository;


@Service
@Transactional
public class UzytkownikService 
{
	@Autowired
    private UzytkownikRepository uzytkownikRepository;

	public Uzytkownik createUzytkownik(Uzytkownik uzytkownik) {
        return uzytkownikRepository.save(uzytkownik);
    }

    public List<Uzytkownik> getAllUzytkownik() {
        return this.uzytkownikRepository.findAll();
    }

    public void removeUzytkownik(Integer id) { this.uzytkownikRepository.deleteById(id); }
}
