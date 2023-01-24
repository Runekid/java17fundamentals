package exercise15_04.graphics;

import java.util.*;

public class DrawingApp {   
   @SuppressWarnings("rawtypes")
   public static void main(String[] args) {
      Drawing drawing = new Drawing();
      
      drawing.add(new Rectangle(5,6));
      drawing.add(new Square(5));
      drawing.add(new Triangle(4,8,6));
      drawing.add(new IsoScelesTriangle(7,8));
      drawing.add(new Circle(7));
      
      Iterator it = drawing.iterator();
      while(it.hasNext()) {
         Drawable d = (Drawable) it.next();
         System.out.println(d);
      }
      
      for(Object o: drawing) {
         Drawable d = (Drawable) o;
         System.out.println(d);
      }

      drawing.remove(new Circle(7));
      
      for(Object o: drawing) {
         Drawable d = (Drawable) o;
         System.out.println(d);
      }
   }   
}
