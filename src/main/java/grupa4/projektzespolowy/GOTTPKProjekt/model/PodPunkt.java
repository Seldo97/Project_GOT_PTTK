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
@Table(name = "PodPunkt")
public class PodPunkt {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_podpunkt")
    private int idPodPunkt;
	
	  @Column(name = "nazwa", nullable=true, length=100)
	    private String nazwa;
	  
	  @Column(name = "punktyW")
	    private int punktyW;
	  
	  @Column(name = "punktyZ")
	    private int punktyZ;
	  
	  @ManyToOne
	  @JoinColumn(name = "id_pasmo", referencedColumnName = "id_pasmo")
	   private Pasmo Pasmo;
	  
	  @ManyToOne
	  @JoinColumn(name = "id_punkt", referencedColumnName = "id_punkt")
	   private Punkt punkt;
	  
	 

	  public PodPunkt()
	  {
		  
	  }

	public PodPunkt(int idPodPunkt, String nazwa, int punktyW, int punktyZ,Pasmo pasmo, Punkt punkt) {
		this.idPodPunkt = idPodPunkt;
		this.nazwa = nazwa;
		this.punktyW = punktyW;
		this.punktyZ = punktyZ;
		this.Pasmo = pasmo;
		this.punkt = punkt;
	}

	public int getIdPodPunkt() {
		return idPodPunkt;
	}

	public void setIdPodPunkt(int idPodPunkt) {
		this.idPodPunkt = idPodPunkt;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getPunktyW() {
		return punktyW;
	}

	public void setPunktyW(int punktyW) {
		this.punktyW = punktyW;
	}

	public int getPunktyZ() {
		return punktyZ;
	}

	public void setPunktyZ(int punktyZ) {
		this.punktyZ = punktyZ;
	}

	public Pasmo getPasmo() {
		return Pasmo;
	}

	public void setPasmo(Pasmo pasmo) {
		Pasmo = pasmo;
	}

	public Punkt getPunkt() {
		return punkt;
	}

	public void setPunkt(Punkt punkt) {
		this.punkt = punkt;
	}
	
	@Override
	public String toString() {
		return "PodPunkt [idPodPunkt=" + idPodPunkt + ", nazwa=" + nazwa + ", punktyW=" + punktyW + ", punktyZ="
				+ punktyZ + ", Pasmo=" + Pasmo + ", punkt=" + punkt + "]";
	}
	  
	  
	  
}
