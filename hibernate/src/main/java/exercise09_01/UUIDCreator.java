package exercise09_01;

import javax.persistence.*;
import java.util.*;

public class UUIDCreator {
   @PrePersist
   public void createUUID(Person p) {
      if(p.getUUID() == null) {
         p.setUUID(UUID.randomUUID().toString());
      }
   }

}
