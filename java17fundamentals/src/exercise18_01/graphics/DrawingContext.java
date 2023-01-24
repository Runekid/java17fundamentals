package exercise18_01.graphics;

/**
 * This interfaces represents the drawing contect.
 * 
 * @author Noel Vaes
 *
 */
public interface DrawingContext {
   /**
    * Draw a circle in the context.
    * 
    * @param circle
    *           The circle.
    */
   public void draw(Circle circle);

   /**
    * Draw a rectangle in the context
    * 
    * @param rectangle
    *           The rectangle.
    */
   public void draw(Rectangle rectangle);

   /**
    * Draw a triangle in the context
    * 
    * @param triangle
    *           The triangle.
    */
   public void draw(Triangle triangle);
}
