package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Grupa")
public class Grupa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupa")
    private int idGrupa;

    @Column(name = "nazwa", nullable=false, length=50)
    private String nazwa;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_grupa", referencedColumnName = "id_grupa")
    private List<Pasmo> pasmo = new ArrayList<Pasmo>();

    public Grupa() {
    }

    public Grupa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIdGrupa() {
        return idGrupa;
    }

    public void setIdGrupa(int idGrupa) {
        this.idGrupa = idGrupa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Grupa{" +
                "idGrupa=" + idGrupa +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
