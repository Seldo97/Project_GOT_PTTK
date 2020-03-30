package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

@Entity
@Table(name = "Przodownik")
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

    @OneToOne(cascade = CascadeType.PERSIST) // na dziecku robimy PRESIST żeby zaś problemu z updejtami nie było
    @JoinColumn(name = "id_uzytkownik", referencedColumnName = "id_uzytkownik")
    private Uzytkownik Uzytkownik;

    public Przodownik() {}

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

    @Override
    public String toString() {
        return "Przodownik{" +
                "idPrzodownik=" + idPrzodownik +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '\'' +
                ", Uzytkownik=" + Uzytkownik +
                '}';
    }
}
