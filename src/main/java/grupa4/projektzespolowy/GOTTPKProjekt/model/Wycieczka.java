package grupa4.projektzespolowy.GOTTPKProjekt.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
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
@Table(name = "Wycieczka")
public class Wycieczka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wycieczka")
    private int idWycieczka;

    @ManyToOne
    @JoinColumn(name = "id_ksiazeczka", referencedColumnName = "id_ksiazeczka")
    private Ksiazeczka ksiazeczka;

    @Column(name = "opis")
    private String opis;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data_od")
    private java.util.Date dataOd;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data_do")
    private java.util.Date dataDo;

    @Column(name = "suma_punktow")
    private int sumaPunktow;

    @Column(name = "suma_punktow_do_got")
    private int sumaPunktowDoGot;

    @Column(name = "zatwierdzona")
    private int zatwierdzona;

    @Column(name = "zgloszona")
    private int zgloszona;
    
    @Column(name = "przodownik_accept_wycieczki")
    private Integer przodownikWycieczkaAccept;

    @ManyToOne
    @JoinColumn(name = "id_odznaka", referencedColumnName = "id_odznaka")
    private Odznaka odznaka;

    @ManyToOne
    @JoinColumn(name = "id_turysta_odznaka", referencedColumnName = "id_turysta_odznaka")
    private TurystaOdznaka turystaOdznaka;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_wycieczka")
    private List<ZdjecieWycieczka> zdjecieWycieczka;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_wycieczka", referencedColumnName = "id_wycieczka")
    private List<Trasa> trasy = new ArrayList<Trasa>();

    public Wycieczka() {

    }

    public Wycieczka(Ksiazeczka ksiazeczka, String opis, Date dataOd, Date dataDo, int zatwierdzona, int sumaPunktow) {
        this.ksiazeczka = ksiazeczka;
        this.opis = opis;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
        this.zatwierdzona = zatwierdzona;
        this.sumaPunktow = sumaPunktow;
    }

    public int getIdWycieczka() {
        return idWycieczka;
    }

    public void setIdWycieczka(int idWycieczka) {
        this.idWycieczka = idWycieczka;
    }

    public Ksiazeczka getKsiazeczka() {
        return ksiazeczka;
    }

    public void setKsiazeczka(Ksiazeczka ksiazeczka) {
        this.ksiazeczka = ksiazeczka;
    }

    public List<ZdjecieWycieczka> getZdjecieWycieczka() {
        return zdjecieWycieczka;
    }

    public void setZdjecieWycieczka(List<ZdjecieWycieczka> zdjecieWycieczka) {
        this.zdjecieWycieczka = zdjecieWycieczka;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDataOd() {
        return dataOd;
    }

    public void setDataOd(Date dataOd) {
        //dataOd.setMonth(dataOd.getMonth()+3);
        this.dataOd = dataOd;
    }

    public Date getDataDo() {
        return dataDo;
    }

    public void setDataDo(Date dataDo) {
        this.dataDo = dataDo;
    }

    public int getPunkty() {
        return sumaPunktow;
    }

    public void setPunkty(int sumaPunktow) {
        this.sumaPunktow = sumaPunktow;
    }

    public int getSumaPunktow() {
        return sumaPunktow;
    }

    public void setSumaPunktow(int sumaPunktow) {
        this.sumaPunktow = sumaPunktow;
    }

    public int getZatwierdzona() {
        return zatwierdzona;
    }

    public void setZatwierdzona(int zatwierdzona) {
        this.zatwierdzona = zatwierdzona;
    }

    public TurystaOdznaka getTurystaOdznaka() {
        return turystaOdznaka;
    }

    public void setTurystaOdznaka(TurystaOdznaka turystaOdznaka) {
        this.turystaOdznaka = turystaOdznaka;
    }

    public List<Trasa> getTrasy() {
        return trasy;
    }

    public void setTrasy(List<Trasa> trasy) {
        this.trasy = trasy;
    }

    public int getSumaPunktowDoGot() {
        return sumaPunktowDoGot;
    }

    public void setSumaPunktowDoGot(int sumaPunktowDoGot) {
        this.sumaPunktowDoGot = sumaPunktowDoGot;
    }

    public int getZgloszona() {
        return zgloszona;
    }

    public void setZgloszona(int zgloszona) {
        this.zgloszona = zgloszona;
    }

    public Odznaka getOdznaka() {
        return odznaka;
    }

    public void setOdznaka(Odznaka odznaka) {
        this.odznaka = odznaka;
    }

	public Integer getPrzodownikWycieczkaAccept() {
		return przodownikWycieczkaAccept;
	}

	public void setPrzodownikWycieczkaAccept(Integer przodownikWycieczkaAccept) {
		this.przodownikWycieczkaAccept = przodownikWycieczkaAccept;
	}

	
    
    
}
