package grupa4.projektzespolowy.GOTTPKProjekt.model;


import org.hibernate.annotations.Type;
import org.hibernate.type.TextType;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "Regulamin")
public class Regulamin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_regulamin")
    private int idRegulamin;

    @Column(name = "tekst", columnDefinition="TEXT")
    @Type(type="text")
    private String tekstRegulamin;

    @Column(name = "naglowek")
    private String tekstNaglowek;


    public Regulamin() {
    }

    public String getTekstRegulamin() {
        return tekstRegulamin;
    }

    public void setTekstRegulamin(String tekstRegulamin) {
        this.tekstRegulamin = tekstRegulamin;
    }

    public String getTekstNaglowek() {
        return tekstNaglowek;
    }

    public void setTekstNaglowek(String tekstNaglowek) {
        this.tekstNaglowek = tekstNaglowek;
    }
}
