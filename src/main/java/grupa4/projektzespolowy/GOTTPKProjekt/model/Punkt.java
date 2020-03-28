package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

@Entity
@Table(name = "Punkt")
public class Punkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_punkt")
    private int idpunkt;

    @Column(name = "nazwa", nullable=true, length=50)
    private String nazwa;


    @ManyToOne
    @JoinColumn(name = "id_pasmo", referencedColumnName = "id_pasmo")
    private Pasmo pasmo;

    public Punkt() {
    }

    public Punkt(String nazwa) {
        this.nazwa = nazwa;
    }
    public Punkt(String nazwa, Pasmo pasmo) {
        this.nazwa = nazwa;
        this.pasmo = pasmo;
    }

    public int getIdpunkt() {
        return idpunkt;
    }

    public void setIdpunkt(int idpunkt) {
        this.idpunkt = idpunkt;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Pasmo getPasmo() {
        return pasmo;
    }

    public void setPasmo(Pasmo pasmo) {
        this.pasmo = pasmo;
    }

    @Override
    public String toString() {
        return "Punkt{" +
                "idpunkt=" + idpunkt +
                ", nazwa='" + nazwa + '\'' +
                ", pasmo=" + pasmo +
                '}';
    }
}
