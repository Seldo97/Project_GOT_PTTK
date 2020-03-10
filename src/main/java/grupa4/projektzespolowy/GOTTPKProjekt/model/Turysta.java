package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Turysta")
public class Turysta 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTurysta")
	private int idTurysta;
	
	@Column(name="imie")
	private String imie;
	
	@Column(name="nazwisko")
	private String nazwisko;
	
	@Column(name="telefon")
	private String telefon;

	@Column(name="opis")
	private String opis;
	
	@Column(name="punkty")
	private int punkty;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUzytkownik")
	private Uzytkownik Uzytkownik;
	
	
	public Turysta()
	{
		
	}
	
	

	public Turysta(int idTurysta, String imie, String nazwisko, String telefon, Uzytkownik idUzytkownik, String opis,int punkty) {
		this.idTurysta = idTurysta;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.telefon = telefon;
		this.Uzytkownik = idUzytkownik;
		this.opis = opis;
		this.punkty = punkty;
	}



	public int getIdTurysta() {
		return idTurysta;
	}


	public void setIdTurysta(int idTurysta) {
		this.idTurysta = idTurysta;
	}


	public String getImie() {
		return imie;
	}


	public void setImie(String imie) {
		this.imie = imie;
	}


	public String getNazwisko() {
		return nazwisko;
	}


	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public Uzytkownik getIdUzytkownik() {
		return Uzytkownik;
	}


	public void setIdUzytkownik(Uzytkownik idUzytkownik) {
		this.Uzytkownik = idUzytkownik;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public int getPunkty() {
		return punkty;
	}


	public void setPunkty(int punkty) {
		this.punkty = punkty;
	}



	@Override
	public String toString() {
		return "Turysta [idTurysta=" + idTurysta + ", imie=" + imie + ", nazwisko=" + nazwisko + ", telefon=" + telefon
				+ ", idUzytkownik=" + Uzytkownik + ", opis=" + opis + ", punkty=" + punkty + "]";
	}
	
	
	
	
	
}
