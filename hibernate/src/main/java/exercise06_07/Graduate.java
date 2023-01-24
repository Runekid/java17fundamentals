package exercise06_07;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Graduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @OneToMany
    @JoinColumn
    private List<DegreeRelation> degreeRelations = new ArrayList<>();

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DegreeRelation> getDegreeRelations() {
        return degreeRelations;
    }

    public void setDegreeRelations(List<DegreeRelation> degreeRelations) {
        this.degreeRelations = degreeRelations;
    }

    @Override
    public String toString() {
        return "Graduate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", degreeRelations=" + degreeRelations +
                '}';
    }
}
