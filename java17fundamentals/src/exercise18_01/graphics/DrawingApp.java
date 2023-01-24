package exercise18_01.graphics;

import java.util.*;

public class DrawingApp {   
   public static void main(String[] args) {
      Drawing drawing = new Drawing();
      
      drawing.add(new Rectangle(5,6));
      drawing.add(new Square(5));
      drawing.add(new Triangle(4,8,6));
      drawing.add(new IsoScelesTriangle(7,8));
      drawing.add(new Circle(7));
      
      Iterator<Drawable> it = drawing.iterator();
      it.hasNext();
      it.hasNext();
      
      while(it.hasNext()) {
         System.out.println(it.next());
      }
      
      for(Drawable s: drawing) {
         System.out.println(s);
      }

      drawing.remove(new Circle(7));
      
      
      for(Drawable s: drawing) {
         System.out.println(s);
      }
   }   
}
