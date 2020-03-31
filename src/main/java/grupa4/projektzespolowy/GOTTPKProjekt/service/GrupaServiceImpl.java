package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Grupa;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.GrupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GrupaServiceImpl implements GrupaService{
    @Autowired
    private GrupaRepository grupaRepository;

    @Override
    public List<Grupa> getAllGrupa() { return this.grupaRepository.findAll();}

    @Override
    public Grupa getOneById(Integer id) { return this.grupaRepository.getOne(id); }

    @Override
    public Grupa getOneByName(String name) { return this.grupaRepository.findGrupaByNazwa(name); }

	@Override
	public Grupa createGrupa(Grupa grupa) {return this.grupaRepository.save(grupa);}

	@Override
	public void deleteGrupa(Integer id) { this.grupaRepository.deleteById(id);	}
}
