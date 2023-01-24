package exercise09_01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS", indexes = {
      @Index(name = "LAST_NAME_INDEX", columnList = "LAST_NAME"),
      @Index(name = "BIRTHDAY_INDEX", columnList = "BIRTHDAY") })
@SecondaryTable(name = "URLS")
@EntityListeners({PersonLogger.class, UUIDCreator.class})
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID")
   private long id;

   @Version
   @Column(name = "VERSION")
   private long version;

   @Column(name = "FIRST_NAME", length = 40)
   @Basic(optional = false)
   private String firstName;

   @Column(name = "LAST_NAME", length = 40)
   @Basic(optional = false)
   private String lastName;

   @Column(name = "BIRTHDAY")
   private LocalDate birthDay;

   @Column(name = "GENDER", updatable = false, length = 10)
   @Enumerated(EnumType.STRING)
   @Basic(optional = false)
   private GenderType gender;

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

   @Column(name = "HOMEPAGE", table = "URLS", length = 255)
   private String homepage;

   @Embedded
   private Address address = new Address();

   @Transient
   private int age;

   @Column(name="UUID")
   private String UUID;

   public long getId() {
      return id;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public long getVersion() {
      return version;
   }

   public LocalDate getBirthDay() {
      return birthDay;
   }

   public void setBirthDay(LocalDate birthDay) {
      this.birthDay = birthDay;
      calculateAge();
   }

   public GenderType getGender() {
      return gender;
   }

   public void setGender(GenderType gender) {
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

   public int getAge() {
      return age;
   }

   public String getHomepage() {
      return homepage;
   }

   public void setHomepage(String homepage) {
      this.homepage = homepage;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public String getUUID() {
      return UUID;
   }

   public void setUUID(String UUID) {
      this.UUID = UUID;
   }

   @PostLoad
   private void calculateAge() {
      LocalDate now = LocalDate.now();
      age = (int) ChronoUnit.YEARS.between(birthDay,now);
   }

   @Override
   public String toString() {
      return new StringJoiner(", ",
            Person.class.getSimpleName() + "[", "]")
            .add("id=" + id).add("version=" + version)
            .add("firstName='" + firstName + "'")
            .add("lastName='" + lastName + "'")
            .add("birthDay=" + birthDay).add("gender=" + gender)
            .add("picture=" + Arrays.toString(picture))
            .add("comment='" + comment + "'")
            .add("married=" + married)
            .add("homepage='" + homepage + "'")
            .add("address=" + address).add("age=" + age)
            .add("UUID='" + UUID + "'").toString();
   }
}
