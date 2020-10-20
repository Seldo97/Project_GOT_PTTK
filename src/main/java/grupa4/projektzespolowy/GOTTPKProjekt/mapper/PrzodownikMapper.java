package grupa4.projektzespolowy.GOTTPKProjekt.mapper;

import org.springframework.stereotype.Component;

import grupa4.projektzespolowy.GOTTPKProjekt.dto.PrzodownikDTO;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;

@Component
public class PrzodownikMapper implements Mapper<PrzodownikDTO,Przodownik> {

	@Override
	public PrzodownikDTO mapOfEntity(Przodownik entity) {

		PrzodownikDTO przodownikDTO = PrzodownikDTO.builder()
										.idPrzodownik(entity.getIdPrzodownik())
										.imie(entity.getImie())
										.nazwisko(entity.getNazwisko())
										.opis(entity.getOpis())
										.telefon(entity.getTelefon())
										.Uzytkownik(entity.getUzytkownik())
										.grupy(entity.getGrupy())
										.build();
											
		return przodownikDTO ;
	}

	@Override
	public Przodownik mapOfDTO(PrzodownikDTO dto) {
		
		Przodownik przodownik = Przodownik.builder()
								.idPrzodownik(dto.getIdPrzodownik())
								.imie(dto.getImie())
								.nazwisko(dto.getNazwisko())
								.opis(dto.getOpis())
								.telefon(dto.getTelefon())
								.Uzytkownik(dto.getUzytkownik())
								.grupy(dto.getGrupy())
								.build();
				
				
		return przodownik ;
		
	}

}
