package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Odcinek")
public class Odcinek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_odcinek")
    private int idOdcinek;

    @ManyToOne
    @JoinColumn(name = "id_punkt_poczatkowy", referencedColumnName = "id_punkt")
    private Punkt punktPoczatkowy;

    @ManyToOne
    @JoinColumn(name = "id_punkt_koncowy", referencedColumnName = "id_punkt")
    private Punkt punktKoncowy;

    @Column(name = "punkty_od")
    private int punktyOd;

    @Column(name = "punkty_do")
    private int punktyDo;

    @ManyToOne
    @JoinColumn(name = "id_pasmo", referencedColumnName = "id_pasmo")
    private Pasmo pasmo;

    @Column(name = "otwarty")
    private int otwarty;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_odcinek", referencedColumnName = "id_odcinek")
    private List<TrasaOdcinek> trasyOdcinka = new ArrayList<TrasaOdcinek>();

    public Odcinek() {
    }

    public Odcinek(Punkt punktPoczatkowy, Punkt punktKoncowy, int punkty_od, int punkty_do, Pasmo pasmo, int otwarty) {
        this.punktPoczatkowy = punktPoczatkowy;
        this.punktKoncowy = punktKoncowy;
        this.punktyOd = punkty_od;
        this.punktyDo = punkty_do;
        this.pasmo = pasmo;
        this.otwarty = otwarty;
    }


    public int getIdOdcinek() {
        return idOdcinek;
    }

    public void setIdOdcinek(int idOdcinek) {
        this.idOdcinek = idOdcinek;
    }

    public Punkt getPunktPoczatkowy() {
        return punktPoczatkowy;
    }

    public void setPunktPoczatkowy(Punkt punkt) {
        this.punktPoczatkowy = punkt;
    }

    public Punkt getPunktKoncowy() {
        return punktKoncowy;
    }

    public void setPunktKoncowy(Punkt punkt) {
        this.punktKoncowy = punkt;
    }

    public int getPunktyOd() {
        return punktyOd;
    }

    public void setPunktyOd(int punktyOd) {
        this.punktyOd = punktyOd;
    }

    public int getPunktyDo() {
        return punktyDo;
    }

    public void setPunktyDo(int punktyDo) {
        this.punktyDo = punktyDo;
    }

    public Pasmo getPasmo() {
        return pasmo;
    }

    public void setPasmo(Pasmo pasmo) {
        this.pasmo = pasmo;
    }

    public int getOtwarty() {
        return otwarty;
    }

    public void setOtwarty(int otwarty) {
        this.otwarty = otwarty;
    }

    public List<TrasaOdcinek> getTrasyOdcinka() {
        return trasyOdcinka;
    }

    public void setTrasyOdcinka(List<TrasaOdcinek> trasyOdcinka) {
        this.trasyOdcinka = trasyOdcinka;
    }


}
