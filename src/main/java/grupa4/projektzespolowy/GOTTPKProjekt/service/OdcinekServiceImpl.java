package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;
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


}
