package exercise06_01;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

//@Entity
//@Table(name = "PERSONS", indexes = {@Index(name = "LAST_NAME_INDEX",columnList = "LAST_NAME"),@Index(name = "BIRTHDAY_INDEX",columnList = "BIRTHDAY")})
//@SecondaryTable(name = "URLS")
public class Person {



    public enum GENDER {
        MALE,
        FEMALE,
        APACHE_HEL
    }
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    @Version
    @Column(name = "VERSION")
    private long version;
    @Column(name = "FIRST_NAME", length = 40, nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", length = 40, nullable = false)
    private String lastName;
    @Column(name = "BIRTHDAY")
    private LocalDate birthDay;
    @Column(name = "GENDER", length = 10, nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private GENDER gender;
    @Column(name = "PICTURE")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;
    @Column(name = "COMMNT")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String comment;
    @Column(name = "MARRIED", columnDefinition = "BOOLEAN")
    private boolean married;
    @Transient
    private int age;
    @Column(name = "HOMEPAGE",length = 255,table = "URLS")
    private String homepage;

    public Person() {

    }

    public Person(String firstName, String lastName, LocalDate birthDay, GENDER gender, byte[] picture, String comment, boolean married, String homepage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.picture = picture;
        this.comment = comment;
        this.married = married;
        this.homepage = homepage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(LocalDate.now(),birthDay);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", gender=" + gender +
                ", picture=" + Arrays.toString(picture) +
                ", comment='" + comment + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", homepage='" + homepage + '\'' +
                '}';
    }
}
