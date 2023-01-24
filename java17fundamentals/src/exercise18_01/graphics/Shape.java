package exercise18_01.graphics;
/**
 * This class represents a graphical shape
 * 
 * @author No&euml;l Vaes
 * @version 1.0
 */

/**
 * @author Noel
 *
 */
public abstract class Shape implements Drawable {
   private int x;
   private int y;
   private static int count = 0;

   {
      count++;
   }

   /**Create shape on postion (0,0)
    * 
    */
   public Shape() {
      this(0, 0);
   }


   /** Create a shape on the specified postion.
    * @param x X postion.
    * @param y Y position
    */
   public Shape(int x, int y) {
      this.x = x;
      this.y = y;
   }

   /**Set the X position
    * @param x The X postion.
    */
   public void setX(int x) {
      this.x = x;
   }
   /**
    * Get the X-position
    * 
    * @return The X-position
    */
   public int getX() {
      return x;
   }

   /**Set the Y postion
    * @param y The y position
    */
   public void setY(int y) {
      this.y = y;
   }

   /**
    * Get the Y-position
    * 
    * @return The y-position
    */
   public int getY() {
      return y;
   }
   /**
    * The the postion.
    * 
    * @param x
    *           X-position
    * @param y
    *           Y-position
    */
   public void setPosition(int x, int y) {
      this.x = x;
      this.y = y;
   }

   /**
    * Get the number of object of this class.
    * 
    * @return The number of objects.
    */
   public static int getCount() {
      return count;
   }

   /**
    * Get the shape area.
    * 
    * @return The shape area.
    */
   public abstract double getArea();
   /**
    * Get the shape perimeter
    * 
    * @return The shape perimeter
    */
   public abstract double getPerimeter();

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + x;
      result = prime * result + y;
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Shape other = (Shape) obj;
      if (x != other.x)
         return false;
      if (y != other.y)
         return false;
      return true;
   }
}
