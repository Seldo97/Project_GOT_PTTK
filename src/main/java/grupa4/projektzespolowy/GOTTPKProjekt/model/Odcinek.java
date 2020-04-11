package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

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
    private int punkty_od;

    @Column(name = "punkty_do")
    private int punkty_do;

    @ManyToOne
    @JoinColumn(name = "id_pasmo", referencedColumnName = "id_pasmo")
    private Pasmo pasmo;

    @Column(name = "otwarty")
    private int otwarty;

    public Odcinek() {
    }

    public Odcinek(Punkt punktPoczatkowy, Punkt punktKoncowy, int punkty_od, int punkty_do, Pasmo pasmo, int otwarty) {
        this.punktPoczatkowy = punktPoczatkowy;
        this.punktKoncowy = punktKoncowy;
        this.punkty_od = punkty_od;
        this.punkty_do = punkty_do;
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
        this.punktPoczatkowy = getPunktPoczatkowy();
    }

    public Punkt getPunktKoncowy() {
        return punktKoncowy;
    }

    public void setPunktKoncowy(Punkt punkt) {
        this.punktKoncowy = getPunktKoncowy();
    }

    public int getPunkty_od() {
        return punkty_od;
    }

    public void setPunkty_od(int punkty_od) {
        this.punkty_od = punkty_od;
    }

    public int getPunkty_do() {
        return punkty_do;
    }

    public void setPunkty_do(int punkty_do) {
        this.punkty_do = punkty_do;
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

    @Override
    public String toString() {
        return "Odcinek{" +
                "idOdcinek=" + idOdcinek +
                ", punktPoczatkowy=" + punktPoczatkowy +
                ", punktKoncowy=" + punktKoncowy +
                ", punkty_od=" + punkty_od +
                ", punkty_do=" + punkty_do +
                ", pasmo=" + pasmo +
                ", otwarty=" + otwarty +
                '}';
    }

}
