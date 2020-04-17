package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Punkt;
import grupa4.projektzespolowy.GOTTPKProjekt.service.OdcinekService;

import grupa4.projektzespolowy.GOTTPKProjekt.repository.OdcinekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OdcinekServiceImpl implements OdcinekService {

    @Autowired
    OdcinekRepository odcinekRepository;

    @Override
    public Odcinek createOdcinek(Odcinek odcinek) {return this.odcinekRepository.save(odcinek);}

    @Override
    public List<Odcinek> getAllOdcinki() {return this.odcinekRepository.findAll();}

    @Override
    public Odcinek getOneById(Integer id) {return this.odcinekRepository.getOne(id);}

    @Override
    public void removeOdcinek(Integer id) {this.odcinekRepository.deleteById(id);}

    @Override
    public List<Odcinek> getAllByOtwartyAndIdPasmo(int otwarty, int idPasmo) {
        return odcinekRepository.getAllByOtwartyAndPasmo_IdPasmo(otwarty, idPasmo);
    }

    @Override
    public List<Odcinek> getAllByIdPunktPoczatkowyOrIdPunktKoncowyAndOtwarty(int idPunktPocz, int idPunktKon, int otwarty) {
        return odcinekRepository.getAllByPunktPoczatkowyIdpunktOrPunktKoncowyIdpunktAndOtwarty(idPunktPocz, idPunktKon, otwarty);
    }

    @Override
    public List<Odcinek> getAllByPunktPoczatkowyOrPunktKoncowyAndOtwarty(Punkt punktPocz, Punkt punktKon, int otwarty) {
        return odcinekRepository.getAllByPunktPoczatkowyOrPunktKoncowyAndOtwarty(punktPocz, punktKon, otwarty);
    }

    @Override
    public List<Odcinek> getAllByIdPunktKoncowyAndPunktyDo(Punkt punktKon, int punktyDo) {
        return odcinekRepository.findAllByPunktKoncowyAndPunktyDo(punktKon, punktyDo);
    }

    @Override
    public  List<Odcinek> getAllByPasmo_IdPasmo(int idPasmo) {
        return odcinekRepository.findAllByPasmo_IdPasmo(idPasmo);
    }

    @Override
    public  List<Odcinek> getAllByPasmo_Grupa_IdGrupa(int idPasmo) {
        return odcinekRepository.findAllByPasmo_Grupa_IdGrupa(idPasmo);
    }

//    @Override
//    public  List<Odcinek> getAllByGrupa_idGrupa(int idGrupa) {
//        return odcinekRepository.findAllByGrupa_IdGrupa(idGrupa);
//    }




}
