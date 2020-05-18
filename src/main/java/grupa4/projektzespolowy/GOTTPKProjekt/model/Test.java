package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private long idTest;

    @Column(name = "nazwa")
    private LocalDate data;


    public Test() {
    }

    public long getIdTest() {
        return idTest;
    }

    public void setIdTest(long idTest) {
        this.idTest = idTest;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
