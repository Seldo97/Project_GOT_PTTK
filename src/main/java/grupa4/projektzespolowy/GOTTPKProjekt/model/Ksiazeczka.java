package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ksiazeczka")
public class Ksiazeczka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ksiazeczka")
    private int idKsiazeczka;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turysta", referencedColumnName = "id_turysta")
    private Turysta turysta;

    @Column(name = "suma_punktow")
    private int sumaPunktow;

    @Column(name = "suma_punktow_wszystkich")
    private int sumaPunktowWszystkich;

    @Column(name = "zgloszona")
    private int zgloszona;

    @Column(name = "powiadomienie")
    private int powiadomienie;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ksiazeczka", referencedColumnName = "id_ksiazeczka")
    private List<Wycieczka> wycieczki = new ArrayList<Wycieczka>();

    public Ksiazeczka() {
    }

    public Ksiazeczka(Turysta turysta, int sumaPunktow, int zgloszona, int powiadomienie, int sumaPunktowWszystkich) {
        this.turysta = turysta;
        this.sumaPunktow = sumaPunktow;
        this.sumaPunktowWszystkich = sumaPunktowWszystkich;
        this.zgloszona = zgloszona;
        this.powiadomienie = powiadomienie;
    }

    public int getIdKsiazeczka() {
        return idKsiazeczka;
    }

    public void setIdKsiazeczka(int idKsiazeczka) {
        this.idKsiazeczka = idKsiazeczka;
    }

    public Turysta getTurysta() {
        return turysta;
    }

    public void setTurysta(Turysta turysta) {
        this.turysta = turysta;
    }

    public int getSumaPunktow() {
        return sumaPunktow;
    }

    public void setSumaPunktow(int sumaPunktow) {
        this.sumaPunktow = sumaPunktow;
    }

    public int getZgloszona() {
        return zgloszona;
    }

    public void setZgloszona(int zgloszona) {
        this.zgloszona = zgloszona;
    }

    public List<Wycieczka> getWycieczki() {
        return wycieczki;
    }

    public void setWycieczki(List<Wycieczka> wycieczki) {
        this.wycieczki = wycieczki;
    }

    public int getPowiadomienie() {
        return powiadomienie;
    }

    public void setPowiadomienie(int powiadomienie) {
        this.powiadomienie = powiadomienie;
    }

    public int getSumaPunktowWszystkich() {
        return sumaPunktowWszystkich;
    }

    public void setSumaPunktowWszystkich(int sumaPunktowWszystkich) {
        this.sumaPunktowWszystkich = sumaPunktowWszystkich;
    }

    @Override
    public String toString() {
        return "Ksiazeczka{" +
                "idKsiazeczka=" + idKsiazeczka +
                ", turysta=" + turysta +
                ", sumaPunktow=" + sumaPunktow +
                ", zgloszona=" + zgloszona +
                '}';
    }
}
