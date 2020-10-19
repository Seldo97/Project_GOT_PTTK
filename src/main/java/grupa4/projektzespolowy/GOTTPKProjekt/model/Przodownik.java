package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Przodownik")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Przodownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_przodownik")
    private int idPrzodownik;

    @Column(name = "imie", nullable=false, length=50)
    private String imie;

    @Column(name = "nazwisko", nullable=false, length=50)
    private String nazwisko;

    @Column(name = "telefon", nullable=false, length=9)
    private String telefon;

    @Column(name="opis", nullable=true, length=100)
    private String opis;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) // na dziecku robimy PRESIST żeby zaś problemu z updejtami nie było
    @JoinColumn(name = "id_uzytkownik", referencedColumnName = "id_uzytkownik")
    private Uzytkownik Uzytkownik;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_przodownik", referencedColumnName = "id_przodownik")
    private List<GrupaPrzodownik> grupy = new ArrayList<GrupaPrzodownik>();


    public Przodownik(String imie, String nazwisko, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
    }

    public Przodownik(String imie, String nazwisko, String telefon, Uzytkownik uzytkownik) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.Uzytkownik = uzytkownik;
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

    public Uzytkownik getUzytkownik() {
        return Uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        Uzytkownik = uzytkownik;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<GrupaPrzodownik> getGrupy() {
        return grupy;
    }

    public void setGrupy(List<GrupaPrzodownik> grupy) {
        this.grupy = grupy;
    }

    @Override
    public String toString() {
        return "Przodownik{" +
                "idPrzodownik=" + idPrzodownik +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
