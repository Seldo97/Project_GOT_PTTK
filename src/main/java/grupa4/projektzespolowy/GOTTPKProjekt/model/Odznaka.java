package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Odznaka")
public class Odznaka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_odznaka")
    private int idOdznaka;

    @Column(name = "nazwa", nullable=true, length=50)
    private String nazwa;


    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_odznaka", referencedColumnName = "id_odznaka")
    private List<TurystaOdznaka> turystaOdznaka = new ArrayList<TurystaOdznaka>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_odznaka", referencedColumnName = "id_odznaka")
    private List<Wycieczka> wycieczki = new ArrayList<Wycieczka>();

    public Odznaka() {}

    public Odznaka(String nazwa) {
        this.nazwa = nazwa;
    }

    public Odznaka(int idOdznaka, String nazwa) {
        this.idOdznaka = idOdznaka;
        this.nazwa = nazwa;
    }

    public int getIdOdznaka() {
        return idOdznaka;
    }

    public void setIdOdznaka(int idOdznaka) {
        this.idOdznaka = idOdznaka;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Odznaka{" +
                "idOdznaka=" + idOdznaka +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
