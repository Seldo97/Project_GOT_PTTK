package grupa4.projektzespolowy.GOTTPKProjekt.service;

import java.util.List;
import java.util.Optional;

import grupa4.projektzespolowy.GOTTPKProjekt.exception.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.UzytkownikRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UzytkownikServiceImpl implements UzytkownikService {
    @Autowired
    public UzytkownikRepository uzytkownikRepository;

    @Override
    public Uzytkownik createUzytkownik(Uzytkownik uzytkownik) {
        return uzytkownikRepository.save(uzytkownik);
    }

    @Override
    public List<Uzytkownik> getAllUzytkownik() {
        return this.uzytkownikRepository.findAll();
    }

    @Override
    public void removeUzytkownik(Integer id) {
        this.uzytkownikRepository.deleteById(id);
    }

    @Override
    public Uzytkownik getOneById(Integer id) {
        return this.uzytkownikRepository.getOne(id);
    }

    @Override
    public Uzytkownik getLoggedUserDetails(Authentication authentication) {
        return uzytkownikRepository.findByLogin(authentication.getName());
    }

    @Override
    public void enableUser(String uuid) throws UserDoesNotExistException {
        Optional<Uzytkownik> userOptional = uzytkownikRepository.findByUUID(uuid);
        if (userOptional.isPresent()) {
            userOptional.get().setEnabled(true);
        } else {
            throw new UserDoesNotExistException("User with UUID " + uuid + "does not exist in database");
        }
    }

    @Override
    public void enableUser(Long id) throws UserDoesNotExistException {
        Optional<Uzytkownik> userOptional = uzytkownikRepository.findById(id.intValue());
        if (userOptional.isPresent()) {
            Uzytkownik user = userOptional.get();
            user.setEnabled(!user.isEnabled());
        } else {
            throw new UserDoesNotExistException("User with ID " + id + "does not exist in database");
        }
    }
}
