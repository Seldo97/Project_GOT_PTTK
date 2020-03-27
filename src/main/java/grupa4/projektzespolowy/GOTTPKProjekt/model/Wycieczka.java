package grupa4.projektzespolowy.GOTTPKProjekt.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Wycieczka")
public class Wycieczka 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_wycieczka")
	    private int idWycieczka;
	   
	    @ManyToOne
	    @JoinColumn(name = "id_turysta", referencedColumnName = "id_turysta")
	    private Turysta turysta;
	    
	    @Temporal(value = TemporalType.DATE)
	    @Column(name = "dataod")
	    private Date dataOd;
	    
	    @Temporal(value = TemporalType.DATE)
	    @Column(name = "datado")
	    private Date dataDo;
	    
	    @Column(name = "punkty")
	    private int punkty;
	    
	    @OneToMany(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "id_zdjecie_wycieczka")
	    private  List<ZdjecieWycieczka> zdjecieWycieczka;
	    
	    public Wycieczka()
	    {
	    	
	    }

		public Wycieczka(Turysta turysta, Date dataOd, Date dataDo, int punkty) 
		{
			this.turysta = turysta;
			this.dataOd = dataOd;
			this.dataDo = dataDo;
			this.punkty = punkty;
		}

		public int getIdWycieczka() {
			return idWycieczka;
		}

		public void setIdWycieczka(int idWycieczka) {
			this.idWycieczka = idWycieczka;
		}

		public Turysta getTurysta() {
			return turysta;
		}

		public void setTurysta(Turysta turysta) {
			this.turysta = turysta;
		}

		public Date getDataOd() {
			return dataOd;
		}

		public void setDataOd(Date dataOd) {
			this.dataOd = dataOd;
		}

		public Date getDataDo() {
			return dataDo;
		}

		public void setDataDo(Date dataDo) {
			this.dataDo = dataDo;
		}

		public int getPunkty() {
			return punkty;
		}

		public void setPunkty(int punkty) {
			this.punkty = punkty;
		}

		@Override
		public String toString() {
			return "Wycieczka [idWycieczka=" + idWycieczka + ", turysta=" + turysta + ", dataOd=" + dataOd + ", dataDo="
					+ dataDo + ", punkty=" + punkty + "]";
		}
		
		
		
		
		
	    
}
