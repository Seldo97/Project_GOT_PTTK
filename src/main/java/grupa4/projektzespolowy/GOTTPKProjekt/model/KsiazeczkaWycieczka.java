package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ksiazeczka_Wycieczka")
public class KsiazeczkaWycieczka 
{
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id_ksiazeczka_wycieczka")
	  private int idKsiazeczkaWycieczka;
	  
	  @OneToOne(cascade = CascadeType.PERSIST) // na dziecku robimy PRESIST żeby zaś problemu z updejtami nie było
	  @JoinColumn(name = "id_ksiazeczka", referencedColumnName = "id_ksiazeczka")
	  private Ksiazeczka ksiazeczka;
	  
	  @ManyToOne()
	  @JoinColumn(name = "id_wycieczka", referencedColumnName = "id_wycieczka")
	  private Wycieczka wycieczka;
	  
	  @Column(name = "zatwierdzono", columnDefinition="BIT")
	  private boolean czyZatwierdzono;
	  
	  
	  public KsiazeczkaWycieczka()
	  {
		  
	  }
	public KsiazeczkaWycieczka( Ksiazeczka ksiazeczka, Wycieczka wycieczka,boolean czyZatwierdzono) {
		this.ksiazeczka = ksiazeczka;
		this.wycieczka = wycieczka;
		this.czyZatwierdzono = czyZatwierdzono;
	}

	public int getIdKsiazeczkaWycieczka() {
		return idKsiazeczkaWycieczka;
	}

	public void setIdKsiazeczkaWycieczka(int idKsiazeczkaWycieczka) {
		this.idKsiazeczkaWycieczka = idKsiazeczkaWycieczka;
	}

	public Ksiazeczka getKsiazeczka() {
		return ksiazeczka;
	}

	public void setKsiazeczka(Ksiazeczka ksiazeczka) {
		this.ksiazeczka = ksiazeczka;
	}

	public Wycieczka getWycieczka() {
		return wycieczka;
	}

	public void setWycieczka(Wycieczka wycieczka) {
		this.wycieczka = wycieczka;
	}

	public boolean isCzyZatwierdzono() {
		return czyZatwierdzono;
	}

	public void setCzyZatwierdzono(boolean czyZatwierdzono) {
		this.czyZatwierdzono = czyZatwierdzono;
	}
	  
	  
	
}
