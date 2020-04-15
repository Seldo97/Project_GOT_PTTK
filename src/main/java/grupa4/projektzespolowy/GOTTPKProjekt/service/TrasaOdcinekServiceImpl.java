package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;
import grupa4.projektzespolowy.GOTTPKProjekt.model.TrasaOdcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.TrasaOdcinekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TrasaOdcinekServiceImpl implements TrasaOdcinekService {

    @Autowired
    TrasaOdcinekRepository trasaOdcinekRepository;

    @Override
    public List<TrasaOdcinek> getAllOdcinkiByIdTrasa(int idTrasa) {
        return trasaOdcinekRepository.findAllByTrasa_IdTrasa(idTrasa);
    }

    @Override
    public List<TrasaOdcinek> getAllOdcinkiByTrasa(Trasa trasa) {
        return trasaOdcinekRepository.findAllByTrasa(trasa);
    }

    @Override
    public List<TrasaOdcinek> getAllTrasybyIdOdcinek(int idOdcinek) {
        return trasaOdcinekRepository.findAllByOdcinek_IdOdcinek(idOdcinek);
    }

    @Override
    public List<TrasaOdcinek> getAllTrasybyOdcinek(Odcinek odcinek) {
        return trasaOdcinekRepository.findAllByOdcinek(odcinek);
    }

    @Override
    public List<TrasaOdcinek> getAll() {
        return trasaOdcinekRepository.findAll();
    }

    @Override
    public TrasaOdcinek getOneById(int idTrasaOdcinek) {
        return trasaOdcinekRepository.getOne(idTrasaOdcinek);
    }

    @Override
    public void createTrasaOdcinek(TrasaOdcinek trasaOdcinek) {
        trasaOdcinekRepository.save(trasaOdcinek);
    }

    @Override
    public void removeTrasaOdcinekById(int idTrasaOdcinek) {
        trasaOdcinekRepository.deleteById(idTrasaOdcinek);
    }

    @Override
    public List<TrasaOdcinek> getAllByOdcinekAndOdznaka(Odcinek odcinek, Odznaka odznaka) {
        return trasaOdcinekRepository.getAllByOdcinekAndTrasa_Wycieczka_Odznaka(odcinek, odznaka);
    }

    @Override
    public List<TrasaOdcinek> getAllByOdcinekAndTrasa(Odcinek odcinek, Trasa trasa) {
        return trasaOdcinekRepository.getAllByOdcinekAndTrasa(odcinek, trasa);
    }

    @Override
    public void removeAllByTrasa(Trasa trasa) {
        trasaOdcinekRepository.deleteAllByTrasa(trasa);
    }
}
