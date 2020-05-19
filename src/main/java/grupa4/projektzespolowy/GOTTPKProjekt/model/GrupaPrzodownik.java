package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

@Entity
@Table(name = "Grupa_Przodownik")
public class GrupaPrzodownik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupa_przodownik")
    private int idGrupaPrzodownik;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_przodownik", referencedColumnName = "id_przodownik")
    private Przodownik przodownik;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grupa", referencedColumnName = "id_grupa")
    private Grupa grupa;

    public GrupaPrzodownik() {}

    public GrupaPrzodownik(Przodownik przodownik, Grupa grupa) {
        this.przodownik = przodownik;
        this.grupa = grupa;
    }

    public int getIdGrupaPrzodownik() {
        return idGrupaPrzodownik;
    }

    public void setIdGrupaPrzodownik(int idGrupaPrzodownik) {
        this.idGrupaPrzodownik = idGrupaPrzodownik;
    }

    public Przodownik getPrzodownik() {
        return przodownik;
    }

    public void setPrzodownik(Przodownik przodownik) {
        this.przodownik = przodownik;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "GrupaPrzodownik{" +
                "idGrupaPrzodownik=" + idGrupaPrzodownik +
                ", przodownik=" + przodownik +
                ", grupa=" + grupa +
                '}';
    }
}
