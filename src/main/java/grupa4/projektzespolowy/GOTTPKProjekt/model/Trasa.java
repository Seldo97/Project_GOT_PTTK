package grupa4.projektzespolowy.GOTTPKProjekt.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Trasa")
public class Trasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trasa")
    private int idTrasa;

    @ManyToOne
    @JoinColumn(name = "id_wycieczka", referencedColumnName = "id_wycieczka")
    private Wycieczka wycieczka;

    @ManyToOne
    @JoinColumn(name = "id_pasmo", referencedColumnName = "id_pasmo")
    private Pasmo pasmo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data")
    private java.util.Date data;

    @Column(name = "opis")
    private String opis;

    @Column(name = "zrealizowana")
    private int zrealizowana;
    
    @Column(name = "sprawdzona")
    private Integer sprawdzona;

    @Column(name = "dubel")
    private int dubel;

    @Column(name = "suma_punktow")
    private int suma_punktow;

    @Column(name = "suma_punktow_do_got")
    private int sumaPunktowDoGot;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_trasa", referencedColumnName = "id_trasa")
    private List<TrasaOdcinek> odcinkiTrasy = new ArrayList<TrasaOdcinek>();

    public Trasa() {
    }

    public int getIdTrasa() {
        return idTrasa;
    }

    public void setIdTrasa(int idTrasa) {
        this.idTrasa = idTrasa;
    }

    public Wycieczka getWycieczka() {
        return wycieczka;
    }

    public void setWycieczka(Wycieczka wycieczka) {
        this.wycieczka = wycieczka;
    }

    public Pasmo getPasmo() {
        return pasmo;
    }

    public void setPasmo(Pasmo pasmo) {
        this.pasmo = pasmo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getZrealizowana() {
        return zrealizowana;
    }

    public void setZrealizowana(Integer zrealizowana) {
        this.zrealizowana = zrealizowana;
    }
    

    public int getSprawdzona() {
		return sprawdzona;
	}

	public void setSprawdzona(int sprawdzona) {
		this.sprawdzona = sprawdzona;
	}

	public int getDubel() {
        return dubel;
    }

    public void setDubel(int dubel) {
        this.dubel = dubel;
    }

    public int getSuma_punktow() {
        return suma_punktow;
    }

    public void setSuma_punktow(int suma_punktow) {
        this.suma_punktow = suma_punktow;
    }

    public int getSumaPunktowDoGot() {
        return sumaPunktowDoGot;
    }

    public void setSumaPunktowDoGot(int sumaPunktowDoGot) {
        this.sumaPunktowDoGot = sumaPunktowDoGot;
    }

    public List<TrasaOdcinek> getOdcinkiTrasy() {
        return odcinkiTrasy;
    }

    public void setOdcinkiTrasy(List<TrasaOdcinek> odcinkiTrasy) {
        this.odcinkiTrasy = odcinkiTrasy;
    }
}
