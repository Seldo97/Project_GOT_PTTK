package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.dto.PrzodownikDTO;
import grupa4.projektzespolowy.GOTTPKProjekt.mapper.PrzodownikMapper;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.repository.PrzodownikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PrzodownikServiceImpl implements PrzodownikService{ // service obsługuje nasze metody z repozytorium

  
    private final PrzodownikRepository przodownikRepository;
    
    private final PrzodownikMapper przodownikMapper;

    @Override
    public PrzodownikDTO createPrzodownik(PrzodownikDTO dto) 
    { 
    	Przodownik przodownik = przodownikMapper.mapOfDTO(dto);
    	Przodownik saveEntity = przodownikRepository.save(przodownik);
    	return przodownikMapper.mapOfEntity(saveEntity);
    }

    @Override
    public List<PrzodownikDTO> getAllPrzodownik() {return przodownikMapper.mapOfCollection(this.przodownikRepository.findAll()); }

    @Override
    public PrzodownikDTO getOneById(Integer id) { return przodownikMapper.mapOfEntity(this.przodownikRepository.getOne(id)); }

    @Override
    public void removePrzodownik(Integer id) { this.przodownikRepository.deleteById(id); }

    @Override
    public void deletePrzodownikQuery(Integer id) { this.przodownikRepository.deletePrzodownik(id); }

    //public List<Przodownik> getPrzodownikUser(){ return this.przodownikRepository.findAllPrzodownikUser(); }
}
