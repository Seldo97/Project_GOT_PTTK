package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TurystaOdznaka")
public class TurystaOdznaka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turysta_odznaka")
    private int idTurystaOdznaka;

    @ManyToOne
    @JoinColumn(name = "id_odznaka", referencedColumnName = "id_odznaka")
    private Odznaka odznaka;

    @ManyToOne
    @JoinColumn(name = "id_turysta", referencedColumnName = "id_turysta")
    private Turysta turysta;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_turysta_odznaka", referencedColumnName = "id_turysta_odznaka")
    private List<Wycieczka> wycieczki = new ArrayList<Wycieczka>();

    public TurystaOdznaka() {}

    public TurystaOdznaka(int id_turysta_odznaka, Odznaka odznaka, Turysta turysta) {
        this.idTurystaOdznaka = id_turysta_odznaka;
        this.odznaka = odznaka;
        this.turysta = turysta;
    }

    public TurystaOdznaka(Odznaka odznaka, Turysta turysta) {
        this.odznaka = odznaka;
        this.turysta = turysta;
    }

    public int getIdTurystaOdznaka() {
        return idTurystaOdznaka;
    }

    public void setIdTurystaOdznaka(int idTurystaOdznaka) {
        this.idTurystaOdznaka = idTurystaOdznaka;
    }

    public Odznaka getOdznaka() {
        return odznaka;
    }

    public void setOdznaka(Odznaka odznaka) {
        this.odznaka = odznaka;
    }

    public Turysta getTurysta() {
        return turysta;
    }

    public void setTurysta(Turysta turysta) {
        this.turysta = turysta;
    }

    public List<Wycieczka> getWycieczki() {
        return wycieczki;
    }

    public void setWycieczki(List<Wycieczka> wycieczki) {
        this.wycieczki = wycieczki;
    }

    @Override
    public String toString() {
        return "TurystaOdznaka{" +
                "id_turysta_odznaka=" + idTurystaOdznaka +
                ", id_turysta='" + turysta + '\'' +
                ", id_odznaka='" + odznaka + '\'' +
                '}';
    }
}
