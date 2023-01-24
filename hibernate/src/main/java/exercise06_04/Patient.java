package exercise06_04;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval = true) //MedicalFile will also be removed
    @JoinColumn(name = "MF_ID")
    private MedicalFile medicalFile;

    public Patient(long id, String name, MedicalFile medicalFile) {
        this.id = id;
        this.name = name;
        this.medicalFile = medicalFile;
    }

    public Patient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public MedicalFile getMedicalFile() {
        return medicalFile;
    }

    public void setMedicalFile(MedicalFile medicalFile) {

            this.medicalFile = medicalFile;


    }

    public void removeMedicalFile() {
        if (medicalFile != null) {
            medicalFile.setPatient(null);
            medicalFile = null;
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", medicalFile=" + medicalFile +
                '}';
    }
}
