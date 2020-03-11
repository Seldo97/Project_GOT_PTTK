package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Rola")
public class Rola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rola")
    private int idRola;

    @Column(name = "nazwa", nullable=false, length=50)
    private String nazwa;

    @OneToMany(mappedBy = "rola", cascade = CascadeType.ALL)
    private List<Uzytkownik> uzytkownicy;

    public Rola() {
    }

    public int getIdRola() {
        return idRola;
    }

    public void setIdRola(int idRola) {
        this.idRola = idRola;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Uzytkownik> getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(List<Uzytkownik> uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }

    @Override
    public String toString() {
        return "Rola{" +
                "idRola=" + idRola +
                ", nazwa='" + nazwa + '\'' +
                ", uzytkownicy=" + uzytkownicy +
                '}';
    }
}
