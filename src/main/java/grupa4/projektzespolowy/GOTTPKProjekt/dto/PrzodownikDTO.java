package grupa4.projektzespolowy.GOTTPKProjekt.dto;

import java.util.List;


import grupa4.projektzespolowy.GOTTPKProjekt.model.GrupaPrzodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrzodownikDTO {

    private int idPrzodownik;

    private String imie;

    private String nazwisko;

    private String telefon;

    private String opis;

    private Uzytkownik Uzytkownik;

    private List<GrupaPrzodownik> grupy;

	public PrzodownikDTO( String imie, String nazwisko, String telefon,Uzytkownik uzytkownik) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.telefon = telefon;
		Uzytkownik = uzytkownik;
	}

}
