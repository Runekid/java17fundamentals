package exercise06_06;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Magazine> magazines = new ArrayList<>();

    public long getId() {
        return id;
    }


    public List<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(List<Magazine> magazines) {
        this.magazines = magazines;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", magazines=" + magazines +
                '}';
    }
}
