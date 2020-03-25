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
@Table(name="Ksiazeczka")
public class Ksiazeczka 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_ksiazeczka")
	 private int idKsiazeczka;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "id_turysta", referencedColumnName = "id_turysta")
	 private Turysta turysta;
	 
	 public Ksiazeczka()
	 {
		 
	 }
	 
	 
	public Ksiazeczka(Turysta turysta) 
	{
		this.turysta = turysta;
	}


	public int getIdKsiazeczka() 
	{
		return idKsiazeczka;
	}
	public void setIdKsiazeczka(int idKsiazeczka) 
	{
		this.idKsiazeczka = idKsiazeczka;
	}
	public Turysta getTurysta() {
		return turysta;
	}
	public void setTurysta(Turysta turysta) 
	{
		this.turysta = turysta;
	} 
	 
	@Override
	public String toString() 
	{
		return "Ksiazeczka [idKsiazeczka=" + idKsiazeczka + ", turysta=" + turysta + "]";
	}
	 
}
