package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

@Entity
@Table(name = "Przodownik")
public class Przodownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrzodownik")
    private int idPrzodownik;

    @Column(name = "imie", nullable=false, length=50)
    private String imie;

    @Column(name = "nazwisko", nullable=false, length=50)
    private String nazwisko;

    @Column(name = "telefon", nullable=false, length=50)
    private String telefon;

    public Przodownik() {}

    public Przodownik(String imie, String nazwisko, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
    }

    public int getIdPrzodownik() {
        return idPrzodownik;
    }

    public void setIdPrzodownik(int idPrzodownik) {
        this.idPrzodownik = idPrzodownik;
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


    @Override
    public String toString() {
        return "Przodownik{" +
                "idPrzodownik=" + idPrzodownik +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '}' + '\n';
    }
}
