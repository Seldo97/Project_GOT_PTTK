package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

@Entity
@Table(name = "Punkt")
public class Punkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_punkt")
    private int idpunkt;

    @Column(name = "nazwa", nullable=true, length=100)
    private String nazwa;


    public Punkt() {
    }

    public Punkt(String nazwa) {
        this.nazwa = nazwa;
    }
    public Punkt(String nazwa, Pasmo pasmo) {
        this.nazwa = nazwa;
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

}
