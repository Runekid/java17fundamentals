package exercise18_01.graphics;

/**Drawable objects
 * 
 * @author No&euml;l Vaes
 * @version 1.0
 */
public interface Drawable extends Scaleable{
   /**
    * Draw the object on the drawing context.
    * 
    * @param dc
    *           Drawing context.
    */
   public void draw(DrawingContext dc);
}
