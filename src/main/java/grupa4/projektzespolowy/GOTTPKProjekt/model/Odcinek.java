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

    @ManyToOne
    @JoinColumn(name = "id_punkt_poczatkowy", referencedColumnName = "id_punkt")

    private Punkt punktPoczatkowy;

    @ManyToOne
    @JoinColumn(name = "id_punkt_koncowy", referencedColumnName = "id_punkt")
    private Punkt punktKoncowy;

    public Odcinek()
    {

    }


    public Odcinek(Punkt punktPoczatkowy, Punkt punktKoncowy)
    {
        this.punktPoczatkowy = punktPoczatkowy ;
        this.punktKoncowy = punktKoncowy ;
    }


    public int getIdOdcinek()
    {
        return idOdcinek;
    }
    public void setIdOdcinek(int idOdcinek)
    {
        this.idOdcinek = idOdcinek;
    }
    public Punkt getPunktPoczatkowy() {
        return punktPoczatkowy;
    }
    public Punkt getPunktKoncowy() {
        return punktKoncowy;
    }

    public void setPunktPoczatkowy(Punkt punkt)
    {
        this.punktPoczatkowy = getPunktPoczatkowy();
    }
    public void setPunktKoncowy(Punkt punkt)
    {
        this.punktKoncowy = getPunktKoncowy();
    }


    @Override
    public String toString()
    {
        return "Odcinek [idOdcinek=" + idOdcinek + ", idPunktPoczatkowy=" + punktPoczatkowy + "idPunktKoncowy " + punktKoncowy +  "]";
    }

}
