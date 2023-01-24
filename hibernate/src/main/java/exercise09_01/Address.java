package exercise09_01;

import javax.persistence.*;

@Embeddable
public class Address {
   @Column(name="STREET")
   private String street;
   @Column(name="NUMB")   
   private String number;
   @Column(name="ZIPCODE")
   private String zipCode;
   @Column(name="CITY")
   private String city;
   @Column(name="COUNTRY")
   private String country;
   
   public String getStreet() {
      return street;
   }
   public void setStreet(String street) {
      this.street = street;
   }
   public String getNumber() {
      return number;
   }
   public void setNumber(String number) {
      this.number = number;
   }
   public String getCity() {
      return city;
   }
   public void setCity(String city) {
      this.city = city;
   }
   public String getCountry() {
      return country;
   }
   public void setCountry(String country) {
      this.country = country;
   }
   public String getZipCode() {
      return zipCode;
   }
   public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
   }
   
}
