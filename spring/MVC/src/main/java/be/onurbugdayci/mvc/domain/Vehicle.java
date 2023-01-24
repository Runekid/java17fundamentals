package be.onurbugdayci.mvc.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

public class Vehicle implements Serializable {
   @NotBlank
   private String brand;
   
   @NotBlank
   private String type;

   @Min(1970)
   @Max(2020)
   private int year;
   
   @NotNull
   private FuelType fuel;
   
   @Min(1)
   private int power;
   
   @NotNull
   @PastOrPresent
   @DateTimeFormat(pattern="dd/MM/yyyy")
   private LocalDate entryIntoService;

   @NotNull
   @Pattern(regexp="^[0-9]-[A-Z]{3}-[0-9]{3}$")
   private String plate;
   
   @NotNull
   @DecimalMin("0")
   @Digits(integer=10,fraction=2)
   @NumberFormat(style=Style.NUMBER)
   private float listPrice;   
   
   private boolean towBar;   
   
   @NotNull
   private TransmissionType transmission;   
   
   private String[] options;
   
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

   public FuelType getFuel() {
      return fuel;
   }

   public void setFuel(FuelType fuel) {
      this.fuel = fuel;
   }

   public int getPower() {
      return power;
   }

   public void setPower(int power) {
      this.power = power;
   }

   public LocalDate getEntryIntoService() {
      return entryIntoService;
   }

   public void setEntryIntoService(LocalDate entryIntoService) {
      this.entryIntoService = entryIntoService;
   }

   public String getPlate() {
      return plate;
   }

   public void setPlate(String plate) {
      this.plate = plate;
   }

   public float getListPrice() {
      return listPrice;
   }

   public void setListPrice(float listPrice) {
      this.listPrice = listPrice;
   }

   public boolean isTowBar() {
      return towBar;
   }

   public void setTowBar(boolean towBar) {
      this.towBar = towBar;
   }

   public TransmissionType getTransmission() {
      return transmission;
   }

   public void setTransmission(TransmissionType transmission) {
      this.transmission = transmission;
   }

   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
   }

   public String[] getOptions() {
      return options;
   }

   public void setOptions(String[] options) {
      this.options = options;
   }
}
