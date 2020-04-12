package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Pasmo")
public class Pasmo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pasmo")
    private int idPasmo;

    @Column(name = "nazwa", nullable = true, length = 50)
    private String nazwa;

    @ManyToOne
    @JoinColumn(name = "id_grupa", referencedColumnName = "id_grupa")
    private Grupa grupa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pasmo", referencedColumnName = "id_pasmo")
    private List<Odcinek> odcinki = new ArrayList<Odcinek>();

    public Pasmo() {
    }

    public Pasmo(String nazwa) {
        this.nazwa = nazwa;
    }

    public Pasmo(String nazwa, Grupa grupa) {
        this.nazwa = nazwa;
        this.grupa = grupa;
    }

    public int getIdPasmo() {
        return idPasmo;
    }

    public void setIdPasmo(int idPasmo) {
        this.idPasmo = idPasmo;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public List<Odcinek> getOdcinki() {
        return odcinki;
    }

    public void setOdcinki(List<Odcinek> odcinki) {
        this.odcinki = odcinki;
    }

    @Override
    public String toString() {
        return "Pasmo{" +
                "idPasmo=" + idPasmo +
                ", nazwa='" + nazwa + '\'' +
                ", grupa=" + grupa +
                '}';
    }
}
