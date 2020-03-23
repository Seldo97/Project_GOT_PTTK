package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

@Entity
@Table(name = "TurystaOdznaka")
public class TurystaOdznaka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turysta_odznaka")
    private int idTurystaOdznaka;

    @ManyToOne
    @JoinColumn(name = "id_odznaka", referencedColumnName = "id_odznaka")
    private Odznaka odznaka;

    @ManyToOne
    @JoinColumn(name = "id_turysta", referencedColumnName = "id_turysta")
    private Turysta turysta;

    public TurystaOdznaka() {}

    public TurystaOdznaka(int id_turysta_odznaka, Odznaka id_odznaka, Turysta id_turysta) {
        this.idTurystaOdznaka = id_turysta_odznaka;
        this.odznaka = id_odznaka;
        this.turysta = id_turysta;
    }

    public TurystaOdznaka(Odznaka id_odznaka, Turysta id_turysta) {
        this.odznaka = id_odznaka;
        this.turysta = id_turysta;
    }

    public int getId_turysta_odznaka() {
        return idTurystaOdznaka;
    }

    public void setId_turysta_odznaka(int id_turysta_odznaka) {
        this.idTurystaOdznaka = id_turysta_odznaka;
    }

    public Odznaka getOdznaka() {
        return odznaka;
    }

    public void setOdznaka(Odznaka odznaka) {
        this.odznaka = odznaka;
    }

    public Turysta getTurysta() {
        return turysta;
    }

    public void setTurysta(Turysta turysta) {
        this.turysta = turysta;
    }

    @Override
    public String toString() {
        return "TurystaOdznaka{" +
                "id_turysta_odznaka=" + idTurystaOdznaka +
                ", id_turysta='" + turysta + '\'' +
                ", id_odznaka='" + odznaka + '\'' +
                '}';
    }
}
