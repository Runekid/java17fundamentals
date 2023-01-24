package be.onurbugdayci.beers.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Categories")
public class Category implements Serializable{
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="Id")
   private int id;
   
   @Column(name="Category")
   private String name;

   @OneToMany(mappedBy="category")
   private Set<Beer> beers = new HashSet<Beer>();

   @XmlTransient
   @JsonIgnore
   public Set<Beer> getBeers() {
      return beers;
   }

   public void setBeers(Set<Beer> beers) {
      this.beers = beers;
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   
   public String toString() {
      return name;
   }
}
