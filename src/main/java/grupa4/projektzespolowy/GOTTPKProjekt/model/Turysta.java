package grupa4.projektzespolowy.GOTTPKProjekt.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

@Table(name = "Turysta")
public class Turysta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turysta")
    private int idTurysta;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "opis")
    private String opis;

    @Column(name = "punkty")
    private int punkty;

    @Column(name = "niepelnosprawnosc")
    private boolean niepelnosprawnosc;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)

    @Column(name = "data_urodzenia")
    private java.util.Date dataUrodzenia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_uzytkownik", referencedColumnName = "id_uzytkownik")
    private Uzytkownik Uzytkownik;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turysta", referencedColumnName = "id_turysta")
    private List<TurystaOdznaka> turystaOdznaka = new ArrayList<TurystaOdznaka>();

    @OneToOne(mappedBy = "turysta", cascade = CascadeType.ALL)
    private Ksiazeczka ksiazeczka;


    public Turysta() {
    }

    public Turysta(String imie, String nazwisko, String telefon, Uzytkownik idUzytkownik, String opis, int punkty, boolean niepelnosprawnosc, Date dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.Uzytkownik = idUzytkownik;
        this.opis = opis;
        this.punkty = punkty;
        this.dataUrodzenia = dataUrodzenia;
        this.niepelnosprawnosc = niepelnosprawnosc;
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

    public boolean isNiepelnosprawnosc() {
        return niepelnosprawnosc;
    }

    public void setNiepelnosprawnosc(boolean niepelnosprawnosc) {
        this.niepelnosprawnosc = niepelnosprawnosc;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date data_urodzenia) {
        this.dataUrodzenia = data_urodzenia;
    }

    public Uzytkownik getUzytkownik() {
        return Uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        Uzytkownik = uzytkownik;
    }

    public int getidUzytkownik() {
        return Uzytkownik.getIdUzytkownik();
    }

    public String getNazwaUzytkownik() {
        return Uzytkownik.getLogin();
    }

    public List<TurystaOdznaka> getTurystaOdznaka() {
        return turystaOdznaka;
    }

    public void setTurystaOdznaka(List<TurystaOdznaka> turystaOdznaka) {
        this.turystaOdznaka = turystaOdznaka;
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
