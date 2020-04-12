package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

@Entity
@Table(name = "Trasa_Odcinek")
public class TrasaOdcinek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trasa_odcinek")
    private int idTrasaOdcinek;

    @ManyToOne
    @JoinColumn(name = "id_trasa", referencedColumnName = "id_trasa")
    private Trasa trasa;

    @ManyToOne
    @JoinColumn(name = "id_odcinek", referencedColumnName = "id_odcinek")
    private Odcinek odcinek;

    @Column(name = "punkty")
    private int punkty;

    public TrasaOdcinek() {
    }

    public TrasaOdcinek(Trasa trasa, Odcinek odcinek, int punkty) {
        this.trasa = trasa;
        this.odcinek = odcinek;
        this.punkty = punkty;
    }

    public int getIdTrasaOdcinek() {
        return idTrasaOdcinek;
    }

    public void setIdTrasaOdcinek(int idTrasaOdcinek) {
        this.idTrasaOdcinek = idTrasaOdcinek;
    }

    public Trasa getTrasa() {
        return trasa;
    }

    public void setTrasa(Trasa trasa) {
        this.trasa = trasa;
    }

    public Odcinek getOdcinek() {
        return odcinek;
    }

    public void setOdcinek(Odcinek odcinek) {
        this.odcinek = odcinek;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }
}
