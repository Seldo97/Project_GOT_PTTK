package grupa4.projektzespolowy.GOTTPKProjekt.service;


import grupa4.projektzespolowy.GOTTPKProjekt.model.Regulamin;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.RegulaminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegulaminServiceImpl implements RegulaminService {

    @Autowired
    private RegulaminRepository regulaminRepository;

    @Override
    public Regulamin createRegulamin(Regulamin regulamin) {
        return regulaminRepository.save(regulamin);
    }

    @Override
    public List<Regulamin> getAllRegulamin() {
        return this.regulaminRepository.findAll();
    }

    @Override
    public Regulamin getOneById(Integer id) {
        return this.regulaminRepository.getOne(id);
    }

    @Override
    public void removeRegulamin(Integer id) {
        this.regulaminRepository.deleteById(id);
    }

}
