package exercise06_07;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DegreeRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private int level;

    @ManyToOne
    private Degree degree;

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "DegreeRelation{" +
                "id=" + id +
                ", date=" + date +
                ", level=" + level +
                ", degree=" + degree +
                '}';
    }
}
