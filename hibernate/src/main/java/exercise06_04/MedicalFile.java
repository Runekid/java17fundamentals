package exercise06_04;

import javax.persistence.*;

@Entity
public class MedicalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float height;
    private float weight;

    @OneToOne(mappedBy = "medicalFile")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedicalFile(float height, float weight, Patient patient) {
        this.height = height;
        this.weight = weight;
        this.patient = patient;
    }

    public MedicalFile(float height, float weight) {
        this.height = height;
        this.weight = weight;
    }

    public MedicalFile() {
    }

    public long getId() {
        return id;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "MedicalFile{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
