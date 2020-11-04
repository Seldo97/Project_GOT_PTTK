package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ZdjecieWycieczka")
public class ZdjecieWycieczka 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zdjecie_wycieczka")
    private int idZdjecieWycieczka;
	
	@ManyToOne
	@JoinColumn(name = "id_wycieczka", referencedColumnName = "id_wycieczka")
	private Wycieczka wycieczka;
	
	@Column(name = "sciezka")
	private String sciezka;
	
	@Column(name = "opis")
	private String opis;
	
	
	public ZdjecieWycieczka()
	{
		
	}

	public ZdjecieWycieczka( Wycieczka wycieczka, String sciezka, String opis) {
		this.wycieczka = wycieczka;
		this.sciezka = sciezka;
		this.opis = opis;
	}

	public int getIdZdjecieWycieczka() {
		return idZdjecieWycieczka;
	}

	public void setIdZdjecieWycieczka(int idZdjecieWycieczka) {
		this.idZdjecieWycieczka = idZdjecieWycieczka;
	}

	public Wycieczka getWycieczka() {
		return wycieczka;
	}

	public void setWycieczka(Wycieczka wycieczka) {
		this.wycieczka = wycieczka;
	}

	public String getSciezka() {
		return sciezka;
	}

	public void setSciezka(String sciezka) {
		this.sciezka = sciezka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "Zdjecie_Wycieczka [idZdjecieWycieczka=" + idZdjecieWycieczka + ", wycieczka=" + wycieczka + ", sciezka="
				+ sciezka + ", opis=" + opis + "]";
	}
	
	
	
	
}
