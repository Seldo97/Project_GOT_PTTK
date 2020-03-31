package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

@Entity
@Table(name="Odcinek")
public class Odcinek
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_odcinek")
    private int idOdcinek;

    @Column(name="punkty_wejscie")
    private Integer punktyWejscie;

    @Column(name="punkty_powrot")
    private Integer punktyPowrot;

    @ManyToOne
    @JoinColumn(name = "id_punkt_poczatkowy", referencedColumnName = "id_punkt")

    private Punkt PunktPoczatkowy;

    @ManyToOne
    @JoinColumn(name = "id_punkt_koncowy", referencedColumnName = "id_punkt")
    private Punkt PunktKoncowy;

    @ManyToOne
    @JoinColumn(name = "id_pasmo", referencedColumnName = "id_pasmo")
    private Pasmo Pasmo;

    public Odcinek()
    {

    }




    public grupa4.projektzespolowy.GOTTPKProjekt.model.Pasmo getPasmo() {
        return Pasmo;
    }

    public Odcinek(Punkt punktPoczatkowy, Punkt punktKoncowy, Integer punktyWejscie, Integer punktyPowrot, Pasmo idPasmo)
    {
        this.PunktPoczatkowy = punktPoczatkowy ;
        this.PunktKoncowy = punktKoncowy ;
        this.punktyWejscie = punktyWejscie;
        this.punktyPowrot = punktyPowrot;
        this.Pasmo = idPasmo;
    }




    public Punkt getPunktPoczatkowy() {
        return PunktPoczatkowy;
    }
    public Punkt getPunktKoncowy() {
        return PunktKoncowy;
    }
    public Integer getPunktyWejscie()
    {
        return punktyWejscie;
    }
    public Integer getPunktyPowrot() { return punktyPowrot; }
    public Integer getIdOdcinek()
    {
        return idOdcinek;
    }

    public void setIdOdcinek(int idOdcinek)
    {
        this.idOdcinek = idOdcinek;
    }
    public void setPunktyWejscie(Integer punktyWejscie) { this.punktyWejscie = punktyWejscie; }

    public void setPunktyPowrot(Integer punktyPowrot) { this.punktyPowrot = punktyPowrot; }

    public void setPasmo(grupa4.projektzespolowy.GOTTPKProjekt.model.Pasmo pasmo) {
        Pasmo = pasmo;
    }

    public void setPunktPoczatkowy(Punkt punkt)
    {
        this.PunktPoczatkowy = getPunktPoczatkowy();
    }
    public void setPunktKoncowy(Punkt punkt)
    {
        this.PunktKoncowy = getPunktKoncowy();
    }


    @Override
    public String toString()
    {
        return "Odcinek [idOdcinek=" + idOdcinek + ", idPunktPoczatkowy=" + PunktPoczatkowy + "idPunktKoncowy " + PunktKoncowy +  "]";
    }

}
