package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.UzytkownikRepository;


@Service
@Transactional
public class UzytkownikServiceImpl implements UzytkownikService
{
	@Autowired
    private UzytkownikRepository uzytkownikRepository;

    @Override
	public Uzytkownik createUzytkownik(Uzytkownik uzytkownik) { return uzytkownikRepository.save(uzytkownik); }

    @Override
    public List<Uzytkownik> getAllUzytkownik() { return this.uzytkownikRepository.findAll();  }

    @Override
    public void removeUzytkownik(Integer id) { this.uzytkownikRepository.deleteById(id); }

	@Override
	public Uzytkownik getOneById(Integer id) {return this.uzytkownikRepository.getOne(id);}

    @Override
    public Uzytkownik getLoggedUserDetails(Authentication authentication) {
        return uzytkownikRepository.findByLogin(authentication.getName());
    }
}
