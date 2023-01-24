package exercise10_01;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Car {
   @Id
   @Pattern(regexp="^[0-9]-[A-Z]{3}-[0-9]{3}$")
   private String plate;
   
   @NotBlank
   @Size(min=3)
   private String brand;
   
   @NotBlank
   @Size(min=2)
   private String type;
   
   @NotNull
   @PastOrPresent
   private LocalDate entryIntoService;
   
   @Positive
   @Digits(integer=10,fraction=2)
   private float listPrice;
   
   @Positive
   private int power;
   
   public String getPlate() {
      return plate;
   }
   public void setPlate(String plate) {
      this.plate = plate;
   }
   public String getBrand() {
      return brand;
   }
   public void setBrand(String brand) {
      this.brand = brand;
   }
   public String getType() {
      return type;
   }
   public void setType(String type) {
      this.type = type;
   }

   public LocalDate getEntryIntoService() {
      return entryIntoService;
   }

   public void setEntryIntoService(LocalDate entryIntoService) {
      this.entryIntoService = entryIntoService;
   }
   public float getListPrice() {
      return listPrice;
   }
   public void setListPrice(float listPrice) {
      this.listPrice = listPrice;
   }
   public int getPower() {
      return power;
   }
   public void setPower(int power) {
      this.power = power;
   }
}
