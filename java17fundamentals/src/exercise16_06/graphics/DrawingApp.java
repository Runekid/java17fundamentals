package exercise16_06.graphics;

public class DrawingApp {   
   public static void main(String[] args) {
      Drawing drawing = new Drawing();      
      drawing.add(new Rectangle(5,6));
      drawing.add(new Square(5));
      drawing.add(new Triangle(4,8,6));
      drawing.add(new IsoScelesTriangle(7,8));
      drawing.add(new Circle(-7));
            
      for(Object s: drawing) {
         System.out.println(s);
      }


      drawing.remove(new Circle(7));
      for(Object s: drawing) {
         System.out.println(s);
      }
   }   
}
