package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Turysta")
public class Turysta 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turysta")
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
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_uzytkownik", referencedColumnName = "id_uzytkownik")
	private Uzytkownik Uzytkownik;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_turysta_odznaka")
	private List<TurystaOdznaka> turystaOdznaka = new ArrayList<TurystaOdznaka>();
	
	
	@OneToOne
	@JoinColumn(name = "id_ksiazeczka")
	private Ksiazeczka ksiazeczka;


	public Turysta()
	{}

	public Turysta(String imie, String nazwisko, String telefon, Uzytkownik idUzytkownik, String opis,int punkty) 
	{
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


	public Uzytkownik getUzytkownik() {
		return Uzytkownik;
	}
	
	public int getidUzytkownik() {
		return Uzytkownik.getIdUzytkownik();
	}
	
	public String getNazwaUzytkownik() {
		return Uzytkownik.getLogin();
	}


	public void setUzytkownik(Uzytkownik uzytkownik) {
		Uzytkownik = uzytkownik;
	}
	
	public Ksiazeczka getKsiazeczka() {
		return ksiazeczka;
	}

	public void setKsiazeczka(Ksiazeczka ksiazeczka) {
		this.ksiazeczka = ksiazeczka;
	}

	@Override
	public String toString() {
		return "Turysta [idTurysta=" + idTurysta + ", imie=" + imie + ", nazwisko=" + nazwisko + ", telefon=" + telefon
				+ ", opis=" + opis + ", punkty=" + punkty + "]";

	}
	
	
	
	
	
}
