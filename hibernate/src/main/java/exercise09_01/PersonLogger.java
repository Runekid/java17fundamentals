package exercise09_01;

import javax.persistence.*;

public class PersonLogger {
   @PrePersist
   public void prePersist(Person p) {
      System.out.println(p.getId() + ": prePersist");
   }

   @PostPersist
   public void postPersist(Person p) {
      System.out.println(p.getId() + ": postPersist");
   }

   @PostLoad
   public void postLoad(Person p) {
      System.out.println(p.getId() + ": postLoad");
   }

   @PreUpdate
   public void preUpdate(Person p) {
      System.out.println(p.getId() + ": preUpdate");
   }

   @PostUpdate
   public void postUpdate(Person p) {
      System.out.println(p.getId() + ": postUpdate");
   }

   @PreRemove
   public void preRemove(Person p) {
      System.out.println(p.getId() + ": preRemove");
   }

   @PostRemove
   public void postRemove(Person p) {
      System.out.println(p.getId() + ": postRemove");
   }
}
