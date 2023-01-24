package exercise13_02.graphics;


public class DrawingApp {
   public static void main(String[] args) {
      Drawing drawing = new Drawing();
      DrawingContext dc = new TextDrawingContext();

      drawing.add(new Rectangle(5, 6));
      drawing.add(new Square(3));
      drawing.add(new Circle(7));

      drawing.draw(dc);

      drawing.scaleDouble();

      drawing.draw(dc);

      drawing.scale(60);

      drawing.draw(dc);

      System.out.println(drawing);
   }
}
