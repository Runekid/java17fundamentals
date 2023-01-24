package exercise15_04.graphics;

public class TextDrawingContext implements DrawingContext {

   @Override
   public void draw(Circle circle) {
      System.out.println("Draw circle " + circle);
   }

   @Override
   public void draw(Rectangle rectangle) {
      System.out.println("Draw rectangle " + rectangle);
   }

   @Override
   public void draw(Triangle triangle) {
      System.out.println("Draw triangle " + triangle);
   }
}
